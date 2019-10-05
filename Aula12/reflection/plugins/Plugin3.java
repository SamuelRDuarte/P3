package Aula12.reflection.plugins;

import Aula12.reflection.IPlugin;

public class Plugin3 implements IPlugin {

	@Override
	public void fazQualQuerCoisa() {
		System.out.println("Plugin3 locked and loaded");
	}

}
