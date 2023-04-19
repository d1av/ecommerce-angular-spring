package com.davi.shop.entities.product;

import com.davi.shop.validation.ValidationHandler;
import com.davi.shop.validation.Validator;

public class ProductValidator extends Validator {

    private Product product;

    ProductValidator(final Product aProduct,
	    final ValidationHandler aHandler) {
	super(aHandler);
	this.product = aProduct;
    }

    @Override
    public void validate() {
	checkRegionalCouncilConstraints();
    }

    private void checkRegionalCouncilConstraints() {
//	final var fieldToValidate = this.tax.getRegionalCouncil();
//	final String messageField = "'regionalCouncil'";
//
//	if (Objects.isNull(fieldToValidate)) {
//	    this.validationHandler().append(new Error(
//		    "%s should not be null".formatted(messageField)));
//	}
//
//	if (!(fieldToValidate instanceof BigDecimal)) {
//	    this.validationHandler().append(new Error(
//		    "%s should be a number".formatted(messageField)));
//	}
//
//	if (Objects.nonNull(fieldToValidate)) {
//	    if (fieldToValidate.intValue() < 0) {
//		this.validationHandler()
//			.append(new Error("%s should not be negative"
//				.formatted(messageField)));
//	    } else if (fieldToValidate.intValue() > 999999) {
//		this.validationHandler().append(
//			new Error("%s should not be above 999.999"
//				.formatted(messageField)));
//	    }
//	}
    }

}