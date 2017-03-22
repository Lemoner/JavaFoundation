package com.lmr.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) {
		
//		initHashSet();
		
		initTreeSet();
	}
	
	public static void initHashSet(){
		
		Set<String> words=new HashSet<>();//无序的且没有重复元素，通过哈希表散列存放
		int sum=0;

//		eg：
//		The art of living is to know when to hold fast and when to let go. For life is a paradox: it enjoins us to cling to its many gifts even while it ordains their eventual relinquishment. The rabbis of old put it this way: “A man comes to this world with his fist clenched, but when he dies, his hand is open.”
//		Surely we ought to hold fast to life, for it is wondrous, and full of a beauty that breaks through every pore of God’s own earth. We know that this is so, but all too often we recognize this truth only in our backward glance when we remember what was and then suddenly realize that it is no more.
//		We remember a beauty that faded, a love that waned. But we remember with far greater pain that we did not see that beauty when it flowered, that we failed to respond with love when it was tendered.
//		Here then is the first pole of life’s paradoxical demands on us: Never too busy for the wonder and the awe of life. Be reverent before each dawning day. Embrace each hour. Seize each golden minute.
//		Hold fast to life... but not so fast that you cannot let go. This is the second side of life’s coin, the opposite pole of its paradox: we must accept our losses, and learn how to let go.
//		This is not an easy lesson to learn, especially when we are young and think that the world is ours to command, that whatever we desire with the full force of our passionate being can, nay, will, be ours. But then life moves along to confront us with realities, and slowly but surely this truth dawns upon us.
//		At every stage of life we sustain losses—and grow in the process. We begin our independent lives only when we emerge from the womb and lose its protective shelter. We enter a progression of schools, then we leave our mothers and fathers and our childhood homes. We get married and have children and then have to let them go. We confront the death of our parents and our spouses. We face the gradual or not so gradual waning of our strength. And ultimately, as the parable of the open and closed hand suggests, we must confront the inevitability of our own demise, losing ourselves as it were, all that we were or dreamed to be. 
		
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String word=in.next();
			words.add(word);
			sum++;
		}
		
		System.out.println(sum+"  - -  "+words.size());
		
		Iterator<String> iter=words.iterator();
		while (iter.hasNext()) {
			String str = (String) iter.next();
			System.out.println(str+" - "+str.hashCode());
		}
		
		System.out.println(words.hashCode());
	}
	
	public static void initTreeSet(){
		
		PersonComparator pc=new PersonComparator();
		SortedSet<Person> personset=new TreeSet<>(pc);//比较器可以控制数据按照某种方式排序
		
//		SortedSet<Person> personset=new TreeSet<>();//有序的，通过红黑树定义来对数据进行排序

//		SortedSet<Person> personset=new TreeSet<>(new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				// TODO Auto-generated method stub
//				int age1=o1.getAge();
//				int age2=o2.getAge();
//				
//				if(age1<age2){
//					return -1;
//				}
//				else if(age1>age2){
//					return 1;
//				}
//				else{
//					return 0;
//				}
//			}
//		});
		
//		Random rand=new Random();
//		for(int i=0;i<10;i++){
//			Person p=new Person(i, "name"+i, rand.nextInt(10)+10);
//			personset.add(p);
//		}
		
		Person p1=new Person(1, "A", 12);
		Person p2=new Person(2, "A", 12);
		Person p3=new Person(2, "B", 11);
		Person p4=new Person(3, "C", 10);
		
		personset.add(p1);
		personset.add(p2);
		personset.add(p3);
		personset.add(p4);
		
		System.out.println(personset.size());
		
		Iterator<Person> iter=personset.iterator();
		while (iter.hasNext()) {
			Person person = (Person) iter.next();
			System.out.println(person);
		}
		
	}
	
}
