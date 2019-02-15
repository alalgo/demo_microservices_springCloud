构建工具 maven，springcloud-action为父maven，其中的几个文件夹为其子modules。  
eureka-server 为注册中心  
eureka-service、consumer-feign、consumer-ribbon均为微服务。  
模拟服务间互相调用，consumer-feign使用feign方式调用eureka-service、consumer-ribbon使用ribbon方式调用eureka-service  
