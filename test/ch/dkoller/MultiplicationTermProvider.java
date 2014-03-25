package ch.dkoller;

import static junitparams.JUnitParamsRunner.$;

public class MultiplicationTermProvider {
	public static Object[] provideFirst() {
		return $($(1, 24), $(2, 12), $(3, 8), $(4, 6));
	}
}