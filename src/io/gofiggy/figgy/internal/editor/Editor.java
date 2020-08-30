package io.gofiggy.figgy.internal.editor;

import io.gofiggy.figgy.converter.TypeConverter;
import io.gofiggy.figgy.internal.editor.types.Stage;
import io.gofiggy.figgy.internal.encoders.Encoding;

public class Editor extends Stage {
	
	// EDITOR
	
	// The editor is essential or updating or reading any language,
	// below is the basic internal setup for one, we'd recommend
	// going to our WIKI for more information.
	
	String path = "";
	TypeConverter tconv = null; 
	Encoding encoder = null;
	
	public Editor() {
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
	
	public Encoding getEncooding() {
		return null;
	}
	
	public void setEncoding(Encoding encode) {
		
	}
	
	public String convertTo(String lang, Boolean prettyPrint) {
		return tconv.convertTo(lang, prettyPrint);
	}
}
