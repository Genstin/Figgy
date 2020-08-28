package io.gofiggy.figgy.internal.editor.types.content;

import io.gofiggy.figgy.internal.utils.Converter;

public class Value extends Converter {
	public Value() {
	}
	
	public Value(Object val) {
		setValue(val);
	}
}
