package io.gofiggy.figgy.dotfig;

import java.util.ArrayList;
import java.util.HashMap;

import io.gofiggy.figgy.dotfig.types.DotFigStage;

public class DotFigFile {
	DotFigStage defaultStage = new DotFigStage();
	HashMap<DotFigStage, ArrayList<DotFigStage>> stages = new HashMap<DotFigStage, ArrayList<DotFigStage>>();
	
	public DotFigFile() {
		
	}
	
	public DotFigStage[] getStages() {
		ArrayList<DotFigStage> returner = new ArrayList<DotFigStage>();
		stages.forEach((parent, item) -> {
			item.forEach((subitem) -> {
				returner.add(subitem);
			});
		});
		DotFigStage[] returner2 = (DotFigStage[]) returner.toArray();
		return returner2;
	}
	
	public DotFigStage getDefaultStage() {
		return defaultStage;
	}
	
	public void createFromContents() {
		
	}
	
	public void importFromContents() {
	}
	
	public String exportContents() {
		String builder = "";
		
		return null;
	}
	
	public String toString() {
		return exportContents();
	}
}
