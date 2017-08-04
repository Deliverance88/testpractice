/*
package utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class TestListener extends TestListenerAdapter {


    static MyTestResults results = new MyTestResults();

    @Override
    public void onTestSuccess(ITestResult testResult) {
        System.out.println(testResult.getName() + " was successful");
        results.incrementPassed();
        System.out.println("Passed tests: " + results.getPassed());
        System.out.println("Total tests: " + results.totalTests());
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        System.out.println(testResult.getName() + " was a failure\n Throwable: " + testResult.getThrowable().getMessage());
        results.incrementFailed();
        System.out.println("Failed tests: " + results.getFailed());
        System.out.println("Total tests: " + results.totalTests());
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        System.out.println(testResult.getName() + " was skipped");
        results.incrementSkipped();
        System.out.println("Skipped tests: " + results.getSkipped());
        System.out.println("Total tests: " + results.totalTests());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        try {
            results.writeToCSV();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
