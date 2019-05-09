package cn.keepting.spider.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @Author: xufuhao
 * @Date: 2019/5/9 16:04.
 */
public class Configure {
//    public static Properties prop = PropertiesUtil.getConfig("config.properties");
    static ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static Integer getRefreshIpRate(){
        return Integer.valueOf(bundle.getString("refresh_rate"));
    }

    public static boolean isExecuteJs(){
        String executejs=bundle.getString("execute_js");
        return StringUtils.isBlank(executejs)?true: Boolean.parseBoolean(executejs);
    }

    public static String gaoniIpUrl(){
        return bundle.getString("gaoni_ip_url");
    }
}
