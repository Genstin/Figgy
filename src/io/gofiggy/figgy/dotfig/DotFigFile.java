package io.gofiggy.figgy.dotfig;

import io.gofiggy.figgy.dotfig.types.DotFigContent;
import io.gofiggy.figgy.dotfig.types.DotFigStage;

public class DotFigFile {
	DotFigStage defaultStage = new DotFigStage();
	
	public DotFigFile() {
		
	}
	
	public DotFigStage getDefaultStage() {
		return defaultStage;
	}
	
	public void createFromContents() {
		
	}
	
	public void importFromContents() {
	}
	
	public String exportContents() {
		String builder = "";
		builder = builder + "(\n";
		
		for(DotFigContent stage : defaultStage.getContent()) {
			
		}
		
		builder = builder + "\n)";
		return null;
	}
	
	public String toString() {
		return exportContents();
	}
}
