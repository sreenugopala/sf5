package com.sreenivaasamu.demoz.sf5.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sreenivaasamu.demoz.sf5.demo.app.ConstructorInjectedController;
import com.sreenivaasamu.demoz.sf5.demo.app.MyController;
import com.sreenivaasamu.demoz.sf5.demo.app.PropertyInjectedController;
import com.sreenivaasamu.demoz.sf5.demo.app.SetterInjectedController;

@SpringBootApplication
public class DemoLauncher {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoLauncher.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		System.out.println(controller.launch());
		System.out.println(ctx.getBean(PropertyInjectedController.class).launch());
		System.out.println(ctx.getBean(SetterInjectedController.class).launch());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).launch());
	}
}