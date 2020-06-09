package com.mavidev;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mavidev.demo.model.Region;

@RunWith(SpringRunner.class)
public class MaviApplicationTests {

	@Test
	public void testSetAbsoluteRegionTest() {
		Region region = new Region("Ankara", "Kazan","06");
		String absoluteRegion = region.getAbsoluteRegion();
		assertEquals(absoluteRegion,"AnkaraKazan06");
	}

}

