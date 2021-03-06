package com.sreenivaasamu.demoz.sf5.demo.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.sreenivaasamu.demoz.sf5.demo.service.MissileLauncher;

@Controller
public class MyController {

	private MissileLauncher launcher;

    public MyController(@Qualifier("surfaceMissileLauncherImpl") MissileLauncher launcher) {
        this.launcher = launcher;
    }

    public String launch(){
        System.out.println("Hello!!! ");
        return launcher.launch("Prithvi-V");
    }
}