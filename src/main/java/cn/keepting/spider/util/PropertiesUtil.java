package cn.keepting.spider.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @Author: xufuhao
 * @Date: 2019/5/9 16:01.
 */
public class PropertiesUtil{

    public static Properties getConfig(String path){
        Properties props=null;
        try{
            props = new Properties();
            InputStream in = ClassLoader.getSystemResourceAsStream(path);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            props.load(bf);
            in.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return props;
    }
}
