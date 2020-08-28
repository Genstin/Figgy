package io.gofiggy.figgy.dotfig.types.content;

public class FiggyContent {
	FiggyContentKey key = null;
	FiggyContentValue val = null;
	
	public FiggyContent() {
	}
	
	public FiggyContent(String key) {
		this.key = new FiggyContentKey(key);
	}
	
	public FiggyContent(String key, Object val) {
		this.key = new FiggyContentKey(key);
		this.val = new FiggyContentValue(val);
	}
	
	public void setKey(String content) {
		this.key = new FiggyContentKey(content);
	}
	
	public void setKey(FiggyContentKey content) {
		this.key = content;
	}
	
	public void setValue(Object content) {
		this.val = new FiggyContentValue(content);
	}
	
	public void setValue(FiggyContentValue content) {
		this.val = content;
	}
	
	public FiggyContentKey getKey() {
		return key;
	}
	
	public FiggyContentValue getValue() {
		return val;
	}
}
