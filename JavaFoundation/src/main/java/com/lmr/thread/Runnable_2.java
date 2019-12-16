package com.lmr.thread;

public class Runnable_2 implements Runnable {

	private boolean flag = true;

	int count = 0;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		process();
	}

	private synchronized void process() {//该线程的锁是实例化该Runnable线程的对象
		// TODO Auto-generated method stub

		for (int i = 0; i < 50; i++) {

//			if (flag == true) {
//				System.out.println(i);
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("+++"+i);
//			} else {
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			System.out.println("//*****"+i);
			
			if(flag!=true){
				try {
					System.out.println("============="+i);
					wait();
					System.out.println("........."+i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("+++"+i);

		}

	}

}
