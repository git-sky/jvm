package cn.com.sky.jvm;

import java.util.Stack;
import java.util.Vector;

/*
 * 内存溢出实例
 */
public class yichu {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		Vector v=new Vector(10);
		Stack s=new Stack();
		s.add(0);
		for (int i=1;i<10000000; i++)
		{
		Object o=new Object();
		v.add(o);
		o=null;
	}
		for (int i=1;i<10000; i++){
			System.out.println(v.get(i-1));
		}
	}
}
