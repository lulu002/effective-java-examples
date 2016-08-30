// Broken - violates symmetry! - Pages 36-37
package org.effectivejava.examples.chapter03.item08;

/**
 * 该实例违反了对称原则。在使用旧的代码的时候，你会发现前后调用equals，得到的结果是不一样的。
 * 这样会容易出现bug。确保两对象的equals得到的结果，无论位置变化，结果都是一样的。
 * @author minjianying
 *
 */
public final class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		if (s == null)
			throw new NullPointerException();
		this.s = s;
	}

	// Broken - violates symmetry!
	// @Override
	// public boolean equals(Object o) {
	// if (o instanceof CaseInsensitiveString)
	// return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
	// if (o instanceof String) // One-way interoperability!
	// return s.equalsIgnoreCase((String) o);
	// return false;
	// }

	// This version is correct.
	@Override
	public boolean equals(Object o) {
		return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
	}

	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String s = "polish";
		System.out.println(cis.equals(s) + "  " + s.equals(cis));
		
		CaseInsensitiveString cis2 = new CaseInsensitiveString("test");
		CaseInsensitiveString cis3 = new CaseInsensitiveString("test");
		System.out.println(cis2.equals(cis3));

	}
}
