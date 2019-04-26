package com.BSC.framework.action;

import java.util.Calendar;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class Randomizer {

	public static String getRandomAphabeticString(int strSize) {
		return RandomStringUtils.randomAlphabetic(strSize);
	}

	public static String getRandomAutomationAlphaString(int strSize) {
		return "Auto_" + getRandomAphabeticString(strSize);
	}

}
