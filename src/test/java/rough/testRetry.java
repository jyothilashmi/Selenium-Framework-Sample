package rough;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testRetry {
	/*
	 * @Test(retryAnalyzer = retryFailed.class) public void Test1() {
	 * Assert.assertEquals(false, true); }
	 * 
	 * @Test public void Test2() { Assert.assertEquals(false, true); }
	 */
	 @Test()
	 public void Test1()
	 {
		 String a="abc";
		 String b="abc";
	 Assert.assertEquals(a, b);
	 }
	 
	 @Test
	 public void Test2()
	 {
	 Assert.assertEquals(true, true);
	 }

}
