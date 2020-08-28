package io.gofiggy.figgy.dotfig.types;

import java.util.ArrayList;

public class DotFigStage {
	ArrayList<DotFigContent> content = new ArrayList<DotFigContent>();
	
	public DotFigStage() {
		
	}
	
	public DotFigContent[] getContents() {
		return (DotFigContent[]) content.toArray();
	}
	
	public boolean containsContent(DotFigContent content) {
		return false;
	}
	
	public String exportContents() {
		String builder = "";
		builder = builder + "(\n";
		
		for(DotFigContent stage : getContents()) {
			
		}
		
		builder = builder + "\n)";
		return null;
	}
	
	public void importContents() {
		
	}
}
