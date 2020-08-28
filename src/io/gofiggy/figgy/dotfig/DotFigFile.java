package io.gofiggy.figgy.dotfig;

import io.gofiggy.figgy.converter.TypeConverter;
import io.gofiggy.figgy.dotfig.types.DotFigStage;

public class DotFigFile extends DotFigStage {
	String path = "";
	TypeConverter tconv = null; 
	
	public DotFigFile() {
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
		
	}
	
	public void updateFromFile(String directory) {
		
	}
	
	public void convertTo(String lang) {
		
	}
}
