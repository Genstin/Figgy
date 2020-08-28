package io.gofiggy.figgy.internal.editor.types.content;

public class Content {
	Key key = null;
	Value val = null;
	
	public Content() {
	}
	
	public Content(String key) {
		this.key = new Key(key);
	}
	
	public Content(String key, Object val) {
		this.key = new Key(key);
		this.val = new Value(val);
	}
	
	public void setKey(String content) {
		this.key = new Key(content);
	}
	
	public void setKey(Key content) {
		this.key = content;
	}
	
	public void setValue(Object content) {
		this.val = new Value(content);
	}
	
	public void setValue(Value content) {
		this.val = content;
	}
	
	public Key getKey() {
		return key;
	}
	
	public Value getValue() {
		return val;
	}
}
