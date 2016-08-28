// Enum singleton - the preferred approach - page 18
package org.effectivejava.examples.chapter02.item03.enumoration;

/**
 * 使用枚举进行单例模式的代码编写，这可能是最好的代码编写方式。
 * @author minjianying
 *
 */
public enum Elvis {
	INSTANCE;

	private Integer number=0;
	
	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	public void addNumber()
	{
		synchronized (INSTANCE) {
			number++;
		}
	}
	
	public Integer getNumber()
	{
		return number;
	}
	// This code would normally appear outside the class!
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilding();
		
		Elvis elvis2 = Elvis.INSTANCE;
		Elvis elvis3 = Elvis.INSTANCE;

		elvis2.addNumber();
		elvis.addNumber();
		elvis3.addNumber();
		
		MyThread th1=new MyThread();
		th1.start();
		
		MyThread th2=new MyThread();
		th2.start();
		
		System.out.println(elvis.getNumber());
		
	}
	
	public  static class MyThread extends Thread {
		public void run() {
			Elvis elvis33 = Elvis.INSTANCE;
			elvis33.addNumber();
			System.out.println(elvis33.getNumber());

		}
	} 

}
