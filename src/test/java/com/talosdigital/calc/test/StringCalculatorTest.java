package com.talosdigital.calc.test;

import org.junit.Assert;
import org.junit.Test;
import com.talosdigital.calc.NegativeNumberException;
import com.talosdigital.calc.StringCalculator;

public class StringCalculatorTest {

	@Test
	public void testNoArgs() {
		StringCalculator sc = new StringCalculator();
		int res;
		try {
			res = sc.add("");
			Assert.assertEquals(0, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOneArg() {
		StringCalculator sc = new StringCalculator();
		int res;
		try {
			res = sc.add("1");
			Assert.assertEquals(1, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTwoArgs() {
		StringCalculator sc = new StringCalculator();
		int res;
		try {
			res = sc.add("1,2");
			Assert.assertEquals(3, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMultipleArgs() {
		StringCalculator sc = new StringCalculator();
		int res;
		try {
			res = sc.add("1,1,2,3,5");
			Assert.assertEquals(12, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNewLineSeparator() {
		StringCalculator sc = new StringCalculator();
		int res;
		try {
			res = sc.add("1\n3");
			Assert.assertEquals(4, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCustomSeparator() {
		StringCalculator sc = new StringCalculator();
		int res;
		try {
			res = sc.add("//s\n1s2");
			Assert.assertEquals(3, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidArg() throws IllegalArgumentException{
		StringCalculator sc = new StringCalculator();
		sc.add("1,@");
		Assert.fail("No exception thrown when invalid argument was input.");
	}
	
	@Test
	public void testNegatives(){
		StringCalculator sc = new StringCalculator();
		try {
			sc.add("1\n3,-4,-6,9,0,-1");
			Assert.fail("No exception was thrown when negative numbers "
					+ "were input");
		}
		catch(NegativeNumberException nne) {
			Assert.assertEquals("Negatives not allowed: -4, -6, -1",
					nne.getMessage());
		}
	}
	
	@Test
	public void testBiggerThanThousand() {
		StringCalculator sc = new StringCalculator();
		int res;
		try {
			res = sc.add("3,1001,2");
			Assert.assertEquals(5, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLongSeparators() {
		StringCalculator sc = new StringCalculator();
		int res;
		try {
			res = sc.add("//[***]\n1***3***4");
			Assert.assertEquals(8, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMultipleCustomSeparators() {
		StringCalculator sc = new StringCalculator();
		int res;
		try {
			res = sc.add("//[***][¿¿]\n1***3¿¿4");
			Assert.assertEquals(8, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
