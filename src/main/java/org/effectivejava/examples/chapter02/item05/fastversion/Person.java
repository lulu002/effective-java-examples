// Doesn't creates unnecessary duplicate objects - page 21
package org.effectivejava.examples.chapter02.item05.fastversion;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 这个例子重点说明了，在类里面存在一些常量对象的时候，使用static来初始化。
 * 这样一旦建立对象的时候，static方法只会运行一次。大大提升效率。
 * 没有必要建立重复的对象。
 * @author minjianying
 *
 */
class Person {
	private final Date birthDate;

	public Person(Date birthDate) {
		// Defensive copy - see Item 39
		this.birthDate = new Date(birthDate.getTime());
	}

	// Other fields, methods

	/**
	 * The starting and ending dates of the baby boom.
	 */
	private static final Date BOOM_START;
	private static final Date BOOM_END;

	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}

	public boolean isBabyBoomer() {
		return birthDate.compareTo(BOOM_START) >= 0
				&& birthDate.compareTo(BOOM_END) < 0;
	}
	
	public static void main(String[] args) {
		Person person=new Person(new Date());
		System.out.println(person.isBabyBoomer());
		
		Person person2=new Person(new Date());
		System.out.println(person2.isBabyBoomer());
	}
}
