package cn.keepting.spider.pool;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * @Author: xufuhao
 * @Date: 2019/5/9 13:30.
 */
public class PageUrlPool {

    static List<String> urls;

   public static void init() throws IOException {
       urls = Files.readAllLines(Paths.get(System.getProperty("user.dir")+"/static/urls.txt"), Charset.defaultCharset());
    }

    public static String randomUrl(){
        return urls==null?null:urls.get(new Random().nextInt(urls.size()));
    }
}
