package com.eastict;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultServiceSupport ds = new DefaultServiceSupport();
		if(ServiceSupport.class.isAssignableFrom(DefaultServiceSupport.class)){
			System.out.println("yes!");
		}
		if(ds instanceof ServiceSupport<?>){
			System.out.println("right!");
		}
	}

}
