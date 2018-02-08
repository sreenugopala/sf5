package com.sreenivaasamu.demoz.sf5.demo.app;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.sreenivaasamu.demoz.sf5.demo.config.Battalion;
import com.sreenivaasamu.demoz.sf5.demo.service.MissileLauncher;

@Controller
public class ConstructorInjectedController {
	
	private static final Logger logger = LogManager.getLogger(ConstructorInjectedController.class);	

	private MissileLauncher launcherService;
	private Battalion battalion;

	@Autowired
	public ConstructorInjectedController(@Qualifier("surfaceMissileLauncherImpl") MissileLauncher launcherService,
			Battalion battalion) {
		this.launcherService = launcherService;
		this.battalion = battalion;
	}

	public String launch() {
		logger.printf(Level.INFO,"[%1$s] alerted %n",battalion.toString());
		return launcherService.launch("Kali");
	}
}