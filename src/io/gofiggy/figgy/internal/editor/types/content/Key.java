package io.gofiggy.figgy.internal.editor.types.content;

import io.gofiggy.figgy.internal.utils.Converter;

public class Key {
	String key = "";
	
	public Key() {
	}
	
	public Key(String key) {
		this.key = key;
	}
	
	public Converter makeConverter() {
		Converter gen = new Converter();
		gen.setValue(key);
		return gen;
	}
	
	public String getValue() {
		return key;
	}
}
