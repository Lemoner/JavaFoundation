package com.lmr.thread_pc;

public class ProductThread2 extends Thread{

	private Product2 product;
	
	public ProductThread2(Product2 product) {
		this.product=product;
	}

	@Override
	public void run() {
		while(true){
			product.addCount();
		}
	}
	
	
}
