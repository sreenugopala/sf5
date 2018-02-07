package com.sreenivaasamu.demoz.sf5.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sreenivaasamu.demoz.sf5.demo.service.MissileLauncher;

@Controller
public class PropertyInjectedController {

	@Autowired
    public MissileLauncher missileLauncherImpl;

    public String launch(){
        return missileLauncherImpl.launch("Brahmos - From Primary, overriding variable name");
    }

}