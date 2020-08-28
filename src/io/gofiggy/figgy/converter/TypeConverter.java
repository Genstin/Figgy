package io.gofiggy.figgy.converter;

import io.gofiggy.figgy.converter.refrences.YMLSyntax;
import io.gofiggy.figgy.dotfig.DotFigFile;

public class TypeConverter {
	DotFigFile imported = new DotFigFile();
	
	public TypeConverter() {
		
	}
	
	public void importFrom(Object file) {
		if(file.getClass().equals(DotFigFile.class)) {
			imported = (DotFigFile) file;
		}
	}
	
	public String convertToYML() {
		YMLSyntax gen = new YMLSyntax();
		return gen.fromDotFig(imported);
	}
}
