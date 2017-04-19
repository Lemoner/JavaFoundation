package com.lmr.generic;

public class PointLink<T> {

	private PointLink<T> pre;
	private T self;
	private PointLink<T> next;
	
	public PointLink(){
		
	}
	
	public PointLink(PointLink<T> pre, T self, PointLink<T> next){
		this.pre=pre;
		this.self=self;
		this.next=next;
	}

	public PointLink<T> getPre() {
		return pre;
	}

	public void setPre(PointLink<T> pre) {
		this.pre = pre;
	}

	public T getSelf() {
		return self;
	}

	public void setSelf(T self) {
		this.self = self;
	}

	public PointLink<T> getNext() {
		return next;
	}

	public void setNext(PointLink<T> next) {
		this.next = next;
	}

}
