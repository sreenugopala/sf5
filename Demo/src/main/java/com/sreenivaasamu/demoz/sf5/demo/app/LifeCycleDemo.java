package com.sreenivaasamu.demoz.sf5.demo.app;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nuclear")
public class LifeCycleDemo
		implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

	AtomicInteger step = new AtomicInteger(0);

	public LifeCycleDemo() {
		System.out.printf("[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.printf("[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@PostConstruct
	public void postConstruct() {
		System.out.printf("[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@PreDestroy
	public void preDestroy() {
		System.out.printf("[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@Override
	public void destroy() throws Exception {
		System.out.printf("[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.printf("[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.printf("[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.printf("[%1$s] [%2$s] [%3$s] %n", step.incrementAndGet(), getCallingMethodName(), arg0);

	}

	public static String getCallingMethodName() {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[2].getMethodName();
		// return Arrays.toString(ste);
	}
}
