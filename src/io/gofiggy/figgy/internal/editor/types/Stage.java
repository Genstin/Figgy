package io.gofiggy.figgy.internal.editor.types;

import java.util.ArrayList;

import io.gofiggy.figgy.internal.editor.Editor;
import io.gofiggy.figgy.internal.editor.types.content.Content;
import io.gofiggy.figgy.tools.JsonTools;

public class Stage {
	
	// EDITOR STAGES
	
	// These stages contain the sub contents and methods for
	// other files or stages. These are also sometimes called
	// objects in specific file type languages.
	
	ArrayList<Content> content = new ArrayList<Content>();
	
	public Stage() {}
	
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
	
	public void importContents(JsonTools tools) {
	}
	
	public void importContents(Editor editor) {
	}
	
	public void importContents(String raw) {
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
