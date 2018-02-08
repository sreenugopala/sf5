package com.sreenivaasamu.demoz.postpro;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.sreenivaasamu.demoz.compscan.LifeCycleDemo;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
	
	private static final Logger logger = LogManager.getLogger(CustomBeanPostProcessor.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName){

		if (bean instanceof LifeCycleDemo) {
			logger.printf(Level.INFO,"[%1$s] [%2$s] [%3$s] %n", "N/A ", getCallingMethodName(), beanName);
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName){
		if (bean instanceof LifeCycleDemo && beanName != null) {
			logger.printf(Level.INFO,"[%1$s] [%2$s] [%3$s] %n", "N/A ", getCallingMethodName(), beanName);
		}

		return bean;
	}

	public static String getCallingMethodName() {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[2].getMethodName();
	}
}