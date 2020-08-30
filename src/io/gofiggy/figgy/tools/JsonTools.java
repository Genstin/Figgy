package io.gofiggy.figgy.tools;

import io.gofiggy.figgy.converter.refrences.JSONSyntax;
import io.gofiggy.figgy.internal.editor.Editor;
import io.gofiggy.figgy.internal.encoders.Encoding;
import io.gofiggy.figgy.internal.encoders.Encodings;

public class JsonTools extends JSONSyntax {
	
	// DYNAMIC TOOLS
	// These tools can be used by declaring a new JSON Syntax!
	
	String raw = "";
	Encoding enc = Encodings.DEFAULT;
	Editor edit = new Editor();
	
	public JsonTools() {}
	
	public JsonTools(String raw) {
		this.raw = raw;
	}
	
	public JsonTools(String raw, Encoding encoding) {
		this.raw = raw;
		this.enc = encoding;
	}
	
	public JsonTools(Editor editor) {
		this.raw = editor.exportContents();
		this.edit = editor;
	}
	
	public Editor getEditor() {
		return edit;
	}
	
	public Editor makeEditor() {
		fromRaw(raw);
		return edit;
	}
	
	public void fromRaw(String raw) {
		edit = toDotFig(this);
	}
	
	public void importRaw(String raw) {
		JsonTools gen = new JsonTools(raw);
		edit.importContents(toDotFig(gen));
	}
	
	public String getRaw() {
		return edit.exportContents();
	}
	
	// STATIC TOOLS
	// These tools can be used by JSONTools.getEditor("your raw JSON");
	
	public static Editor getEditor(String raw) {
		Editor edit = new Editor();
		edit.importContents(raw);
		return edit;
	}
	
	public static Editor getEditor(String raw, Encoding encoding) {
		return null;
	}
}
