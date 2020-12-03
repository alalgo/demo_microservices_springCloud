package org.alalgo.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@zipkin2.server.internal.EnableZipkinServer
@EnableHystrixDashboard
@EnableTurbine
@EnableDiscoveryClient
@EnableAdminServer
public class MonitorApplication {

	public static void main(String[] args) {
    	SpringApplication.run(MonitorApplication.class, args);

	}

}
