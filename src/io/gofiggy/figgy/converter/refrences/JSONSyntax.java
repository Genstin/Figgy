package io.gofiggy.figgy.converter.refrences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.gofiggy.figgy.internal.editor.Editor;
import io.gofiggy.figgy.internal.editor.types.content.Content;
import io.gofiggy.figgy.internal.utils.Converter;
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
	
	
	protected String render_subobject_content(Content cont, Boolean prettyPrint) {
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected String render_hashmap_object(Content cont, String builder, String newlineSymbol, String tabSymbol, String tabBuilder, Boolean prettyPrint) {
		builder = builder + "{" + newlineSymbol;
		HashMap map = (HashMap) cont.getValue().getValue();
		mapMentor = -1;
		insertHelper = "";
		Iterable map2 = null;
		map.forEach((k, v) -> {
			String tabSymbol2 = "   ";
			String newlineSymbol2 = "\n";
			if(prettyPrint == false) { newlineSymbol2 = ""; tabSymbol2 = "";
			} else if(prettyPrint == null) { newlineSymbol2 = "%NEW_LINE%"; tabSymbol2 = ""; }
			mapMentor = mapMentor + 1;
			String subbuilder = "";
			String subbuilder1 = "";
			String subbuilder2 = "";
			String tabBuilder2 = tabSymbol2 + tabSymbol2;
			if((new Converter(k)).toString() != null) { subbuilder1 = "\"" + (new Converter(k)).toString() + "\": "; } else subbuilder1 = "\"" + (new Converter(k)).getValue() + "\": ";
			if((new Converter(v)).toString() != null) {	subbuilder2 = "\"" + (new Converter(v)).toString() + "\""; } else subbuilder2 = "" + (new Converter(v)).getValue() + "";
			subbuilder = tabBuilder2 + subbuilder1 + subbuilder2 + ",";
			if((Math.floor(map.size() - 1)) == mapMentor) subbuilder = subbuilder.substring(0, subbuilder.length() - 1);
			insertHelper = insertHelper + subbuilder + "" + newlineSymbol2;
		});
		builder = builder + insertHelper + tabBuilder + "}";
		return builder;
	}
	
	protected String render_subobject(Content cont, Boolean prettyPrint, Integer spacers) {
		String newlineSymbol = "\n"; 
		String tabSymbol = "   ";
		
		for(Integer i = 0; i <= spacers; i++) {
			tabSymbol = tabSymbol + tabSymbol;
		}
		
		if(prettyPrint == false) {
			newlineSymbol = "";
			tabSymbol = "";
		} else if(prettyPrint == null) {
			newlineSymbol = "%NEW_LINE%";
			tabSymbol = "";
		}
		
		String tabBuilder = "";
		String builder = "";
		
		if(cont.getValue().getValueType().equals(HashMap.class)) {
			builder = render_hashmap_object(cont, builder, newlineSymbol, tabSymbol, tabBuilder, prettyPrint);
		} else {
			builder = builder + "[" + newlineSymbol;
			builder = builder + tabBuilder + "]";
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
