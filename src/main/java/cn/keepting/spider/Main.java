package cn.keepting.spider;

import cn.keepting.spider.pool.PageUrlPool;
import cn.keepting.spider.pool.UaPool;

import java.io.IOException;

/**
 * @Author: xufuhao
 * @Date: 2019/5/9 13:12.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UaPool.init();
        PageUrlPool.init();

        //chromedriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/static/chromedriver.exe");
        GaoniIpSpider.spider();
    }
}
