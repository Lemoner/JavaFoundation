package com.lmr.concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyServicePC {

	private Semaphore setSemaphore = new Semaphore(10);
	private Semaphore getSemaphore = new Semaphore(20);
	private ReentrantLock lock = new ReentrantLock();
	private Condition setCondition = lock.newCondition();
	private Condition getCondition = lock.newCondition();
	private Object[] products = new Object[4];

	private boolean isFull() {

		boolean flag = true;

		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				flag = false;
				break;
			}
		}

		return flag;

	}

	private boolean isEmpty() {

		boolean flag = true;

		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				flag = false;
				break;
			}
		}

		return flag;

	}

	private int isExist() {

		int size = 0;

		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				size++;
			}
		}

		return size;

	}

	public void set() {

		try {
			setSemaphore.acquire();
			lock.lock();
			while (isFull()) {
				setCondition.await();
//				getCondition.signalAll();
			}
			for (int i = 0; i < products.length; i++) {
				if (products[i] == null) {
					products[i] = "product_" + (i + 1);
					System.out.println(Thread.currentThread().getName() + " is set " + products[i]+" isExist "+isExist());
					break;
				}
			}
			getCondition.signalAll();
			lock.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			setSemaphore.release();
		}

	}

	public void get() {

		try {
			getSemaphore.acquire();
			lock.lock();
			while (isEmpty()) {
				getCondition.await();
//				setCondition.signalAll();
			}
			for (int i = 0; i < products.length; i++) {
				if (products[i] != null) {
					System.out.println(Thread.currentThread().getName() + " is get " + products[i]+" isExist "+(isExist()-1));
					products[i] = null;
					break;
				}
			}
			setCondition.signalAll();
			lock.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getSemaphore.release();
		}

	}

}
