package com.hyk.listeners;

import com.aventstack.extentreports.ExtentTest;

/**
 * @param
 * @Description TODO
 * @Author Lindsay
 * @Date 2020/10/6 12:57 PM
 **/
public class MyReporter {

    public static ExtentTest report;
    private static String testName;


    public static String getTestName() {
        return testName;
    }

    public static void setTestName(String testName) {
        MyReporter.testName = testName;
    }
}
