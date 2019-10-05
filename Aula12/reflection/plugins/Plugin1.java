package Aula12.reflection.plugins;

import Aula12.reflection.IPlugin;

public class Plugin1 implements IPlugin{

	@Override
	public void fazQualQuerCoisa() {
		System.out.println("Plugin1 locked and loaded");	
	}

}
