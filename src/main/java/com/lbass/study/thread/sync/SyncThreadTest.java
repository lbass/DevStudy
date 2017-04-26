package com.lbass.study.thread.sync;

import java.util.HashMap;

class SyncUser {
	private int userNo = 0;
	private HashMap<Integer, String> userInfo = new HashMap<Integer, String>();
	
	public synchronized void add(String name) {
		userNo = userNo + 1;
		userInfo.put(userNo, name);		
	}
	
	public void printData() {
		userInfo.forEach((k, v) -> System.out.println(k + ": " + v));
	}
}

class SyncUserThread extends Thread {
	SyncUser user;

	SyncUserThread(SyncUser user, String name) {
		super(name);
		this.user = user;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				user.add(getName());
			}				
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

public class SyncThreadTest {

	public static void main(String[] args) {

		SyncUser user = new SyncUser();

		// 3개의 스레드 객체 생성
		SyncUserThread syncT1 = new SyncUserThread(user, "A1");
		SyncUserThread syncT2 = new SyncUserThread(user, "B2");
		SyncUserThread syncT3 = new SyncUserThread(user, "C3");

		System.out.println("-----------------------");
		System.out.println("sychronized 적용");
		System.out.println("-----------------------");		
		
		// 스레드 시작
		syncT1.start();
		syncT2.start();
		syncT3.start();
		
		while(true) {
			if(syncT1.getState() == Thread.State.TERMINATED &&
					syncT2.getState() == Thread.State.TERMINATED &&
					syncT3.getState() == Thread.State.TERMINATED) {
				user.printData();
				break;
				
			}
		}
	}
}