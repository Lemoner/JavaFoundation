package com.lmr.concurrent.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;

public class MyService2 {

	private Phaser phaser;
	private Random random = new Random();

	public MyService2() {

		phaser = new Phaser(3) {
			@Override
			protected boolean onAdvance(int phase, int registeredParties) {
				
				System.out.println((phaser.getPhase()+1)+" - Round  All is end "+phaser.getRegisteredParties());
				
				return false;
//				return true;
			}
		};

	}
	
	public void method1() {

		try {
			System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
			Thread.sleep((random.nextInt(10)+1)*100 );
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
			phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
			Thread.sleep((random.nextInt(10)+1)*100 );
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
			phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
			Thread.sleep((random.nextInt(10)+1)*100 );
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
			phaser.arriveAndAwaitAdvance();
			
//			while(true){
//				System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
//				Thread.sleep((random.nextInt(10)+1)*100 );
//				System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
//				phaser.arriveAndAwaitAdvance();
//			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void method2() {

		try {
			System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
			Thread.sleep((random.nextInt(10)+1)*100 );
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
			phaser.arrive();
//			phaser.arriveAndAwaitAdvance();
//			phaser.arriveAndDeregister();
			
//			while(true){
//				if (phaser.getPhase() % 2 == 0) {
//					System.out.println(Thread.currentThread().getName() + " is start " + System.currentTimeMillis());
//					Thread.sleep((random.nextInt(10) + 1) * 100);
//					System.out.println(Thread.currentThread().getName() + " is end " + System.currentTimeMillis());
//					phaser.arriveAndDeregister();
//				}
//			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
