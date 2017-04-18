package com.lbass.study.pattern.command;

import com.lbass.study.pattern.command.commands.impl.LightOffCommand;
import com.lbass.study.pattern.command.commands.impl.LightOnCommand;
import com.lbass.study.pattern.command.receivers.Light;

public class TreadSafeTest {

	public static void main(String[] args) {
		final RemoteController controller = new RemoteController();
        Thread run1 = new Thread() {
            public void run() {
                while (true) {
                	controller.setCommands(new LightOnCommand(new Light()));
                	controller.executeCommands();
                }
            }
        };
        
        Thread run2 = new Thread() {
            public void run() {
                while (true) {
                	controller.setCommands(new LightOffCommand(new Light()));
                	controller.executeCommands();
                }
            }
        };
        
        Thread undo1 = new Thread() {
            public void run() {
                while (true) {
                	controller.executeUndoCommand();
                }
            }
        };
        
        Thread undo2 = new Thread() {
            public void run() {
                while (true) {
                	controller.executeUndoCommand();
                }
            }
        };
        
        run1.start();
        undo1.start();
        run2.start();
        undo2.start();
	}
}
