package io.gofiggy.figgy.converter;

import io.gofiggy.figgy.converter.refrences.JSONSyntax;
import io.gofiggy.figgy.converter.refrences.YMLSyntax;
import io.gofiggy.figgy.internal.editor.FiggyEditor;

public class TypeConverter {
	FiggyEditor imported = new FiggyEditor();
	
	public TypeConverter() {
		
	}
	
	public void importFrom(Object file) {
		if(file.getClass().equals(FiggyEditor.class)) {
			imported = (FiggyEditor) file;
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
