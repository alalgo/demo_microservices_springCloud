package org.alalgo.gateway.conf.zuul;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
/**
 * 
* @Description: 实现路由熔断：当某个服务出现异常时，返回我们预设的信息。
* @author security
* @date 2019年2月18日
*
 */
@ComponentScan
public class ProducerFallback implements FallbackProvider {
    //告诉Zuul它是负责哪个route定义的熔断。
	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		return "eureka-service";
	}
	/**
	 * 告诉 Zuul 断路出现时，它会提供一个什么返回值来处理请求。
	 */
	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		// TODO Auto-generated method stub
		return new ClientHttpResponse() {

			@Override
			public InputStream getBody() throws IOException {
				// TODO Auto-generated method stub
				return new ByteArrayInputStream("The service is unavailable.".getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return 200;
			}

			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return "OK";
			}

			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
}
