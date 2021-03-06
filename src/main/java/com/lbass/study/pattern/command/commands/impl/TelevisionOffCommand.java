package com.lbass.study.pattern.command.commands.impl;

import com.lbass.study.pattern.command.commands.Command;
import com.lbass.study.pattern.command.receivers.Television;

public class TelevisionOffCommand implements Command {

	Television television;
	
	public TelevisionOffCommand(Television television) {
		this.television = television;
	}

	public void execute() {
		television.on();
	}
	
	public void undo() {
		television.off();
	}

}
