package com.sreenivaasamu.demoz.sf5.demo.app;

import com.sreenivaasamu.demoz.sf5.demo.service.MissileLauncher;

public class SetterInjectedController {
	private MissileLauncher launcherService;

	public String launcherService() {
		return launcherService.launch("Agni");
	}

	public void setGreetingService(MissileLauncher launcherService) {
		this.launcherService = launcherService;
	}
}