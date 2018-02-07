package com.sreenivaasamu.demoz.sf5.demo.app;

import com.sreenivaasamu.demoz.sf5.demo.service.MissileLauncher;

public class ConstructorInjectedController {

	private MissileLauncher launcherService;

	public ConstructorInjectedController(MissileLauncher launcherService) {
		this.launcherService = launcherService;
	}

	public String launch() {
		return launcherService.launch("Kali");
	}
}