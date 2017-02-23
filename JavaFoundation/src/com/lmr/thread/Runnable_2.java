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

	private synchronized void process() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 50; i++) {

			if (flag == true) {
				System.out.println(i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
