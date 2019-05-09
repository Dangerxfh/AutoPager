package cn.keepting.spider;

/**
 * @Author: xufuhao
 * @Date: 2019/5/9 13:14.
 */
//配置
public class Constant {
    /*
        是否执行页面js  0:否，1：是（默认执行）
        因为有些个人网站是通过执行统计平台的js代码，所以一般个人网站需要将此值设置为1
     */
    static int executeJs=1;
    static final String GAONI_IP_URL = "http://www.66ip.cn/nmtq.php?getnum=300&isp=0&anonymoustype=4&start=&ports=&export=&ipaddress=&area=1&proxytype=2&api=66ip";
//    static final String CHROM_DRIVER_PATH="D:\\插件\\chromedriver_win32\\chromedriver.exe";
}
