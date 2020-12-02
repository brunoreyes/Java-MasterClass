
public class Main {

	public static void main(String[] args) {
		
//		8 primitive data types:
		// byte
		// short
		// int
		// long
		// float
		// double
		// char
		// boolean
		String myString = "This is a string";
		System.out.println("myString is equal to " + myString);
		myString = myString + ", and this is more."; // adding more to myString, updating the value of the variable
		System.out.println("myString is equal to " + myString);
		myString = myString + " \u00A9 2019"; //strings can add on unicode
		System.out.println("myString is equal to " + myString); //myString is equal to This is a string, and this is more. © 2019
		String numberString = "250.55";
		numberString = numberString + "49.95"; // you cannot add two strings of numbers like this to get a sum.
		System.out.println(numberString); //250.5549.95
		String lastString = "10";
		int myInt = 50;
		lastString = lastString + myInt; // Java converts the value of myInt: 50 into a string and appends it to the string '10'
		// like so: 1050
		System.out.println("LastString is equal to "+ lastString);
		double doubleNumber = 120.47d;
		lastString = lastString + doubleNumber;
		System.out.println("LastString is equal to "+ lastString); // LastString is equal to 1050120.47  decimal numbers can also be append to a string
		// strings in Java are immutable, can't be changed. If we delete chars from a string, a new string is created automatically in Java with new values
		// while the previous string will be automatically deleted from memory.

		// StringBuffers discussed later, are mutable strings (can be changed)


		// data types can be combined and are called classes 
		//string is not a data type, it's a class, but is a favorite in Java, making it easier to use class
		// a string is a sequence of characters or char (which only contains one regular or unicode character. 
		
		// a string is limited by the amount of memory the computer uses 
		
		int myValue = 1000; // int is a whole number, with a range.

//		finding the range of int
		int myMinIntValue = Integer.MIN_VALUE; 
		int myMaxIntValue = Integer.MAX_VALUE;
		System.out.println("Integer Minimum Value = " + myMinIntValue); // -2147483648
		System.out.println("Integer Maximum Value = " + myMaxIntValue); // 2147483647
		// an integer cannot go below -2147483648 or above 2147483647.  an int occupies 32 bits aka a width of 32

		// make sure to look out for spelling areas, particularly, integer
		System.out.println("Busted MAX value = " + (myMaxIntValue +1)); //  -2147483648
		// going over the max alloted integer changes the number and makes it negative
		// outputting: -2147483648. The opposite occurs if we go one under the minimal producing: 2147483647
		// overflow in the case of going over the maximum, underflow when going under the minimum
		
		int myMaxIntTest = 2_147_483_647; // numbers can also be written like this, with '_' in the place of ','
		// int myMaxIntTest = 2147483648; // here we get an error bc its higher than the max int value
		
		// now finding the range of bytes aka the smallest and largest
		byte myMinByteValue = Byte.MIN_VALUE;
		byte myMaxByteValue = Byte.MAX_VALUE;
		System.out.println("Byte Minimum Value = " + myMinByteValue); // -128
		System.out.println("Byte Maximum Value = " + myMaxByteValue); // 127
		// a byte cannot go below -128 or above 127. a byte occupies 8 bits aka a width of 8
		
		Short myMinShortValue = Short.MIN_VALUE;
		Short myMaxShortValue = Short.MAX_VALUE;
		System.out.println("Short Minimum Value = " + myMinShortValue); // -32768
		System.out.println("Short Maximum Value = " + myMaxShortValue); // 32768
		// a short cannot go below -32768 or above 32768.  a short occupies 16 bits aka a width of 16

		// each primitive type occupies a different amount of memory; int: 32 bits, short: 16 bits, byte: 8 bits
		
		// the long is a data type that has to process numbers higher than the int/ higher than 2147483647
		long myLongValue = 100L; // adding an 'L' at the end of an int/number, forces Java to treat the number as a long.
		long myMinLongValue = Long.MIN_VALUE;
		long myMaxLongValue = Long.MAX_VALUE;
		System.out.println("Long Minimum Value = " + myMinLongValue); // -32768
		System.out.println("Long Maximum Value = " + myMaxLongValue); // 32768
		// a Long cannot go below -9223372036854775808 or above 9223372036854775807. Used for bigger numbers 
		
		long bigLongLiteralVaue = 2_147_483_649_098L;
		System.out.println("Big Long Literal Value = " + bigLongLiteralVaue); // 2147483649098, much higher than an int.

		short BigShortLiteralValue = 32767;
		System.out.println("Big Short Literal Value = " + BigShortLiteralValue); // 32768

		int myTotal = (myMinIntValue / 2);
		byte myNewByteValue = (byte)(myMinByteValue / 2); // here we get an error bc myMinByteValue is an int, and we need an byte
							// when we insert (byte) before the defaulted int, the error goes away
							// this is called 'casting'
		
		short myNewShortValue = (short)(myMinShortValue / 2); // here we need to tell Java again that it's a short
		
		// so it's best to deal with solely integers when possible to avoid having to remind Java via: 
		//(bye)/(short) in front of expression: (myMinShortValue / 2)
		
		byte byteChallengeVariable = 123;
		short shortChallengeVariable = -32750;
		int intChallengeVariable = 2147483647;
		long longChallengeSumVariable = 50000L + (10L * (byteChallengeVariable + shortChallengeVariable + intChallengeVariable));
		System.out.println("byteChallengeVariable = " + byteChallengeVariable);// byteChallengeVariable = 123
		System.out.println("shortChallengeVariable = " + shortChallengeVariable);//	shortChallengeVariable = -32750
		System.out.println("intChallengeVariable = " + intChallengeVariable);//	intChallengeVariable = 2147483647
		System.out.println("longChallengeVariable = " + longChallengeSumVariable); // longChallengeVariable = 21474560200
		// recall to add L to any int in expression when creating a long variable

		short shortChallengeSumVariable = (short) longChallengeSumVariable; // casting a short, recall a short only goes to 32768, 
		// so here the number doesn't go up but finds its way to = -14136
		System.out.println("shortChallengeSumVariable = " + shortChallengeSumVariable); // shortChallengeSumVariable = -14136

		//float - single
		//floating point numbers - a single precision number, occupying 32 bits, so a width of 32
		float myMinFloatValue = Float.MIN_VALUE;
		float myMaxFloatValue = Float.MAX_VALUE;
		System.out.println("myMinFloatValue = " + myMinFloatValue); // 1.4E-45
		System.out.println("myMaxFloatValue = " + myMaxFloatValue); // 3.4028235E38


		// double - double
		//double point numbers - a double precision number, occupying 64 bits, so a width of 64
		double myMinDoubleValue = Double.MIN_VALUE;
		double myMaxDoubleValue = Double.MAX_VALUE;
		System.out.println("myMinFloatValue = " + myMinDoubleValue); // 4.9E-324
		System.out.println("myMaxFloatValue = " + myMaxDoubleValue); // 1.7976931348623157E308
		
		
		int myIntValue = 5 / 2;
		float myFloatValue = 5f / 3f; // make sure to add f and d at the end of float and double numbers for best practice
		float mySecondFloatValue = (float) 5.25; // another way but less preferred
		double myDoubleValue = 5d /3.00; // adding decimal numbers can only be done with float or double, preferably doubles
		System.out.println("myIntValue = " + myIntValue); // 2, rounding down b/c it doesn't allow decimals
		System.out.println("myFloatValue = " + myFloatValue); // 1.6666666, this is b/c it's a floating number
		System.out.println("mySecondFloatValue = " + mySecondFloatValue); // 5.25
		System.out.println("myDoubleValue = " + myDoubleValue); // 1.6666666666666667 double is more precise than float
	
		// when their is no d at the end and the number has a decimal, Java assumes that the number is a double 
		// double is faster to process with computers when using doubles rather than float.
		// also double is used more with java libraries. So double will be the preferred method.
		
		int numberOfPounds = 12;
		double poundsConvertedToKilos = (numberOfPounds / 2.20462d );
		System.out.println("poundsConvertedToKilos = " + poundsConvertedToKilos); // 5.4431149
		
		double pi = 3.1415927d;
		double anotherNumber = 3_000_000.4_159_297d; // you can format with underscores in decimals as well.
		System.out.println("pi = " + pi); // 3.1415927
		System.out.println("anotherNumber = " + anotherNumber); // 3000000.4159297

		// when precise calculations are necessary like converting currency, the BigDecimal class will be handy
		// otherwise we default to double
		
		
		char myChar = 'D'; // chars can only store a single character, different from a string
		// occupies 16 bytes, a width of 16, allowing for reg characters and Unicode, over 65535 characters
		System.out.println("myChar = " + myChar); // D

		char myUnicodeCharD = '\u0044'; // when creating a Unicode character start character with: '\ than u'
		// CAN'T WRITE UNICODE SYNTAX IN COMMENTS verbatim b/c '\ + u' in comments will product an error
		System.out.println("myUnicodeCharD = " + myUnicodeCharD); // D
		
		char myUnicodeCharCopyright = '\u00A9'; 
		System.out.println("myUnicodeCharCopyright = " + myUnicodeCharCopyright); // ©

		
		// boolean
		boolean myTrueBooleanValue = true;
		boolean myFalseBooleanValue = false;
		boolean isCustomerOverTwentyOne = false; // with booleans, we phrase a variable to be a question starting with 'is'
		System.out.println("isCustomerOverTwentyOne = " + isCustomerOverTwentyOne); // false

		
		
	}
	

}
