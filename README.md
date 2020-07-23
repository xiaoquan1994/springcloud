#spring cloud
##1.简要说明
- eureka注册中心（port:8000）
>>eureka页面访问地址：http://127.0.0.1:8000
- config配置中心（port：8100）
- gateway网关（port：8200）
- admin服务监控（port：8300）
>>admin页面访问地址：http://127.0.0.1:8300<br/>
>>账号：admin<br/>
>>密码：123456
- oauth授权中心（port：8400）
- user用户管理（prot：8500）
- zipkin+sleuth链路追踪（port：9411）
>>运行：java -jar zipkin-server-2.12.9-exec.jar<br/>
>>文件下载地址：https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server
##2.项目启动顺序
>springcloud-eureka
>>springcloud-config
>>>springcloud-gateway
>>>>springcloud-admin<br/>
>>>>springcloud-oauth<br/>
>>>>springcloud-user<br/>
>>>>zipkin-server