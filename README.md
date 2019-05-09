## AutoPager
#### 自动抓取高匿代理，并模拟访问页面

### :beetle: 项目简介： 
  程序主要利用超级匿名ip（来自[66免费代理](http://www.66ip.cn/)）实现网页的模拟访问，目前测试成功率为20%（正在优化），通过简单的配置即可运行。
  
### :beetle: 流程介绍：  
  在urls.txt中随机选择url，然后在user_agent.txt中随机选择ua，通过chromdriver 实现ip实时抓取，这个需要弹出页面（有点尴尬），
  后期尝试phantomJs和chrome headless 版本实现。
### :beetle: 框架支持：
 - selenium 3.14.0
 - htmlunit 2.18
### :beetle: 运行步骤：

:pushpin: 将要抓取的url配置到项目static/urls.txt文件中，每个url一行

:pushpin: 在Constant 类中配置executeJs属性（是否执行页面js代码  0：不执行，1：执行，默认是执行）

:pushpin: 运行Main.java 中的 main方法


