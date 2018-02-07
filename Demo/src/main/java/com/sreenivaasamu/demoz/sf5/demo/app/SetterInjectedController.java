package com.sreenivaasamu.demoz.sf5.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sreenivaasamu.demoz.sf5.demo.service.MissileLauncher;

@Controller
public class SetterInjectedController {
	private MissileLauncher launcherService;

	public String launch() {
		return launcherService.launch("Agni");
	}

	@Autowired
	public void setGreetingService(MissileLauncher launcherService) {
		this.launcherService = launcherService;
	}
}