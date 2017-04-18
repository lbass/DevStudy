package com.lbass.study.pattern.command.commands.impl;

import com.lbass.study.pattern.command.commands.Command;
import com.lbass.study.pattern.command.receivers.Light;

public class LightOffCommand implements Command {

	Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}
	
	public void undo() {
		light.on();
	}


}