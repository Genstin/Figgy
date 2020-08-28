package io.gofiggy.figgy.converter.refrences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.gofiggy.figgy.internal.editor.FiggyEditor;
import io.gofiggy.figgy.internal.editor.types.content.FiggyContent;
import io.gofiggy.figgy.internal.utils.ContentConverter;
import io.gofiggy.figgy.manager.JsonEditor;
import io.gofiggy.figgy.parsers.JsonParser;

public class JSONSyntax {
	Integer mapMentor = 0;
	String insertHelper = "";
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String fromDotFig(FiggyEditor file, Boolean prettyPrint) {
		String newlineSymbol2 = "\n"; 
		if(prettyPrint == false) {
			newlineSymbol2 = "";
		} else if(prettyPrint == null) {
			newlineSymbol2 = "%NEW_LINE%";
		}
		String builder = "";
		builder = builder + "{" + newlineSymbol2;
		for(FiggyContent cont : file.getContents()) {
			builder = builder + "\"" + cont.getKey() + "\": ";
			if(cont.getValue().getValueType() != HashMap.class || cont.getValue().getValueType() != ArrayList.class || cont.getValue().getValueType() != List.class || cont.getValue().getValueType() != FiggyContent.class) {
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
						
						if((new ContentConverter(k)).toString() != null) {
							subbuilder1 = "\"" + (new ContentConverter(k)).toString() + "\": ";
						} else {
							subbuilder1 = "\"" + (new ContentConverter(k)).getValue() + "\": ";
						}
						
						if((new ContentConverter(v)).toString() != null) {
							subbuilder2 = "\"" + (new ContentConverter(v)).toString() + "\"";
						} else {
							subbuilder2 = "" + (new ContentConverter(v)).getValue() + "";
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
	
	public FiggyEditor toDotFig(String text) {
		text = text.replaceAll("\n", "%NEW_LINE%").substring(1, text.length() - 1);
		return null;
	}
	
	public FiggyEditor toDotFig(JsonParser parser) {
		return null;
	}
	
	public FiggyEditor toDotFig(JsonEditor editor) {
		return null;
	}
}
