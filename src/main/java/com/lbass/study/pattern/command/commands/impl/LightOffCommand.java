package com.lbass.study.pattern.command.commands.impl;

import com.lbass.study.pattern.command.Light;
import com.lbass.study.pattern.command.commands.Command;

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