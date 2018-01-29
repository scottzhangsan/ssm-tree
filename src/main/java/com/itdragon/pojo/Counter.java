package com.itdragon.pojo;


public class Counter {
	
	public static int count = 0 ;
	
	
	public static synchronized void inc(){
		
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		count++ ;
		
		System.out.println(Thread.currentThread().getName()+"\t"+count);
	}
	
	public static void main(String[] args) {
		
		//两个不同的线程。
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				
				public void run() {
					
				Counter.inc(); 
				System.out.println("hello");
				}
			}).start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"运行结果:Counter.count=" + Counter.count);
	}

}
