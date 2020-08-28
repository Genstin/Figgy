package io.gofiggy.figgy.dotfig.types.sub;

import io.gofiggy.figgy.internal.utils.ContentConverter;

public class ContentKey {
	String key = "";
	
	public ContentKey() {
	}
	
	public ContentKey(String key) {
		this.key = key;
	}
	
	public ContentConverter makeConverter() {
		ContentConverter gen = new ContentConverter();
		gen.setValue(key);
		return gen;
	}
}
