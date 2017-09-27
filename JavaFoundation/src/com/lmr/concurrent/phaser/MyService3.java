package com.lmr.concurrent.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;

public class MyService3 {

	private Phaser phaser;
	private Random random = new Random();

	public MyService3() {

		phaser = new Phaser(3) {
			@Override
			protected boolean onAdvance(int phase, int registeredParties) {
				
				System.out.println("All is end "+phaser.getPhase()+" "+phaser.getRegisteredParties());
				
				return false;
//				return true;
			}
		};

	}
	
	public void method1() {

		try {
			System.out.println(phaser.getArrivedParties());
			while(true){
				System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
				Thread.sleep((random.nextInt(10)+1)*100 );
				System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
				phaser.arriveAndAwaitAdvance();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void method2() {

		try {
			int x=1;
			while(true){
				if(x%2==0){
					System.out.println(Thread.currentThread().getName()+" is start "+System.currentTimeMillis());
					Thread.sleep((random.nextInt(10)+1)*100 );
					System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
					System.out.println("phaser.getPhase() "+phaser.getPhase());
					phaser.awaitAdvance(x);
				}
				else{
					System.out.println(x);
					x=x*2;
				}
			}
//			phaser.arrive();
//			phaser.arriveAndAwaitAdvance();
//			phaser.arriveAndDeregister();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
