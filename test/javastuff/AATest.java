package javastuff;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AATest {

	@Test
	public void testName() throws Exception {
		String blubs = new AA().whatever();
		assertThat(blubs, notNullValue());
	}
}
