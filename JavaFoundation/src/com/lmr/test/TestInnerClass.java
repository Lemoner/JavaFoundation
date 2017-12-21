package com.lmr.test;

import java.util.*;
public class TestInnerClass {
	
	public static void main(String[] args){
		ArrayList aa1=new ArrayList();//声明一个集合对象，里面可以放很多的东西
		System.out.println("大小为："+aa1.size());
		Xs xs1=new Xs("悟空",15,90);
		Xs xs2=new Xs("八戒",14,70);
		Xs xs3=new Xs("沙僧",13,75);
		Xs xs4=new Xs("小白龙",20,80);
		
//		TestInnerClass innerClass=new TestInnerClass();
//		Xs xs1=innerClass.new Xs("悟空",15,90);
//		Xs xs2=new Xs("八戒",14,70);
//		Xs xs3=new Xs("沙僧",13,75);
//		Xs xs4=new Xs("小白龙",20,80);
		
		aa1.add(xs1);//为集合里面添加内容
		aa1.add(xs2);
		aa1.add(xs3);
		System.out.println("大小为："+aa1.size());//输出此时集合的大小
		/*for(int i=0;i<aa1.size();i++){//遍历集合
			Xs tv=(Xs)aa1.get(i);//get为aa1的一个方法，和size()也是aa1的一个方法
			System.out.println("第"+(i+1)+"个学生的姓名是："+tv.getXingming());
		}*/
		//aa1.remove(1);//集合中节点的删除
		aa1.add(1,xs4);//不同参数添加，指定添加位置
		aa1.add(xs4);//添加在最后
		for(int i=0;i<aa1.size();i++){//再次遍历集合
			Xs tv=(Xs)aa1.get(i);
			System.out.println("第"+(i+1)+"个学生的姓名是"+tv.getXingming());
		}
	}

}
class Xs{//定义了一个学生类
	private String xingming;
	private int xuehao;
	private int chengji;
	public String getXingming() {
		return xingming;
	}

	public int getXuehao() {
		return xuehao;
	}

	public int getChengji() {
		return chengji;
	}
	
	public Xs(String xingming,int xuehao,int chengji){
		//构造方法
		this.xingming=xingming;
		this.xuehao=xuehao;
		this.chengji=chengji;
	}
}

