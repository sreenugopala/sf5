package com.sreenivaasamu.demoz.sf5.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sreenivaasamu.demoz.sf5.demo.service.impl.MissileLauncherImpl;

@Controller
public class PropertyInjectedController {

	@Autowired
    public MissileLauncherImpl launcherService;

    public String launch(){
        return launcherService.launch("Brahmos");
    }

}