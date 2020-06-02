package com.myweb.ctrl;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import com.myweb.util.OptionID;

public class UtilMethodTest {
	
	@Test
	public void getOptionID() {
		assertThat(1, is(OptionID.getOptionID("hot", "short")));
	}
}
