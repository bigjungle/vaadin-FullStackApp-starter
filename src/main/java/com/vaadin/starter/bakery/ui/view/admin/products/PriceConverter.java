package com.vaadin.starter.bakery.ui.view.admin.products;

import static com.vaadin.starter.bakery.ui.dataproviders.DataProviderUtil.convertIfNotNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import com.vaadin.data.Converter;
import com.vaadin.data.Result;
import com.vaadin.data.ValueContext;
import com.vaadin.starter.bakery.ui.utils.FormattingUtils;

class PriceConverter implements Converter<String, Integer> {

	private final DecimalFormat df = FormattingUtils.getUiPriceFormatter();

	@Override
	public Result<Integer> convertToModel(String presentationValue, ValueContext valueContext) {
		try {
			if (presentationValue == null || presentationValue.isEmpty()) {
				return Result.error("Price is required");
			} else {
				return Result.ok((int) Math.round(df.parse(presentationValue).doubleValue() * 100));
			}
		} catch (ParseException e) {
			return Result.error("Invalid value");
		}
	}

	@Override
	public String convertToPresentation(Integer modelValue, ValueContext valueContext) {
		return convertIfNotNull(modelValue, i -> df.format(BigDecimal.valueOf(i, 2)));
	}
}