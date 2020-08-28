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
	String insertHelper = "";
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String fromDotFig(Editor file, Boolean prettyPrint) {
		String newlineSymbol2 = "\n"; 
		if(prettyPrint == false) {
			newlineSymbol2 = "";
		} else if(prettyPrint == null) {
			newlineSymbol2 = "%NEW_LINE%";
		}
		String builder = "";
		builder = builder + "{" + newlineSymbol2;
		for(Content cont : file.getContents()) {
			builder = builder + "\"" + cont.getKey() + "\": ";
			if(cont.getValue().getValueType() != HashMap.class || cont.getValue().getValueType() != ArrayList.class || cont.getValue().getValueType() != List.class || cont.getValue().getValueType() != Content.class) {
				String subbuilder = "";
				if(cont.getValue().toString() != null) {
					subbuilder = "\"" + cont.getValue().toString() + "\"";
				} else {
					subbuilder = "" + cont.getValue() + "";
				}
				builder = builder + subbuilder + ",";
			} else {
				if(cont.getValue().getValueType() == HashMap.class) {
					builder = builder + "{" + newlineSymbol2;
					HashMap map = (HashMap) cont.getValue().getValue();
					mapMentor = -1;
					insertHelper = builder;
					map.forEach((k, v) -> {
						String newlineSymbol = "\n"; 
						if(prettyPrint == false) {
							newlineSymbol = "";
						} else if(prettyPrint == null) {
							newlineSymbol = "%NEW_LINE%";
						}
						
						mapMentor = mapMentor + 1;
						String subbuilder = "";
						String subbuilder1 = "";
						String subbuilder2 = "";
						
						if((new Converter(k)).toString() != null) {
							subbuilder1 = "\"" + (new Converter(k)).toString() + "\": ";
						} else {
							subbuilder1 = "\"" + (new Converter(k)).getValue() + "\": ";
						}
						
						if((new Converter(v)).toString() != null) {
							subbuilder2 = "\"" + (new Converter(v)).toString() + "\"";
						} else {
							subbuilder2 = "" + (new Converter(v)).getValue() + "";
						}
						
						subbuilder = subbuilder1 + subbuilder2 + ",";
						
						if((Math.floor(map.size() - 1)) == mapMentor) {
							subbuilder = subbuilder.substring(subbuilder.length() - 1);
						}
						
						insertHelper = insertHelper + subbuilder + "" + newlineSymbol;
					});
					builder = builder + insertHelper + "}";
				} else {
					builder = builder + "[" + newlineSymbol2;
					builder = builder + "]";
				}
			}
		}
		builder = builder + "}";
		return null;
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
