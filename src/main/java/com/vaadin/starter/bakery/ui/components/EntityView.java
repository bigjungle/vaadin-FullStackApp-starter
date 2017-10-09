package com.vaadin.starter.bakery.ui.components;

import java.util.Optional;

import com.vaadin.starter.bakery.app.HasLogger;
import com.vaadin.starter.bakery.ui.HasToast;
import com.vaadin.starter.bakery.ui.messages.Message;
import com.vaadin.ui.UI;

public interface EntityView extends HasToast, HasLogger {

	void closeDialog(boolean updated);

	void confirm(Message message, Runnable operation);

	void openDialog();

	default void showError(String message, boolean isPersistent) {
		toast(message, isPersistent);
	}

	default void navigateToEntity(Optional<UI> ui, String basePage, String id) {
		final String location = basePage + (id == null || id.isEmpty() ? "" : "/" + id);
		ui.ifPresent(u -> u.navigateTo(location));
	}
}