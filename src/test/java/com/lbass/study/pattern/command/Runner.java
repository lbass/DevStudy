package com.lbass.study.pattern.command;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Runner {

	public void run(int period, final RemoteController controller) {
		
		final ScheduledThreadPoolExecutor excuteRunner = 
				new ScheduledThreadPoolExecutor(1);
		excuteRunner.scheduleAtFixedRate(new Runnable() {
			public void run() {
				try {
					controller.executeCommands();
				} catch (Exception e) {
					e.printStackTrace();
					excuteRunner.shutdown();
				}
			}
		}, 0, period, TimeUnit.SECONDS);
	}
}
