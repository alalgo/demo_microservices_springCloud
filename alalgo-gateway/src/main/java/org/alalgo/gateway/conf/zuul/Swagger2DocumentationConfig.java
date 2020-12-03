package org.alalgo.gateway.conf.zuul;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
/**
 * 
* @Description: 将多个微服务中api集合起来，每个微服务为一个SwaggerResource。
* 自动遍历注册中心所有微服务，将其转为SwaggerResource加入Swagger中，请求会被转发到微服务上的/v2/api-docs接口获得到Swagger的JSON文档，从而实现汇总加载内容。
* @author security
* @date 2019年4月18日
*
 */
@Component
@Primary
@Slf4j
public class Swagger2DocumentationConfig implements SwaggerResourcesProvider {
	@Autowired
    private RouteLocator routeLocator;
    
	@Override
	public List<SwaggerResource> get() {
		    List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
	        List<Route> routes = routeLocator.getRoutes();
	        routes.forEach(route -> 
	        	{
	        		log.info("zuul route:" + route);
		        	resources.add(
		        			swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"), "2.0")
		        	);
	        	}
	        );
	        return resources;
	}
    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
