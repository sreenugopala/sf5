package com.sreenivaasamu.demoz.postpro;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.sreenivaasamu.demoz.compscan.LifeCycleDemo;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		if (bean instanceof LifeCycleDemo) {
			System.out.printf("[%1$s] [%2$s] [%3$s] %n", "N/A ", getCallingMethodName(), beanName);
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof LifeCycleDemo) {
			System.out.printf("[%1$s] [%2$s] [%3$s] %n", "N/A ", getCallingMethodName(), beanName);
		}

		return bean;
	}

	public static String getCallingMethodName() {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[2].getMethodName();
	}
}