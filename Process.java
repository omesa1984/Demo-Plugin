package Thesis;

import java.util.ArrayList;
import java.util.List;

public class Process {
	P_Reader to_read = new P_Reader();
	
	public Process() {}
	
	public void To_Process(String path_folder) {
		P_Reader to_read = new P_Reader();
		
		System.out.println ("Reading Files");
		
		to_read.Fill_List(path_folder);
		
	}
}