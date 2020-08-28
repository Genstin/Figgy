package io.gofiggy.figgy.internal.editor.types.content;

import io.gofiggy.figgy.internal.utils.ContentConverter;

public class FiggyContentValue extends ContentConverter {
	public FiggyContentValue() {
	}
	
	public FiggyContentValue(Object val) {
		setValue(val);
	}
}
