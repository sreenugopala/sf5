package com.sreenivaasamu.demoz.sf5.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.sreenivaasamu.demoz.sf5.demo.app.ConstructorInjectedController;
import com.sreenivaasamu.demoz.sf5.demo.app.MyController;
import com.sreenivaasamu.demoz.sf5.demo.app.PropertyInjectedController;
import com.sreenivaasamu.demoz.sf5.demo.app.SetterInjectedController;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class DemoLauncher {

	private static final Logger logger = LogManager.getLogger(DemoLauncher.class);
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoLauncher.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		logger.info(controller.launch());
		logger.info(ctx.getBean(PropertyInjectedController.class).launch());
		logger.info(ctx.getBean(SetterInjectedController.class).launch());
		logger.info(ctx.getBean(ConstructorInjectedController.class).launch());
	}
}