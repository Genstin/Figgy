package io.gofiggy.figgy.dotfig.types.sub;

import java.awt.TextComponent;
import java.lang.reflect.Array;
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
			Map ContentAsMap = (Map) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(ContentAsMap)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(Map content) {
		if(realValueOrigin.equals(HashMap.class) || realValueOrigin.equals(Map.class)) {
			HashMap ContentAsMap = (HashMap) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(ContentAsMap)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(ArrayList content) {
		return false;
	}
	
	public boolean equals(Array content) {
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(List content) {
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
	}
}
