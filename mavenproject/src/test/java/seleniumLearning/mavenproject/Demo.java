package seleniumLearning.mavenproject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {

@Test
public void Test1(){
	System.out.println("hello ALL");
	
}
@BeforeTest
 public void test2() {
	 System.out.println("hiii");
 }
}
