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
	public void product1(int first, int second) throws Exception {
		product(first, second);
	}

	@Test
	@Parameters(method = "parametersForProduct2")
	public void product2(int first, int second) throws Exception {
		product(first, second);
	}

	Object[] parametersForProduct2() {
		return $($(1, 24), $(2, 12), $(3, 8), $(4, 6));
	}

	private void product(int first, int second) {
		assertThat(first * second, is(24));
	}
}
