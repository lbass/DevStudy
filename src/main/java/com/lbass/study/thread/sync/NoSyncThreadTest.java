package com.lbass.study.thread.sync;

import java.util.HashMap;

class User {
	private int userNo = 0;
	private HashMap<Integer, String> userInfo = new HashMap<Integer, String>();

	// 임계 영역을 지정하는 synchronized메소드
	public void add(String name) {
		userNo = userNo + 1;
		userInfo.put(userNo, name);
	}
	
	public void printData() {
		userInfo.forEach((k, v) -> System.out.println(k + ": " + v));
	}
}

class UserThread extends Thread {
	User user;

	UserThread(User user, String name) {
		super(name);
		this.user = user;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			user.add(getName());
		}
	}
}


public class NoSyncThreadTest {

	public static void main(String[] args) {

		User user = new User();

		// 3개의 스레드 객체 생성
		UserThread unSyncT1 = new UserThread(user, "A1");
		UserThread unSyncT2 = new UserThread(user, "B2");
		UserThread unSyncT3 = new UserThread(user, "C3");

		System.out.println("-----------------------");
		System.out.println("sychronized 미적용");
		System.out.println("-----------------------");		
		
		// 스레드 시작
		unSyncT1.start();
		unSyncT2.start();
		unSyncT3.start();
		
		while(true) {
			if(unSyncT1.getState() == Thread.State.TERMINATED &&
					unSyncT2.getState() == Thread.State.TERMINATED &&
					unSyncT3.getState() == Thread.State.TERMINATED) {
				user.printData();
				break;
				
			}
		}
		
	}
}