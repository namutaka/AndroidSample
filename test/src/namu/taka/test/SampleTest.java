package namu.taka.test;

import namu.taka.Sample;
import android.test.AndroidTestCase;

public class SampleTest extends AndroidTestCase {
	public void testHoge() {
		Sample o = new Sample();
		assertEquals(1, o.hoge());
	}
}
