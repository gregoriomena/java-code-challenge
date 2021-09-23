package com.java.code.challenge.util;

import org.apache.commons.lang3.RandomStringUtils;

public class ProductUtil {

	public static String generateRandomLetters(int length) {
		return RandomStringUtils.random(length, true, false);
	}
}
