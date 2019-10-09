package Thesis;

import java.util.ArrayList;
import java.util.List;
//Lista de linhas por arquivo
public class File_Line {
	private String name_file;
	private List<List<Word_Property>> list_line;
	private int no_line;
	
	public File_Line() {
		name_file = "";
		list_line = new ArrayList<List<Word_Property>>();
		no_line = 0;
	}
	
	public File_Line(String name_file) {
		this.name_file = name_file;
		list_line = new ArrayList<List<Word_Property>>();
		no_line = 0;		
	}
	
	public File_Line(String name_file, int no_line) {
		this.name_file = name_file;
		this.no_line = no_line;
	}
	
	public String Get_Name_File() {return name_file;}
	public List<List<Word_Property>> Get_File_line(){return list_line;}
	public int Get_No_Line() {
		return list_line.size();
	}
	public int Get_Line_File(int i) {
		
		int cant = -1;
		
		try {
			cant = list_line.get(i).size();
		} catch (Exception e) {
			cant = 0;
		}
		
		return cant;
	}
	
	public void Set_Name_File(String name_file) {this.name_file = name_file;}
	
	public int Search_File_Line(Word_Property list_line) {
		int pos_words = 0;
		
		pos_words ++;
		
		return pos_words;
	}
		
	public boolean File_Read_Line(String string_test, int i, boolean is_php, boolean cant_write) {
				
		Word_Property temp_sentence = new Word_Property();
		List<Word_Property> list_temp_sentence = new ArrayList<Word_Property>();
		
		String for_word = "";
		int caract = -1;
		boolean be_string = false;
						
		for (int j = 0; j < string_test.length(); j++) {
				
			caract = string_test.charAt(j);
			for_word = for_word + (char)caract;
			
			//POSIBLES SIMBOLOS QUE SEPARAN LAS PALABRAS
			
			if(caract == 32 || caract == 62) {
				if ((for_word.contains("<?php") || for_word.contains("<?PHP") || for_word.equals("<?")) && (cant_write == false)) {
					for_word = "";
					is_php = true;
					cant_write = true;
				}
				
				else if((for_word.contains("php?>") || for_word.contains("PHP?>") || for_word.equals("?>")) && is_php == true && cant_write == true) {
					
					for_word = for_word.substring(0, for_word.length() - 2);
					
					if(for_word.length() - 1 > 0) {
						
						temp_sentence.Set_Word(for_word);
						for_word = "";
						list_temp_sentence.add(temp_sentence);
						
					}
					
					if(list_temp_sentence.size() != 0)
						list_line.add(list_temp_sentence);
					
					temp_sentence = new Word_Property();
					list_temp_sentence = new ArrayList<Word_Property>();
					
					for_word = "";
					caract = -1;
					
					cant_write = false;
					
				}
			}
			
			if(((caract == 32) || (caract == 39) || (caract == 62) || (caract == 46) || (caract == 45 && string_test.charAt(j + 1) == 62) || (caract == 47 && string_test.charAt(j + 1) == 47)) && (be_string == false) && !for_word.isEmpty()) {
						
				if(caract == 45 && string_test.charAt(j + 1) == 62 && is_php == true && cant_write == true) {
					
					for_word = for_word.substring(0, for_word.length() - 1);
					temp_sentence = new Word_Property();
					temp_sentence.Set_Word(for_word);
					for_word = "";
					
					list_temp_sentence.add(temp_sentence);
										
					temp_sentence = new Word_Property();					
					temp_sentence.Set_Word("->");
					temp_sentence.Set_Property("Symbol");
					for_word = "";
					
					list_temp_sentence.add(temp_sentence);
					temp_sentence = new Word_Property();
					
					j++;
					
				}
				else if((caract == 32 || caract == 39) && for_word.length() - 1 != 0 && is_php == true && cant_write == true) {
					
					for_word = for_word.substring(0, for_word.length() - 1);
					temp_sentence = new Word_Property();
					temp_sentence.Set_Word(for_word);
					for_word = "";
					
					list_temp_sentence.add(temp_sentence);
					
				}
				else if((caract == 47 && string_test.charAt(j + 1) == 47) && is_php == true && cant_write == true) {
					
					for_word = for_word.substring(0, for_word.length() - 1);
					temp_sentence.Set_Word(for_word);
					for_word = "";
					
					if(temp_sentence.Get_Word() == "") {
						list_temp_sentence.add(temp_sentence);
						temp_sentence = new Word_Property();
					}
					 
					j = string_test.length();
				}
				else
					for_word = "";
				
			}
			else if((caract == 40 || caract == 44 || caract == 91 || caract == 123 || caract == 41 || caract == 93 || caract == 125 || caract == 59) && (be_string == false && is_php == true) && cant_write == true) {
				
				if(for_word.length() - 1 != 0) {
					
					for_word = for_word.substring(0, for_word.length() - 1);
					temp_sentence = new Word_Property();
					temp_sentence.Set_Word(for_word);
					
					list_temp_sentence.add(temp_sentence);
					
				}

				if(caract != 59) { 
				
				temp_sentence = new Word_Property();
				temp_sentence.Set_Word(String.valueOf((char)caract));
				temp_sentence.Set_Property("Symbol");
				
				list_temp_sentence.add(temp_sentence);
				}
				for_word = "";
				
			}
			else if (caract == 39 && is_php == true && cant_write == true) {
				if(be_string == true) {
					
					for_word = for_word.substring(0, for_word.length() - 1);
					temp_sentence.Set_Word("String");
					for_word = "";
					
					list_temp_sentence.add(temp_sentence);
					temp_sentence = new Word_Property();
					
					be_string = false;
				}
				else {
					for_word = "";
					be_string = true;
				}
			}
			
		}
		
		if(list_temp_sentence.size() != 0)
			list_line.add(list_temp_sentence);
		
		return cant_write;
	}	
}