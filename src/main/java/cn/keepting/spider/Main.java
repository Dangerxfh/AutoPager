package cn.keepting.spider;

import cn.keepting.spider.pool.PageUrlPool;
import cn.keepting.spider.pool.UaPool;
import cn.keepting.spider.util.Configure;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @Author: xufuhao
 * @Date: 2019/5/9 13:12.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UaPool.init();
        PageUrlPool.init();


        if(StringUtils.equals("win",Configure.getSystem())){
            System.out.println("项目路径"+System.getProperty("user.dir"));
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/static/chromedriver_win.exe");
        }else{
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/static/chromedriver_"+Configure.getSystem()+"_"+Configure.getSysDigit());
        }

        //chromedriver
        GaoniIpSpider.spider();
    }
}
