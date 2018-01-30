package com.vaadin.starter.bakery.testbench;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.starter.bakery.testbench.elements.components.OrderCardElement;
import com.vaadin.starter.bakery.testbench.elements.core.ButtonElement;
import com.vaadin.starter.bakery.testbench.elements.core.GridElement;
import com.vaadin.starter.bakery.testbench.elements.ui.StorefrontViewElement;

import static org.hamcrest.CoreMatchers.endsWith;

public class StorefrontViewIT extends AbstractIT {

	private StorefrontViewElement openStorefrontPage() {
		return openLoginView().login("admin@vaadin.com", "admin");
	}

	@Test
	public void orderCardExpandAndCollapse() {
		StorefrontViewElement storefrontPage = openStorefrontPage();

		GridElement grid = storefrontPage.getGrid();
		Assert.assertTrue(grid.getGridSize() >= 0);

		OrderCardElement firstOrder = storefrontPage.getFirstOrderCard();
		Assert.assertNotNull(firstOrder);
		Assert.assertFalse(firstOrder.isOrderSelected());

		firstOrder.click();
		Assert.assertTrue(firstOrder.isOrderSelected());
	}

	@Test
	public void editOrder() {
		StorefrontViewElement storefrontPage = openStorefrontPage();

		OrderCardElement firstOrder = storefrontPage.getOrderCard(1);
		Assert.assertNotNull(firstOrder);
		firstOrder.click();
		ButtonElement editBtn = firstOrder.getDetail().getEditButton();
		editBtn.scrollIntoView();
		editBtn.click();

		Assert.assertThat(getDriver().getCurrentUrl(), endsWith("edit="));
	}

}