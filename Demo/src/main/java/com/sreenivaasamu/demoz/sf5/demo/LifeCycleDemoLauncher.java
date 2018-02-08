package com.sreenivaasamu.demoz.sf5.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sreenivaasamu.demoz.sf5.demo.app.LifeCycleDemo;

@SpringBootApplication
public class LifeCycleDemoLauncher {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		try {
			ctx = SpringApplication.run(LifeCycleDemoLauncher.class, args);

			LifeCycleDemo demoBean = (LifeCycleDemo) ctx.getBean("lifeCycleDemo");
		} finally {
			if (ctx != null) {
				((ConfigurableApplicationContext) ctx).close();
			}
		}

	}

}
