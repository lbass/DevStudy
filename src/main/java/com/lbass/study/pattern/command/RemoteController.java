package com.lbass.study.pattern.command;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.lbass.study.pattern.command.commands.Command;
import com.lbass.study.pattern.command.commands.impl.LightOnCommand;
import com.lbass.study.pattern.command.commands.impl.NoCommand;

/**
 * Command 들을 관리하고 있고 Command 의 execute() 를 호출해서 
 * Command 객체에게 특정 작업을 수행해 달라고 요청을 한다.
 * 
 * @author dowonkim
 *
 */
public class RemoteController {
	private BlockingQueue<Command> commands;
	private Command undoCommand;
	private Command noCommand;
	private int MAX_WAIT_COUNT = 7;
	
	private final Object syncObj = new Object();

	public RemoteController() {
		// initialize
		commands = new ArrayBlockingQueue<Command>(MAX_WAIT_COUNT);
		noCommand = new NoCommand();
		undoCommand = noCommand;
	}

	public void setCommands(Command command) {
		if (commands.size() >= MAX_WAIT_COUNT) {
			System.out.println("Please Wait");
		} else {
			commands.add(command);
		}
	}

	public void executeCommands() {
		// 실행한 command는 undo의 대상이 된다.
		try {
			Command target = commands.poll();
			if(target != null) {
				// excuteUndoCommand와 thread safe를 위해 동기화를 한다.
				synchronized (syncObj) {
					target.execute();
					undoCommand = target;
					//아래 구문은 thread safe의 test를 위한 구문이다.
					//System.out.print를 통해 디버깅은 하지 않는다.
					if (!(target.equals(undoCommand))) {
						System.out.println("out!!!");
						System.exit(-1);
					}
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void executeUndoCommand() {
		// 실행한 command는 undo의 대상이 된다.
		// executeCommands와 thread safe를 위해 동기화를 한다.
		synchronized (syncObj) {
			undoCommand.undo();
			undoCommand = new NoCommand();

		}
	}

}
