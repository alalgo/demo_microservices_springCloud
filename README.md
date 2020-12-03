### 微服务组件
- service registry: eureka、Consul 、zookeeper、 hazelcast 、 etcd  
- gateway:  
- RPC: 负载均衡（fegin、Ribbon） + 请求客户端（WebClient 、 RestTemplate）
- 监控：

### 系统技术选型
- 注册中心：eurke    
- 网关：zuul   
- 服务间调用、熔断：fegin+hystrix  
- 认证授权：spring security+oauth2  
- ORM框架：mybatis  
- 数据库：mysql  
- 汇总接口文档：Swagger + zuul    
- 整合定时任务框架 Quartz scheduler  ，放在usc模块中  
- 熔断可视化监控：hystrix dashboard + turbine  
- 链路可视化监控：zipkin  
- 整合spring admin 监控  

### todo
- 服务间调用时进行验权：fegin+oauth2
- oauth2 server 后台数据库可配置
- 引入工作流引擎 Activiti
- elasticsearch 实现站内搜索
- 日志分析系统 ： ELK(Elasticsearch、Logstash、Kibana)
- 自动化部署运维
- 引入缓存机制提升性能
- 大部分系统都是读多写少，所以可通过数据读写分离集群提升性能（首先要实现数据库主(称master)从(称slave)复制），其中一个是主库，负责写入数据，我们称之为写库；其它都是从库，负责读取数据，我们称之为读库。
	有两种解决方案：应用层、中间件（mysql-proxy、Amoeba for MySQL）。
- 后台管理界面前端，用于监控系统，配置后台
- 整合配置中心 spring config
- 数据库分库分表

### 项目结构
- 构建工具 maven，springcloud-action为父maven，其中的几个文件夹为其子modules。    
- eureka-server 为注册中心    
- eureka-service、consumer-feign、consumer-ribbon均为微服务。    
- 模拟服务间互相调用，consumer-feign使用feign方式调用eureka-service、consumer-ribbon使用ribbon方式调用eureka-service      
