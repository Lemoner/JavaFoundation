package com.lmr.test;

import java.util.*;
public class TestInnerClass {
	
	public static void main(String[] args){
		ArrayList aa1=new ArrayList();//����һ�����϶���������Էźܶ�Ķ���
		System.out.println("��СΪ��"+aa1.size());
		Xs xs1=new Xs("���",15,90);
		Xs xs2=new Xs("�˽�",14,70);
		Xs xs3=new Xs("ɳɮ",13,75);
		Xs xs4=new Xs("С����",20,80);
		
//		TestInnerClass innerClass=new TestInnerClass();
//		Xs xs1=innerClass.new Xs("���",15,90);
//		Xs xs2=new Xs("�˽�",14,70);
//		Xs xs3=new Xs("ɳɮ",13,75);
//		Xs xs4=new Xs("С����",20,80);
		
		aa1.add(xs1);//Ϊ���������������
		aa1.add(xs2);
		aa1.add(xs3);
		System.out.println("��СΪ��"+aa1.size());//�����ʱ���ϵĴ�С
		/*for(int i=0;i<aa1.size();i++){//��������
			Xs tv=(Xs)aa1.get(i);//getΪaa1��һ����������size()Ҳ��aa1��һ������
			System.out.println("��"+(i+1)+"��ѧ���������ǣ�"+tv.getXingming());
		}*/
		//aa1.remove(1);//�����нڵ��ɾ��
		aa1.add(1,xs4);//��ͬ������ӣ�ָ�����λ��
		aa1.add(xs4);//��������
		for(int i=0;i<aa1.size();i++){//�ٴα�������
			Xs tv=(Xs)aa1.get(i);
			System.out.println("��"+(i+1)+"��ѧ����������"+tv.getXingming());
		}
	}

}
class Xs{//������һ��ѧ����
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
		//���췽��
		this.xingming=xingming;
		this.xuehao=xuehao;
		this.chengji=chengji;
	}
}

