package io.gofiggy.figgytester;

import java.util.ArrayList;
import java.util.HashMap;

import io.gofiggy.figgy.internal.editor.Editor;

public class Tester {
	public static void main(String[] args) {
		Editor gen = new Editor();
		HashMap<String, Object> gen2 = new HashMap<String, Object>();
		HashMap<String, Object> gen2_5 = new HashMap<String, Object>();
		ArrayList<Object> gen3 = new ArrayList<Object>();
		
		gen2_5.put("green", "blue");
		
		gen2.put("texttest", "yes");
		gen2.put("inttest", 1);
		gen2.put("subconttest", gen2_5);
		
		gen.addContent("hashmaptest", gen2);
		gen.addContent("arraytest", gen3);
		
		System.out.print(gen.convertTo("JSON", true));
	}
}
