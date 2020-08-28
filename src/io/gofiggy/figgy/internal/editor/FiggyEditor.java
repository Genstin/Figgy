package io.gofiggy.figgy.internal.editor;

import io.gofiggy.figgy.converter.TypeConverter;
import io.gofiggy.figgy.internal.editor.types.FiggyStage;
import io.gofiggy.figgy.internal.encoders.FiggyEncoding;

public class FiggyEditor extends FiggyStage {
	String path = "";
	TypeConverter tconv = null; 
	FiggyEncoding encoder = null;
	
	public FiggyEditor() {
		tconv = new TypeConverter();
		tconv.importFrom(this);
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
	public void update() {
		updateFromFile(path);
	}
	
	public void updateFromFile(String directory) {
		
	}
	
	public FiggyEncoding getEncooding() {
		return null;
	}
	
	public void setEncoding(FiggyEncoding encode) {
		
	}
	
	public String convertTo(String lang, Boolean prettyPrint) {
		return tconv.convertTo(lang, prettyPrint);
	}
}
