package io.gofiggy.figgy.internal.editor.types.content;

import io.gofiggy.figgy.internal.utils.ContentConverter;

public class FiggyContentKey {
	String key = "";
	
	public FiggyContentKey() {
	}
	
	public FiggyContentKey(String key) {
		this.key = key;
	}
	
	public ContentConverter makeConverter() {
		ContentConverter gen = new ContentConverter();
		gen.setValue(key);
		return gen;
	}
}
