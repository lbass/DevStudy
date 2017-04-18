package com.lbass.study.pattern.command.commands;

/**
 * Command들의 인터페이스.
 * @author dowonkim
 *
 */
public interface Command {

	public void execute();
	
	public void undo();
	
}
