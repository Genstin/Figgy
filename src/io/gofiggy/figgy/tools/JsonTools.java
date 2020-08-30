package io.gofiggy.figgy.tools;

import io.gofiggy.figgy.converter.refrences.JSONSyntax;
import io.gofiggy.figgy.internal.editor.Editor;
import io.gofiggy.figgy.internal.encoders.Encoding;
import io.gofiggy.figgy.tools.makers.filetools.JsonFileTools;

public class JsonTools extends JSONSyntax {
	
	// JSON TOOLS
	
	// [info]
	
	String raw = "";
	Editor edit = new Editor();
	
	public JsonTools() {}
	public JsonTools(String raw) { this.raw = raw; }
	public JsonTools(Editor editor) {
		this.raw = editor.exportContents();
		this.edit = editor;
	}
	
	// These tools can be used by declaring a new JSON Syntax!
	
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
	
	// These tools can be used by JSONTools.getEditor("your raw JSON");
	
	public static Editor getEditor(String raw) {
		Editor edit = new Editor();
		edit.importContents(raw);
		return edit;
	}
	
	public static Editor getEditor(String raw, Encoding encoding) {
		return null;
	}
	
	public static JsonFileTools getFileTools(JsonTools jf) {
		return null;
	}
	
	public JsonFileTools getFileTools() {
		return null;
	}
	
	// [info]

}
