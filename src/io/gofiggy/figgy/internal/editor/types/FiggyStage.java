package io.gofiggy.figgy.internal.editor.types;

import java.util.ArrayList;

import io.gofiggy.figgy.internal.editor.types.content.FiggyContent;

public class FiggyStage {
	ArrayList<FiggyContent> content = new ArrayList<FiggyContent>();
	
	public FiggyStage() {
		
	}
	
	public FiggyContent[] getContents() {
		return (FiggyContent[]) content.toArray();
	}
	
	public boolean containsContent(FiggyContent content) {
		return false;
	}
	
	public String exportContents() {
		String builder = "";
		builder = builder + "(\n";
		
		for(FiggyContent stage : getContents()) {
			
		}
		
		builder = builder + "\n)";
		return null;
	}
	
	public void importContents() {
		
	}
}
