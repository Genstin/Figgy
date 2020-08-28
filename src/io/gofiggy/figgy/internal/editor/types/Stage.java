package io.gofiggy.figgy.internal.editor.types;

import java.util.ArrayList;

import io.gofiggy.figgy.internal.editor.types.content.Content;

public class Stage {
	ArrayList<Content> content = new ArrayList<Content>();
	
	public Stage() {
		
	}
	
	public Content[] getContents() {
		return (Content[]) content.toArray();
	}
	
	public boolean containsContent(Content content) {
		return false;
	}
	
	public String exportContents() {
		String builder = "";
		builder = builder + "(\n";
		
		for(Content stage : getContents()) {
			
		}
		
		builder = builder + "\n)";
		return null;
	}
	
	public void importContents() {
		
	}
}
