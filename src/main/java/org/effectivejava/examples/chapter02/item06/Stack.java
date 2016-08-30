// Can you spot the "memory leak"?
package org.effectivejava.examples.chapter02.item06;

import java.util.Arrays;

/**
 * 这个例子展示了什么是非受检异常的应用场景。
 * main函数是我自己加上去的。
 * @author minjianying
 *
 */
public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		return elements[--size];
	}

	/**
	 * Ensure space for at least one more element, roughly doubling the capacity
	 * each time the array needs to grow.
	 */
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		//System.out.println(stack.pop());
	}
}
