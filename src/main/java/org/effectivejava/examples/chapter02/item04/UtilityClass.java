// Noninstantiable utility class
package org.effectivejava.examples.chapter02.item04;

public class UtilityClass {
	// Suppress default constructor for noninstantiability
	private UtilityClass() {
		throw new AssertionError();
	}
	
	public static void printSomeThing() {
		System.out.println("打印其他东西");
	}
	public static void main(String[] args) {
		UtilityClass.printSomeThing();
	}
}
