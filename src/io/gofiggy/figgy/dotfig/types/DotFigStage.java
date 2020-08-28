package io.gofiggy.figgy.dotfig.types;

import java.util.ArrayList;

public class DotFigStage {
	ArrayList<DotFigContent> content = new ArrayList<DotFigContent>();
	
	public DotFigStage() {
		
	}
	
	public DotFigContent[] getContent() {
		return (DotFigContent[]) content.toArray();
	}
	
	public boolean containsContent(DotFigContent content) {
		return false;
	}
}
