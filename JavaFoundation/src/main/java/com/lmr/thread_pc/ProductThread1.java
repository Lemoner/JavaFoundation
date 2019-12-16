package com.lmr.thread_pc;

public class ProductThread1 extends Thread{

	private Product1 product;
	
	public ProductThread1(Product1 product) {
		this.product=product;
	}

	@Override
	public void run() {
		while(true){
			product.addCount();
		}
	}
	
	
}
