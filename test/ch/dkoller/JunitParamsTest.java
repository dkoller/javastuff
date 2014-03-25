package ch.dkoller;

import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class JunitParamsTest {

	@Test
	@Parameters({ "2, 12", "3, 8" })
	public void productFromParameters(int first, int second) throws Exception {
		product(first, second);
	}

	@Test
	@Parameters(method = "parametersForProduct2")
	public void productFromMethod(int first, int second) throws Exception {
		product(first, second);
	}

	@Test
	@Parameters(source = MultiplicationTermProvider.class)
	public void productFromClass(int first, int second) throws Exception {
		product(first, second);
	}

	@Test
	@Parameters(source = InternalMultiplicationTermProvider.class)
	public void productFromInternalClass(int first, int second)
			throws Exception {
		product(first, second);
	}

	Object[] parametersForProduct2() {
		return $($(1, 24), $(2, 12), $(3, 8), $(4, 6));
	}

	private void product(int first, int second) {
		assertThat(first * second, is(24));
	}

	public static class InternalMultiplicationTermProvider {
		public static Object[] provideFirst() {
			return $($(1, 24), $(2, 12), $(3, 8), $(4, 6));
		}
	}
}
