package com.packagename.myapp.testbench;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.packagename.myapp.testbench.elements.ui.DashboardViewElement;
import com.packagename.myapp.testbench.elements.ui.LoginViewElement;
import com.packagename.myapp.testbench.elements.ui.StorefrontViewElement;

public class LoginIT extends AbstractIT<LoginViewElement> {

	@Test
	public void loginWorks() {
		LoginViewElement loginView = openLoginView();
		assertEquals("Email", loginView.getUsernameLabel());
		loginView.login("barista@vaadin.com", "barista");
	}

	@Test
	public void logout() {
		LoginViewElement loginView = openLoginView();
		StorefrontViewElement storefront = loginView.login("barista@vaadin.com", "barista");
		storefront.getMenu().logout();
		Assert.assertTrue(getDriver().getCurrentUrl().endsWith("login"));
	}

	@Test
	public void loginToNotDefaultUrl() {
		LoginViewElement loginView = openLoginView(getDriver(), APP_URL + "dashboard");
		DashboardViewElement dashboard = loginView.login("admin@vaadin.com", "admin", DashboardViewElement.class);
		Assert.assertNotNull(dashboard);
	}
	
	@Override
	protected LoginViewElement openView() {
		return openLoginView();
	}

}