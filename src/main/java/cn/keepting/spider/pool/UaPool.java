package cn.keepting.spider.pool;

import cn.keepting.spider.util.Configure;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * @Author: xufuhao
 * @Date: 2019/5/9 13:16.
 */
public class UaPool {
    static List<String> uaList;
    public static void init() throws IOException {
        uaList= Files.readAllLines(Paths.get(System.getProperty("user.dir")+"/static/user_agent.txt"), Charset.defaultCharset());
        System.out.println("=====初始化UA_POOL=====\n容量："+Configure.uaPoolCount());
    }


    public static String randomUA(){
        return uaList==null?null:uaList.get(new Random().nextInt(Configure.uaPoolCount()>uaList.size()?uaList.size():Configure.uaPoolCount()));
    }
}
