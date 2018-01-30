package com.vaadin.starter.bakery.testbench.elements.ui;

import com.vaadin.starter.bakery.testbench.elements.components.BakeryNavigationElement;
import com.vaadin.testbench.HasElementQuery;

public interface HasApp extends HasElementQuery {

	default MainViewElement getApp() {
		return $(MainViewElement.class).onPage().first();
	}

	default BakeryNavigationElement getMenu() {
		return getApp().getMenu();
	}

}