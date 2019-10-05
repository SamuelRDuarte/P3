package Aula12.reflection.plugins;

import Aula12.reflection.IPlugin;

public class Plugin2 implements IPlugin {

	@Override
	public void fazQualQuerCoisa() {
		System.out.println("Plugin2 locked and loaded");
	}

}
