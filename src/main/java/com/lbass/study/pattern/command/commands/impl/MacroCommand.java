package com.lbass.study.pattern.command.commands.impl;

import com.lbass.study.pattern.command.commands.Command;

/**
 * 여러 커맨드를 한번에 실행 할 수 있는 커맨드이다.
 * @author dowonkim
 *
 */
public class MacroCommand implements Command {

    Command[] commands;
    public MacroCommand(Command[] commands){
        this.commands = commands;
    }
    
    public void execute() {
        for ( int i=0; i < commands.length; i++ ){
            commands[i].execute();
        }
    }

	public void undo() {
		// TODO Auto-generated method stub
		
	}

}