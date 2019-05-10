## AutoPager
#### 自动抓取超级匿名代理ip，并模拟访问页面

### :beetle: 项目简介： 
  程序主要利用超级匿名ip（来自[66免费代理](http://www.66ip.cn/)）实现网页的模拟访问，目前测试成功率为20%（正在优化），通过简单的配置即可运行。
  
### :beetle: 流程介绍：  
  在urls.txt中随机选择url，然后在user_agent.txt中随机选择ua，通过chromedriver headless 模式实现ip实时抓取。
### :beetle: 框架支持：
 - selenium 3.14.0
 - htmlunit 2.18
### :beetle: 运行步骤：

 :pushpin: 首先关闭服务器代理（如蓝灯）
 
 :pushpin: 将要抓取的url配置到项目static/urls.txt文件中，每个url一行

 :pushpin: 在config.properties 中配置属性

 - sysType : 系统类型（win/mac/linux）
 
 - sysDigit : 系统位数（32 or 64）
 
 - execute_js : 是否执行页面js代码  （false：不执行，true：执行，默认是执行）
    
 - refresh_rate : ip刷新频率（单位分钟，默认5分钟）
 
 - thread_pool_capcity=10 : 线程池容量 （最大30）
 
 - ua_pool_count=5 : UA池 容量 (最大40)，此值越大，PV与UV的比例越小  一般来说 PV数比UV数大20% ，）
 
 - min_stay_time=10 : 最小页面停留时长(单位：秒）
 
 - max_stay_time=20 : 最大页面停留时长（单位：秒）

:pushpin: 运行Main.java 中的 main方法


