package com.sreenivaasamu.demoz.sf5.demo.service.impl;

import java.util.Formatter;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sreenivaasamu.demoz.sf5.demo.service.MissileLauncher;

@Service
@Primary
@Profile("nuclear")
public class FighterMissileLauncherImpl implements MissileLauncher {

	@Override
	public String launch(String missile) {

		StringBuilder buffer = new StringBuilder();
		Formatter formatter = new Formatter(buffer);
		try {
			formatter.format("Missile [%1$s] launched from Fighter %n", missile);

			return buffer.toString();
		} finally {
			formatter.close();
		}
	}
}
