package com.sreenivaasamu.demoz.sf5.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sreenivaasamu.demoz.compscan.LifeCycleDemo;

@SpringBootApplication
@ComponentScan(basePackages= {"com.sreenivaasamu.demoz.compscan"})
public class LifeCycleDemoLauncher {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		try {
			ctx = SpringApplication.run(LifeCycleDemoLauncher.class, args);

			LifeCycleDemo demoBean = (LifeCycleDemo) ctx.getBean("lifeCycleDemo");
			demoBean.sayGovinda();
		} finally {
			if (ctx != null) {
				((ConfigurableApplicationContext) ctx).close();
			}
		}

	}

}
