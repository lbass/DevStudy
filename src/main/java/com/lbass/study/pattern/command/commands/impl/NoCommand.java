package com.lbass.study.pattern.command.commands.impl;

import com.lbass.study.pattern.command.commands.Command;

/**
 * Client 에서 따로 null 처리를 하지 않아도 되도록 만들어 놓은 객체.
 * execute(), undo() 모두 아무 일도 하지 않는다.
 * @author dowonkim
 *
 */
public class NoCommand implements Command {

	public void execute() {
		// TODO Auto-generated method stub
		
	}

	public void undo() {
		// TODO Auto-generated method stub
		
	}

}