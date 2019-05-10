package cn.keepting.spider.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * @Author: xufuhao
 * @Date: 2019/5/9 16:04.
 */
public class Configure {
//    public static Properties prop = PropertiesUtil.getConfig("config.properties");
    static ResourceBundle bundle = ResourceBundle.getBundle("config");

    //默认页面停留时长
    static final Integer DEFAULT_STAYTIME=10;

    public static Integer getRefreshIpRate(){
        return Integer.valueOf(bundle.getString("refresh_rate"));
    }


    //系统类型
    public static String getSystem(){
        return bundle.getString("sysType");
    }

    //系统位数
    public static String getSysDigit(){
        return bundle.getString("sysDigit");
    }
    //是否执行js
    public static boolean isExecuteJs(){
        String executejs=bundle.getString("execute_js");
        return StringUtils.isBlank(executejs)?true: Boolean.parseBoolean(executejs);
    }

    //
    public static String gaoniIpUrl(){
        return bundle.getString("gaoni_ip_url");
    }

    public static Integer uaPoolCount(){
        return Integer.valueOf(bundle.getString("ua_pool_capcity"));
    }
    public static Integer threadPoolCount(){
        return Integer.valueOf(bundle.getString("thread_pool_capcity"));
    }

    public static Integer minStayTime(){
        if(!StringUtils.isNumeric(bundle.getString("min_stay_time"))){
            return null;
        }
        return Integer.valueOf(bundle.getString("min_stay_time"));
    }

    public static Integer maxStayTime(){
        if(!StringUtils.isNumeric(bundle.getString("max_stay_time"))){
            return null;
        }
        return Integer.valueOf(bundle.getString("max_stay_time"));
    }

    public static Integer stayTime(){
        if( Configure.maxStayTime()==null || Configure.minStayTime()==null
                ||Configure.maxStayTime()<Configure.minStayTime()){
            return DEFAULT_STAYTIME;
        }
        return new Random().nextInt(Configure.minStayTime())+(Configure.maxStayTime()-Configure.minStayTime());
    }

}
