package com.sreenivaasamu.demoz.compscan;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private AtomicInteger step = new AtomicInteger(0);
	private static final Logger logger = LogManager.getLogger(LifeCycleDemo.class);

	public LifeCycleDemo() {
		logger.printf(Level.INFO, "[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}
	
	public void sayGovinda()
	{
		logger.printf(Level.INFO, "Jai Govinda%n");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.printf(Level.INFO, "[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@PostConstruct
	public void postConstruct() {
		logger.printf(Level.INFO, "[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@PreDestroy
	public void preDestroy() {
		logger.printf(Level.INFO, "[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@Override
	public void destroy() throws Exception {
		logger.printf(Level.INFO, "[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0){
		logger.printf(Level.INFO, "[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@Override
	public void setBeanFactory(BeanFactory arg0){
		logger.printf(Level.INFO, "[%1$s] [%2$s] %n", step.incrementAndGet(), getCallingMethodName());
	}

	@Override
	public void setBeanName(String arg0) {
		logger.printf(Level.INFO, "[%1$s] [%2$s] [%3$s] %n", step.incrementAndGet(), getCallingMethodName(), arg0);

	}

	public static String getCallingMethodName() {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[2].getMethodName();
	}
}
