package com.packagename.myapp.ui.views.storefront.events;

import com.vaadin.flow.component.ComponentEvent;
import com.packagename.myapp.ui.views.orderedit.OrderDetails;

public class CommentEvent extends ComponentEvent<OrderDetails> {

	private Long orderId;
	private String message;

	public CommentEvent(OrderDetails component, Long orderId, String message) {
		super(component, false);
		this.orderId = orderId;
		this.message = message;
	}

	public Long getOrderId() {
		return orderId;
	}

	public String getMessage() {
		return message;
	}
}