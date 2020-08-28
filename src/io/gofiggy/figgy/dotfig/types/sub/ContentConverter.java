package io.gofiggy.figgy.dotfig.types.sub;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ContentConverter {
	Object realValue = null;
	
	public ContentConverter() {
		
	}
	
	public boolean equals(Object content) {
		return false;
	}
	
	public boolean equals(String content) {
		return false;
	}
	
	public boolean equals(Integer content) {
		return false;
	}
	
	public boolean equals(UUID content) {
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(HashMap content) {
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
}
