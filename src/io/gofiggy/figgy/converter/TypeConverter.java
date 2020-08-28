package io.gofiggy.figgy.converter;

import io.gofiggy.figgy.converter.refrences.YMLSyntax;
import io.gofiggy.figgy.dotfig.FiggyEditor;

public class TypeConverter {
	FiggyEditor imported = new FiggyEditor();
	
	public TypeConverter() {
		
	}
	
	public void importFrom(Object file) {
		if(file.getClass().equals(FiggyEditor.class)) {
			imported = (FiggyEditor) file;
		}
	}
	
	public String convertToYML() {
		YMLSyntax gen = new YMLSyntax();
		return gen.fromDotFig(imported);
	}
}
