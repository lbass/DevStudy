package com.lbass.study.pattern.command.commands.impl;

import com.lbass.study.pattern.command.commands.Command;
import com.lbass.study.pattern.command.receivers.Light;

public class LightOnCommand implements Command {

	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}
	
	public void undo() {
		light.off();
	}

}