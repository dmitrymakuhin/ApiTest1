import io.qameta.allure.Allure;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Listeners(CustomListeners.class)
public abstract class BaseTest {

    @AfterSuite
    public void setUp() {
        try {
            Allure.addAttachment("Log File", "text/plain", new FileInputStream("target/logs/app.log"), "txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}