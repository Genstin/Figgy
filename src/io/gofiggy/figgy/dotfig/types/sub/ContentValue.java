package io.gofiggy.figgy.dotfig.types.sub;

import io.gofiggy.figgy.internal.utils.ContentConverter;

public class ContentValue extends ContentConverter {
	public ContentValue() {
	}
	
	public ContentValue(Object val) {
		setValue(val);
	}
}
