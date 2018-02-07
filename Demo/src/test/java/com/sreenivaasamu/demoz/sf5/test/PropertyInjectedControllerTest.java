package com.sreenivaasamu.demoz.sf5.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sreenivaasamu.demoz.sf5.demo.app.PropertyInjectedController;
import com.sreenivaasamu.demoz.sf5.demo.service.impl.MissileLauncherImpl;


public class PropertyInjectedControllerTest {

	private PropertyInjectedController propertyInjectedController;

	@Before
	public void setUp() throws Exception {
		this.propertyInjectedController = new PropertyInjectedController();
		this.propertyInjectedController.launcherService = new MissileLauncherImpl();
	}

	@Test
	public void testLaunch() throws Exception {
		assertTrue(propertyInjectedController.launch().indexOf("Brahmos") > -1);
	}
}
