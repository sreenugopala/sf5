package com.sreenivaasamu.demoz.sf5.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sreenivaasamu.demoz.sf5.demo.service.MissileLauncher;

@Controller
public class ConstructorInjectedController {

	private MissileLauncher launcherService;

	@Autowired
	public ConstructorInjectedController(MissileLauncher launcherService) {
		this.launcherService = launcherService;
	}

	public String launch() {
		return launcherService.launch("Kali");
	}
}