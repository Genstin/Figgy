package io.gofiggy.figgy.tools;

import io.gofiggy.figgy.internal.editor.Editor;
import io.gofiggy.figgy.internal.encoders.Encoding;
import io.gofiggy.figgy.internal.encoders.Encodings;

public class JsonTools {
	// Dynamic Tools
	
	String raw = "";
	Encoding enc = Encodings.DEFAULT;
	Editor edit = new Editor();
	
	public JsonTools() {
	}
	
	public JsonTools(String raw) {
	}
	
	public JsonTools(String raw, Encoding encoding) {
	}
	
	public JsonTools(Editor editor) {
	}
	
	public Editor getEditor() {
		return edit;
	}
	
	public void fromRaw(String raw) {
		edit = new Editor();
		edit.importContents(raw);
	}
	
	public void importRaw(String raw) {
		edit.importContents(raw);
	}
	
	public String getRaw() {
		return edit.exportContents();
	}
	
	// Static Tools
	
	public static Editor getEditor(String raw) {
		return null;
	}
	
	public static Editor getEditor(String raw, Encoding encoding) {
		return null;
	}
}
