package com.lbass.study.pattern.command.commands.impl;

import com.lbass.study.pattern.command.commands.Command;
import com.lbass.study.pattern.command.receivers.Stereo;

public class StereoOffWithCDCommand implements Command {

	private Stereo stereo;
	
	public StereoOffWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	public void execute() {
		stereo.off();
		
	}

	public void undo() {
		stereo.on();
	}

}