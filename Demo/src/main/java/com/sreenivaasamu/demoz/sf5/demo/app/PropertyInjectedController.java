package com.sreenivaasamu.demoz.sf5.demo.app;

import com.sreenivaasamu.demoz.sf5.demo.service.impl.MissileLauncherImpl;

public class PropertyInjectedController {

    public MissileLauncherImpl launcherService;

    public String launch(){
        return launcherService.launch("Brahmos");
    }

}