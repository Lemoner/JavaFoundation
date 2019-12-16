package com.lmr.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//�ַ�������+��������
public class OrderWrapper implements Comparable<OrderWrapper> {
	String name = null;

	public OrderWrapper(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj instanceof OrderWrapper) {
			OrderWrapper other = (OrderWrapper) obj;

			if (null == this.name) {
				return false;
			} else {
				return this.name.equals(other.name);
			}
		}
		return false;
	}

	// �ȽϷ���,�൱�ڼ����� (return this - wrapper)
	public int compareTo(OrderWrapper wrapper) {
		if (null == wrapper) {
			return 1;
		}
		// ֱ�����
		if (this == wrapper || this.equals(wrapper)) {
			return 0;
		}
		String name1 = this.name;
		String name2 = wrapper.name;
		// �������Σ�name��һ��Ϊ�յ����.
		if (null == name1) {
			// ��Ϊ�գ���Ϊ���
			if (null == name2) {
				return 0;
			} else {
				return -1;
			}
		} else if (null == name2) {
			return 1;
		}
		// �м� 1-�������
		Pattern pattern = Pattern.compile("\\D*(\\d+)\\D*");
		Matcher matcher1 = pattern.matcher(name1);
		Matcher matcher2 = pattern.matcher(name2);
		// System.out.println(pattern.pattern());
		//
		int index1_step = 0;
		int index2_step = 0;
		while (matcher1.find()) {
			String s1 = matcher1.group(1);
			String s2 = null;
			if (matcher2.find()) {
				s2 = matcher2.group(1);
			}
			int index1 = name1.indexOf(s1, index1_step);
			int index2 = name2.indexOf(s2, index2_step);
			//
			index1_step = index1;
			index2_step = index2;
			// ������ȵ������
			if (index1 == index2) {
//				System.out.println("name1=" + name1.length() + "\nname2=" + name2.length());
//				System.out.println("index1=" + index1 + ",index2=" + index2);
				String pre1 = name1.substring(0, index1);
				String pre2 = name2.substring(0, index2);
				if (pre1.equals(pre2)) {
					//
					long num1 = Long.parseLong(s1);
					long num2 = Long.parseLong(s2);
					//
					if (num1 == num2) {
						// �Ƚ���һ��
						continue;
					} else {
						return (int) (num1 - num2);
					}
				} else {
					break;
				}
			} else {
				break;
			}
		}

		// ��������.
		return this.name.compareTo(wrapper.name);
	}
	
}
