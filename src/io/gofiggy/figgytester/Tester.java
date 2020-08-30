package io.gofiggy.figgytester;

import java.util.ArrayList;
import java.util.HashMap;

import io.gofiggy.figgy.internal.editor.Editor;

public class Tester {
	public static void main(String[] args) {
		Editor gen = new Editor();
		
		HashMap<String, Object> gen2 = new HashMap<String, Object>();
		gen2.put("texttest", "yes");
		gen2.put("inttest", 1);
		
		ArrayList<Object> gen3 = new ArrayList<Object>();
		gen.addContent("hashmaptest", gen2);
		gen.addContent("arraytest", gen3);
		
		System.out.print(gen.convertTo("JSON", true));
	}
}
