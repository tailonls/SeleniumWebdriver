package test;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.Assert;

public class TesteGoogle {

	public static void main(String[] args) {

		getDriver().get("https://www.google.com");

		System.out.println(getDriver().getTitle());
		Assert.assertEquals("Google", getDriver().getTitle());

		killDriver();
	}
}