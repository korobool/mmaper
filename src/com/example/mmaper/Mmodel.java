package com.example.mmaper;

import java.util.ArrayList;
import java.util.List;

public final class Mmodel {
	
	private List<mTree> forest = new ArrayList<mTree>();
	
	public int LoadFrom(String xmlPath) {
		// build the forest from xml data
		
		// Read xml to DOM
		
		// Create Roots (trees) according to xml and add them to forest as mTree instances
		
		forest.add(new mTree(/* Here you can pass branch of DOM to load from, 
		so that you'll need to add new .ctor*/));
		
		// Fill out all the trees according to xml 
		
		StateHolder.UpdateRequired = true;
		
		
		return 0;
	}
	
	public void SerializeTo(String xmlPath) {
		// Traverse forest and create xml
		
	}
	
	

}
