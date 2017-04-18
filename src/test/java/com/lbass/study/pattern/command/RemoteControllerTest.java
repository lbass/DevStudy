package com.lbass.study.pattern.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lbass.study.pattern.command.commands.impl.LightOffCommand;
import com.lbass.study.pattern.command.commands.impl.LightOnCommand;

public class RemoteControllerTest {

	public static void main(String[] args) throws IOException {
		RemoteController controller = new RemoteController();
		Runner runner = new Runner();
		runner.run(2, controller);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (String input = br.readLine(); !input.equals("q!"); input = br.readLine()) {
			switch(input) {
				case "on" :
					controller.setCommands(new LightOnCommand(new Light()));
					break;
				case "off" :
					controller.setCommands(new LightOffCommand(new Light()));
					break;
				case "undo" :
					controller.executeUndoCommand();
					break;
				default :
					break;
			}
		}
	}

}
