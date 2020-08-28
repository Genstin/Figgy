package io.gofiggy.figgy.internal.utils;

import java.awt.TextComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ContentConverter {
	Object realValue = null;
	@SuppressWarnings("rawtypes")
	Class realValueOrigin = null;
	
	public ContentConverter() {}
	
	public boolean equals(Object content) {
		if(realValue.equals(content)) return true;
		return false;
	}
	
	public boolean equals(String content) {
		if(realValueOrigin.equals(String.class) || realValueOrigin.equals(TextComponent.class) || realValueOrigin.equals(UUID.class)) {
			if(("" + realValue + "").equals(content)) return true;
			if(realValue.toString().equals(content)) return true;
		}
		return false;
	}
	
	public boolean equals(Integer content) {
		if(realValueOrigin.equals(int.class) || realValueOrigin.equals(Integer.class) || realValueOrigin.equals(float.class)  || realValueOrigin.equals(double.class)) {
			if(realValue == content) return true;
			if(content == Integer.parseInt("" + realValue + "")) return true;
			if(content == (Integer) realValue) return true;
		}
		return false;
	}
	
	public boolean equals(UUID content) {
		if(realValueOrigin.equals(UUID.class) || realValueOrigin.equals(String.class)) {
			if(realValue.equals(content)) return true;
			if(content.equals(UUID.fromString((String) realValue))) return true;
			if(content.equals((UUID) realValue)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(HashMap content) {
		if(realValueOrigin.equals(HashMap.class) || realValueOrigin.equals(Map.class)) {
			Map contentAsMap = (Map) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(contentAsMap)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(Map content) {
		if(realValueOrigin.equals(HashMap.class) || realValueOrigin.equals(Map.class)) {
			HashMap contentAsMap = (HashMap) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(contentAsMap)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(ArrayList content) {
		if(realValueOrigin.equals(ArrayList.class) || realValueOrigin.equals(List.class)) {
			List contentAsList = (List) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(contentAsList)) return true;
			if(realValue.equals(content.toArray())) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(List content) {
		if(realValueOrigin.equals(ArrayList.class) || realValueOrigin.equals(List.class)) {
			ArrayList contentAsArrayList = (ArrayList) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(contentAsArrayList)) return true;
			if(realValue.equals(content.toArray())) return true;
		}
		return false;
	}
	
	public boolean equals(Boolean content) {
		if(realValueOrigin.equals(Boolean.class)) {
			if(realValue.equals(content)) return true;
		}
		if(realValueOrigin.equals(String.class)) {
			if(content) {
				if(realValue.equals("true")) return true;
			}
			if(!content) {
				if(realValue.equals("false")) return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "" + realValue + "";
	}
	
	public int toInt() {
		return 0;
	}
	
	public Integer toInteger() {
		return (Integer) toInt();
	}
	
	public void setContent(Object content) {
		realValue = content;
		realValueOrigin = content.getClass();
	}
}
