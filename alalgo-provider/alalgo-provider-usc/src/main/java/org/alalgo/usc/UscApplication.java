package org.alalgo.usc;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {RabbitAutoConfiguration.class})
public class UscApplication extends  SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(UscApplication.class, args);
      //@EnableRedisHttpSession//配置sessionrepositoryfilter进行请求拦截
      //@EnableEurekaClient
      //@EnableFeignClients
      //@EnableCircuitBreaker
    }
}