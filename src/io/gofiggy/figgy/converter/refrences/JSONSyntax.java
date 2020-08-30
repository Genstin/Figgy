package io.gofiggy.figgy.converter.refrences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.gofiggy.figgy.internal.editor.Editor;
import io.gofiggy.figgy.internal.editor.types.content.Content;
import io.gofiggy.figgy.tools.JsonTools;

public class JSONSyntax {
	Integer mapMentor = 0;
	Integer contMentor = 0;
	String insertHelper = "";
	
	public String fromDotFig(Editor file, Boolean prettyPrint) {
		String newlineSymbol = "\n"; 
		String tabSymbol = "   ";
		if(prettyPrint == false) {
			newlineSymbol = "";
			tabSymbol = "";
		} else if(prettyPrint == null) {
			newlineSymbol = "%NEW_LINE%";
			tabSymbol = "";
		}
		String tabBuilder = "";
		String builder = "";
		contMentor = -1;
		builder = builder + "{" + newlineSymbol;
		for(Content cont : file.getContents()) {
			contMentor = contMentor + 1;
			tabBuilder = tabSymbol;
			builder = builder + tabBuilder + "\"" + cont.getKey().getValue() + "\": ";
			if(!cont.getValue().getValueType().equals(HashMap.class) && !cont.getValue().getValueType().equals(ArrayList.class) && !cont.getValue().getValueType().equals(List.class) && !cont.getValue().getValueType().equals(Content.class)) {
				String subbuilder = "";
				if(cont.getValue().toString() != null) { subbuilder = "\"" + cont.getValue().toString() + "\""; } else subbuilder = "" + cont.getValue() + "";
				builder = builder + subbuilder;
			} else {
				builder = builder + render_subobject(cont, prettyPrint, 1);
			}
			builder = builder + ",";
			if((Math.floor(file.getContents().size() - 1)) == contMentor) builder = builder.substring(0, builder.length() - 1);
			builder = builder + newlineSymbol;
		}
		builder = builder + "}";
		return builder;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected String render_hashmap_object(Content cont, String builder, String newlineSymbol, String tabSymbol, String tabBuilder, Boolean prettyPrint, Integer spacers) {
		builder = builder + "{" + newlineSymbol;
		HashMap map = (HashMap) cont.getValue().getValue();
		mapMentor = -1;
		insertHelper = "";
		Iterable map2 = null;
		map.forEach((k, v) -> {
			mapMentor = mapMentor + 1;
			String subbuilder = "";
			String subbuilder1 = "";
			String subbuilder2 = "";
			String tabBuilder2 = tabSymbol + tabSymbol;
			Content newContent = new Content();
			newContent.setKey("" + k + "");
			newContent.setValue(v);
			insertHelper = insertHelper + render_subcontent(newContent, prettyPrint, (spacers + 1));
			insertHelper = insertHelper + subbuilder + "" + newlineSymbol;
		});
		builder = builder + insertHelper + tabBuilder + "}";
		return builder;
	}
	
	protected String render_array_object(Content cont, String builder, String newlineSymbol, String tabSymbol, String tabBuilder, Boolean prettyPrint) {
		builder = builder + "[" + newlineSymbol;
		builder = builder + tabBuilder + "]";
		return builder;
	}
	
	protected String render_subcontent(Content cont, Boolean prettyPrint, Integer spacers) {
		String tabBuilder = "";
		String newlineSymbol = "\n"; 
		String tabSymbol = "   ";
		for(Integer i = 0; i < spacers; i++) {
			tabBuilder = tabBuilder + tabSymbol;
		}
		String gen = "";
		if(cont.getKey().makeConverter().canIsString() != false) {
			gen = tabBuilder + "\"" + cont.getKey().makeConverter().toString() + "\": ";
		} else {
			gen = "\"" + cont.getKey().makeConverter().getValue() + "\": ";
		}
		
		if(cont.getValue().canIsString() != false) {
			gen = gen + "\"" + cont.getValue().toString() + "\"";
		} else {
			gen = gen + "" + cont.getValue().getValue() + "";
		}
		return gen;
	}
	
	protected String render_subobject(Content cont, Boolean prettyPrint, Integer spacers) {
		String tabBuilder = "";
		String builder = "";
		String newlineSymbol = "\n"; 
		String tabSymbol = "   ";
		for(Integer i = 0; i < spacers; i++) {
			tabBuilder = tabBuilder + tabSymbol;
		}
		if(prettyPrint == false) {
			newlineSymbol = "";
			tabSymbol = "";
		} else if(prettyPrint == null) {
			newlineSymbol = "%NEW_LINE%";
			tabSymbol = "";
		}
		if(cont.getValue().getValueType().equals(HashMap.class)) {
			builder = render_hashmap_object(cont, builder, newlineSymbol, tabSymbol, tabBuilder, prettyPrint, spacers);
		} else {
			builder = render_array_object(cont, builder, newlineSymbol, tabSymbol, tabBuilder, prettyPrint);
		}
		return builder;
	}
	
	public Editor toDotFig(String text) {
		String raw = text;
		Editor gen = new Editor();
		raw = raw.replaceAll("\n", "%NEW_LINE%").substring(1, raw.length() - 1);
		return gen;
	}
	
	public Editor toDotFig(JsonTools editor) {
		return null;
	}
}
