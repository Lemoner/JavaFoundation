package com.lmr.concurrent.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;

public class MyService1 {

	private Phaser phaser = new Phaser(3);
	private Random random = new Random();

	public void method1() {

		try {
			phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
			Thread.sleep((random.nextInt(10)+1)*100 );
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
			phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
			Thread.sleep((random.nextInt(10)+1)*100 );
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void method2() {

		try {
			phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
			Thread.sleep((random.nextInt(10)+1)*100 );
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
			phaser.arrive();
//			phaser.arriveAndAwaitAdvance();
//			phaser.arriveAndDeregister();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
