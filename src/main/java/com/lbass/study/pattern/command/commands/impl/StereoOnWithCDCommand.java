package com.lbass.study.pattern.command.commands.impl;

import com.lbass.study.pattern.command.commands.Command;
import com.lbass.study.pattern.command.receivers.Stereo;

public class StereoOnWithCDCommand implements Command {

	private Stereo stereo;
	
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	public void execute() {
		stereo.on();
		
	}

	public void undo() {
		stereo.off();
	}

}