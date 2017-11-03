package com.vaadin.starter.bakery.ui.utils.messages;

import com.vaadin.starter.bakery.ui.utils.BakeryConst;

public class Message {

	public static final MessageSupplier UNSAVED_CHANGES = createMessage("Unsaved Changes", "Yes", "Back",
			"There are unsaved modifications to the %s. Are you sure to cancel the edition?");

	public static final MessageSupplier CONFIRM_DELETE = createMessage(BakeryConst.CONFIRM_CAPTION_DELETE,
			BakeryConst.CONFIRM_OKBUTTON_DELETE, BakeryConst.CONFIRM_CANCELBUTTON_DELETE,
			BakeryConst.CONFIRM_MESSAGE_DELETE);

	private final String caption;
	private final String okText;
	private final String cancelText;
	private final String message;

	public Message(String caption, String okText, String cancelText, String message) {
		this.caption = caption;
		this.okText = okText;
		this.cancelText = cancelText;
		this.message = message;
	}

	private static MessageSupplier createMessage(String caption, String okText, String cancelText, String message) {
		return (parameters) -> new Message(caption, okText, cancelText, String.format(message, parameters));
	}

	public String getCaption() {
		return caption;
	}

	public String getOkText() {
		return okText;
	}

	public String getCancelText() {
		return cancelText;
	}

	public String getMessage() {
		return message;
	}

	@FunctionalInterface
	public interface MessageSupplier {
		Message createMessage(Object... parameters);
	}

}