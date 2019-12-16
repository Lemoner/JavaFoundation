package com.lmr.generic;

public class TestWildcard {

	public static void main(String[] args) {
		
		Manager ceo=new Manager("001", "CEO", 20000);
		Manager cfo=new Manager("002", "CFO", 33333);
		Manager cto=new Manager("003", "CTO", 11111);
		
//		Pair<Employee> p=new Pair<Employee>(ceo, cfo);
//		printPair(p);
		
		Manager[] managers={ceo,cfo,cto};
		Pair<Employee> r=new Pair<>();
		
		minmaxSalary(managers, r);
		
		System.out.println(r.getFirst().toString());
		System.out.println(r.getSecond().toString());
		
	}
	
	public static void printPair(Pair<? extends Employee> p){
		Employee first=p.getFirst();
		Employee second=p.getSecond();
		System.out.println(first.toString()+" - - "+second.toString());
	}
	
	public static void minmaxSalary(Manager[] a, Pair<? super Employee> result){
		
		if(a==null || a.length==0){
			return;
		}
		Manager min=a[0];
		Manager max=a[0];
		for(int i=1;i<a.length;i++){
			if(min.getSalary()>a[i].getSalary()){
				min=a[i];
			}
			if(max.getSalary()<a[i].getSalary()){
				max=a[i];
			}
		}
		result.setFirst(min);
		result.setSecond(max);
		
		System.out.println(result.getFirst().toString());
		System.out.println(result.getSecond().toString());
		
	}
	
	
	
}
