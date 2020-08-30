package io.gofiggy.figgy.converter;

import io.gofiggy.figgy.converter.refrences.JSONSyntax;
import io.gofiggy.figgy.converter.refrences.YMLSyntax;
import io.gofiggy.figgy.internal.editor.Editor;

public class TypeConverter {
	Editor imported = null;
	
	public TypeConverter() {
		
	}
	
	public void importFrom(Object file) {
		if(file.getClass().equals(Editor.class)) {
			imported = (Editor) file;
		}
	}
	
	public String convertTo(String language, Boolean prettyPrint) {
		if(language.equalsIgnoreCase("YML")) {
			YMLSyntax gen = new YMLSyntax();
			return gen.fromDotFig(imported, prettyPrint);
		}
		if(language.equalsIgnoreCase("JSON")) {
			JSONSyntax gen = new JSONSyntax();
			return gen.fromDotFig(imported, prettyPrint);
		}
		return null;
	}
}
