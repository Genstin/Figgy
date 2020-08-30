package io.gofiggy.figgy.internal.editor.types;

import java.util.ArrayList;

import io.gofiggy.figgy.internal.editor.types.content.Content;

public class Stage {
	ArrayList<Content> content = new ArrayList<Content>();
	
	public Stage() {
		
	}
	
	public ArrayList<Content> getContents() {
		return content;
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
	
	public void addContent(Content cont) {
		content.add(cont);
	}
	
	public void addContent(String key, Object value) {
		Content gen = new Content();
		gen.setKey(key);
		gen.setValue(value);
		addContent(gen);
	}
}
