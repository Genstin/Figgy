package io.gofiggy.figgy.dotfig.types;

import io.gofiggy.figgy.dotfig.types.sub.ContentKey;
import io.gofiggy.figgy.dotfig.types.sub.ContentValue;

public class DotFigContent {
	ContentKey key = null;
	ContentValue val = null;
	
	public DotFigContent() {
	}
	
	public DotFigContent(String key) {
		this.key = new ContentKey(key);
	}
	
	public DotFigContent(String key, Object val) {
		this.key = new ContentKey(key);
		this.val = new ContentValue(val);
	}
	
	public void setKey(String content) {
		this.key = new ContentKey(content);
	}
	
	public void setKey(ContentKey content) {
		this.key = content;
	}
	
	public void setValue(Object content) {
		this.val = new ContentValue(content);
	}
	
	public void setValue(ContentValue content) {
		this.val = content;
	}
	
	public ContentKey getKey() {
		return key;
	}
	
	public ContentValue getValue() {
		return val;
	}
}
