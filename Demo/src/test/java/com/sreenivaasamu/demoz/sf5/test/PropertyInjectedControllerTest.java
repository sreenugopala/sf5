package com.sreenivaasamu.demoz.sf5.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sreenivaasamu.demoz.sf5.demo.app.PropertyInjectedController;
import com.sreenivaasamu.demoz.sf5.demo.service.impl.MissileLauncherImpl;

public class PropertyInjectedControllerTest {

	private PropertyInjectedController propertyInjectedController;

	@BeforeEach
	public void setUp() throws Exception {
		this.propertyInjectedController = new PropertyInjectedController();
		this.propertyInjectedController.missileLauncherImpl = new MissileLauncherImpl();
	}

	@Test
	public void testLaunch() throws Exception {
		assertTrue(propertyInjectedController.launch().indexOf("Brahmos") > -1);
	}
}
