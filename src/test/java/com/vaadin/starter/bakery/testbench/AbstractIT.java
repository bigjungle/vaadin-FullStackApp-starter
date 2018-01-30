package com.vaadin.starter.bakery.testbench;

import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;

import com.vaadin.starter.bakery.testbench.elements.ui.LoginViewElement;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchDriverProxy;
import com.vaadin.testbench.TestBenchTestCase;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public abstract class AbstractIT extends TestBenchTestCase {

	public static final String APP_URL = "http://localhost:8080/";

	static {
		// Prevent debug logging from Apache HTTP client
		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.INFO);
	}

	@Rule
	public ScreenshotOnFailureRule screenshotOnFailure = new ScreenshotOnFailureRule(this, true);

	@Before
	public void setup() {
		setDriver(createDriver());
		getCommandExecutor().resizeViewPortTo(1024, 768);
	}

	protected WebDriver createDriver() {
		return TestBench.createDriver(new ChromeDriver());
	}

	@Override
	public TestBenchDriverProxy getDriver() {
		return (TestBenchDriverProxy) super.getDriver();
	}

	protected LoginViewElement openLoginView() {
		return openLoginView(getDriver(), APP_URL);
	}

	protected LoginViewElement openLoginView(WebDriver driver, String url) {
		driver.get(url);
		return $(LoginViewElement.class).waitForFirst();
	}
}