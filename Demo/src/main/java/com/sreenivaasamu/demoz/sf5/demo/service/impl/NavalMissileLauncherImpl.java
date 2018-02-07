package com.sreenivaasamu.demoz.sf5.demo.service.impl;

import java.util.Formatter;

import org.springframework.stereotype.Service;

import com.sreenivaasamu.demoz.sf5.demo.service.MissileLauncher;

@Service
public class NavalMissileLauncherImpl implements MissileLauncher {

	@Override
	public String launch(String missile) {

		StringBuilder buffer = new StringBuilder();
		Formatter formatter = new Formatter(buffer);
		try {
			formatter.format("Missile [%1$s] launched from Warship %n", missile);

			return buffer.toString();
		} finally {
			formatter.close();
		}
	}
}
