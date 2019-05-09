package cn.keepting.spider;

import cn.keepting.spider.pool.PageUrlPool;
import cn.keepting.spider.pool.UaPool;
import cn.keepting.spider.util.Configure;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xufuhao
 * @Date: 2019/5/7 14:55.
 */
public class GaoniIpSpider {
    static ExecutorService executorService = Executors.newFixedThreadPool(10);


    public static void spider() throws Exception {
//        List<String> uas = Files.readAllLines(Paths.get("C:\\Users\\Administrator\\Desktop\\userAgents.txt"), Charset.defaultCharset());
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(Configure.gaoniIpUrl());
        Thread.sleep(2000);

        AtomicInteger count = new AtomicInteger(0);
        while (true) {
            //10min重新获取ip
            if ((System.currentTimeMillis() / 1000) % (Configure.getRefreshIpRate() * 60) == 0) {
                driver.navigate().refresh();
                Thread.sleep(2000);
                count = new AtomicInteger(0);
            }
            String ips = driver.findElement(By.tagName("body")).getText();
            List<String> ipAndPorts = Arrays.asList(ips.split("\\n"));
            if (ipAndPorts == null || ipAndPorts.size() <= 0) {
                return;
            }

            for (String ipAndPort : ipAndPorts) {
                AtomicInteger finalCount = count;
                executorService.execute(() -> {
                    String ip = StringUtils.substringBefore(ipAndPort, ":");
                    String port = StringUtils.substringAfter(ipAndPort, ":");

                    if (ip.contains(".")) {

                        WebClient webClient = getWebClient();

                        //随机ua
                        String UA = UaPool.randomUA();
                        webClient.addRequestHeader("User-Agent", UA);
                        String url = PageUrlPool.randomUrl();
                        try {
                            ProxyConfig proxyConfig = webClient.getOptions().getProxyConfig();
                            proxyConfig.setProxyHost(ip);
                            proxyConfig.setProxyPort(Integer.parseInt(port));
                            String result = webClient.getPage(url).getWebResponse().getContentAsString();
                            System.out.println("返回结果长度：" + result.length());
                            System.out.println("===" + finalCount.get() + "===代理ip访问：ip:" + ip + ":" + port + "======\n" + "UA:" + UA);
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            System.out.println("====" + finalCount.get() + "====访问异常：" + e.getMessage());
                        } finally {
                            finalCount.incrementAndGet();
                        }
                    }
                });
            }
        }
    }


    public static WebClient getWebClient() {
        WebClient webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(Configure.isExecuteJs());
        return webClient;
    }
}
