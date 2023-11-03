import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CustomListeners implements ITestListener {

    protected static final Logger logger = LogManager.getLogger();
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Start test " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test failed: " + result.getName());
    }
}
