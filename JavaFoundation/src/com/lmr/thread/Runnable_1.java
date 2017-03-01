package com.lmr.thread;

public abstract class Runnable_1 implements Runnable{

	private int num=0;
	
	private Boolean flag = false;
	private Object lock=new Object();
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		
		if(flag){
			synchronized (lock) {
				lock.notify();
			}
		}
		
		this.flag = flag;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			synchronized (lock) {//该线程的锁是Object类型的lock变量
			
				if(!flag){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
//				System.out.println(num++);
				
//				for(int i=0;i<10;i++){
//					if(!flag){
//						try {
//							lock.wait();
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//					System.out.println(i);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
			}
			
			this.runPersonelLogic();
			
		}
		
	}

	protected abstract void runPersonelLogic();

}
