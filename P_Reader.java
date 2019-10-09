package Thesis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P_Reader {
	
	private List<File_Line> files; //Lista de arquivos na pasta
	
	private List<String> reserved_words; //Palavras claves de php
	private List<Possible_Vul> vul; // Possiveis vulnerabilidades
			
	public P_Reader(){
		files = new ArrayList<File_Line>();
		reserved_words = new ArrayList<String>();
		vul = new ArrayList<Possible_Vul>();
		
		Fill_Reserverd_Word();
		
		Fill_Possivel_Ans();
				
		}
	
	//Preenchimento estático da lista de palavras reservadas
	private void Fill_Reserverd_Word() {
		reserved_words.add("__halt_compiler");
		reserved_words.add("abstract");
		reserved_words.add("and");
		reserved_words.add("array()");
		reserved_words.add("(array)");
		reserved_words.add("as");
		reserved_words.add("bool");
		reserved_words.add("boolean");
		reserved_words.add("(bool)");
		reserved_words.add("(boolean)");
		reserved_words.add("break");
		reserved_words.add("callable");
		reserved_words.add("case");
		reserved_words.add("catch");
		reserved_words.add("cfunction");
		reserved_words.add("class");	
		reserved_words.add("clone");
		reserved_words.add("const");
		reserved_words.add("continue");
		reserved_words.add("__CLASS__");
		reserved_words.add("date");
		reserved_words.add("declare");
		reserved_words.add("default");
		reserved_words.add("delete_post_type");
		reserved_words.add("delete_taxonomy");
		reserved_words.add("die");
		reserved_words.add("defined");
		reserved_words.add("__DIR__");
		reserved_words.add("do");
		reserved_words.add("(double)");
		reserved_words.add("echo");
		reserved_words.add("else");
		reserved_words.add("elseif");
		reserved_words.add("empty");
		reserved_words.add("enddeclare");
		reserved_words.add("endfor");
		reserved_words.add("endforeach");
		reserved_words.add("endif");
		reserved_words.add("endswitch");
		reserved_words.add("endwhile");
		reserved_words.add("esc_attr");
		reserved_words.add("esc_html");
		reserved_words.add("esc_url");
		reserved_words.add("eval");
		reserved_words.add("exit");
		reserved_words.add("extends");
		reserved_words.add("final");
		reserved_words.add("finally");
		reserved_words.add("for");
		reserved_words.add("foreach");
		reserved_words.add("function");
		reserved_words.add("(float)");
		reserved_words.add("__FILE__");
		reserved_words.add("global");
		reserved_words.add("goto");
		reserved_words.add("echo");
		reserved_words.add("htmlspecialchars");
		reserved_words.add("__halt_compiler");
		reserved_words.add("if");
		reserved_words.add("implements");
		reserved_words.add("include");
		reserved_words.add("include_once");
		reserved_words.add("instanceof");
		reserved_words.add("insteadof");
		reserved_words.add("(int)");
		reserved_words.add("(integer)");
		reserved_words.add("interface");
		reserved_words.add("isset");
		reserved_words.add("list");
		reserved_words.add("__LINE__");
		reserved_words.add("__METHOD__");
		reserved_words.add("namespace");
		reserved_words.add("__NAMESPACE__");
		reserved_words.add("new");
		reserved_words.add("or");
		reserved_words.add("object");
		reserved_words.add("(object)");
		reserved_words.add("parent");
		reserved_words.add("print");
		reserved_words.add("private");
		reserved_words.add("protected");
		reserved_words.add("public");		
		reserved_words.add("require");
		reserved_words.add("require_once");
		reserved_words.add("return");
		reserved_words.add("(real)");
		reserved_words.add("sanitize_text_field");
		reserved_words.add("(string)");
		reserved_words.add("self");
		reserved_words.add("static");
		reserved_words.add("strlen");
		reserved_words.add("str_replace");
		reserved_words.add("switch");
		reserved_words.add("throw");
		reserved_words.add("trait");
		reserved_words.add("try");
		reserved_words.add("__TRAIT__");
		reserved_words.add("unset");
		reserved_words.add("(unset)");
		reserved_words.add("use");
		reserved_words.add("var");
		reserved_words.add("while");
		reserved_words.add("xor");
		reserved_words.add("yield");
		reserved_words.add("&=");
		reserved_words.add("&&");
		reserved_words.add("||");
		reserved_words.add("?>");
		reserved_words.add("%>");
		reserved_words.add("//");
		reserved_words.add("#");
		reserved_words.add("/**/");
		reserved_words.add("/** */");
		reserved_words.add(".=");
		reserved_words.add("//");
		reserved_words.add("{$");
		reserved_words.add("${");
		reserved_words.add("$this");
		reserved_words.add("$_GET");
		reserved_words.add("$_POST");
		reserved_words.add("$_SERVER");
		//reserved_words.add("$");
		reserved_words.add("--");
		reserved_words.add("++");
		reserved_words.add("/=");
		reserved_words.add("=>");
		reserved_words.add("::");
		reserved_words.add("...");
		reserved_words.add("==");
		reserved_words.add(">=");
		reserved_words.add("===");
		reserved_words.add("!=");
		reserved_words.add("<>");
		reserved_words.add("!==");
		reserved_words.add("<=");
		reserved_words.add("<=>");
		reserved_words.add("-=");
		reserved_words.add("%=");
		reserved_words.add("+=");
		reserved_words.add("\\");
		reserved_words.add("->");
		reserved_words.add("<?php");
		reserved_words.add("<?");
		reserved_words.add("<%");
		reserved_words.add("<?=");
		reserved_words.add("<%=");
		reserved_words.add("|=");
		reserved_words.add("**");
		reserved_words.add("**=");
		reserved_words.add("<<");
		reserved_words.add("<<=");
		reserved_words.add(">>");
		reserved_words.add(">>=");
		reserved_words.add("<<<");
		reserved_words.add("\t");
		reserved_words.add("\r");
		reserved_words.add("\n");
		reserved_words.add("^=");
		reserved_words.add("(");
		reserved_words.add(")");
	} 
	
	private void Fill_Possivel_Ans() {
		Possible_Vul aux;
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo htmlspecialchars ( variable ) ");
		aux.Set_Possible_Ans("echo esc_attr ( variable )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo htmlspecialchars ( String ( variable -> String ) ) ");
		aux.Set_Possible_Ans("echo esc_attr ( String ( variable -> String ) )");
		vul.add(aux);

		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo htmlspecialchars ( variable -> String ) ");
		aux.Set_Possible_Ans("echo esc_attr ( variable -> String )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo $this -> variable ");
		aux.Set_Possible_Ans("echo esc_attr ( $this -> variable )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo variable.variable1 -> String ");
		aux.Set_Possible_Ans("echo variable.esc_attr ( variable1 -> String )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("variable = $_SERVER [ String ] ");
		aux.Set_Possible_Ans("variable = htmlspecialchars ( $_SERVER [ String ])");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("variable = $_SERVER [ String ] ");
		aux.Set_Possible_Ans("variable = esc_html ( $_SERVER [ String ] )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo variable ");
		aux.Set_Possible_Ans("echo esc_html ( variable )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo $_SERVER [ String ] ");
		aux.Set_Possible_Ans("echo htmlspecialchars ( $_SERVER [ String ] )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo $_SERVER [ String ] ");
		aux.Set_Possible_Ans("echo esc_html ( $_SERVER [ String ] )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo gethostbyaddr $_SERVER [ String ] ");
		aux.Set_Possible_Ans("echo esc_html gethostbyaddr ( $_SERVER [ String ] )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo $_SERVER [ 'REQUEST_URI' ] ");
		aux.Set_Possible_Ans("echo esc_url ( $_SERVER [ 'REQUEST_URI' ])");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo $_GET [ String ] ");
		aux.Set_Possible_Ans("echo esc_attr ( $_GET [ String ] )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("http://. $_SERVER [ String ] . $_SERVER [ 'REQUEST_URI' ] ");
		aux.Set_Possible_Ans("http://. $_SERVER [ String ] . urlencode ( $_SERVER [ 'REQUEST_URI' ] )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("variable = $_GET [ String ] ");
		aux.Set_Possible_Ans("variable = ( int ) $_GET [ String ]");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("variable = ( int ) $_GET [ String ] ");
		aux.Set_Possible_Ans("variable = ( int ) esc_attr $_GET [ String ]");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("variable = $_POST [ String ] ");
		aux.Set_Possible_Ans("variable = sanitize_text_field ( $_POST [ String ] )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("variable = $_GET [ String ] ");
		aux.Set_Possible_Ans("variable = esc_html ( $_GET [ String ] )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("echo variable ");
		aux.Set_Possible_Ans("echo esc_html ( variable )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("$this -> delete_post_type ( $_GET [ String ] ) ");
		aux.Set_Possible_Ans("$this -> delete_post_type ( $String )");
		vul.add(aux);
		
		aux = new Possible_Vul();
		aux.Set_Possible_Vul("$this -> delete_taxonomy ( $_GET [ String ] ) ");
		aux.Set_Possible_Ans("$this -> delete_taxonomy ( $String )");
		vul.add(aux);
	}
	
	public List<String> Get_Reserved_Words() { return reserved_words; }
	public List<Possible_Vul> Get_Possible_Vul() {return vul;}
	
	//Obter os arquivos na pasta
	public void Fill_List(String path_folder){
		try {
			File f = new File(path_folder);
			
			if(f.isDirectory()) {
				File[] arr_content = f.listFiles();
				
				File_Line aux;
				
				for(int i=0; i < arr_content.length; i++) {
					if(arr_content[i].isFile()) {
						
						aux = new File_Line(arr_content[i].getName());
						
						Fill_Contain_PHP(path_folder, aux);
						
						Create_Struct(aux);
						
						files.add(aux);
						
					}
					
				}
			}
			
		}catch (Exception e) {
			System.err.println("A pasta não existe.!!!");
		}
	}
	
	//Identifica as linhas que tem código PHP
	public void Fill_Contain_PHP(String path_folder, File_Line aux)throws IOException {
		try{
			
			boolean is_php = false;
			boolean is_coment = false;
			boolean cant_write = false;
			File file_origin = new File(path_folder + "\\" + aux.Get_Name_File());
			FileReader file_r = new FileReader(file_origin);
			
			BufferedReader buffer_r = new BufferedReader(file_r);
			String file_line = buffer_r.readLine();
			int i = 0;
						
			List<String> temp_frag_php = new ArrayList<>();
			temp_frag_php.add(aux.Get_Name_File());
			
			boolean temp = false;

			//Verifica que o string tem os identificadores do código PHP
			while (file_line != null) {
																
				if (file_line.contains("<?php") || file_line.contains("<?PHP")) {
					is_php = true;
					}
				if(file_line.contains("/*") && is_coment == false)
					is_coment = true;

				if((is_php == true) && (is_coment == false)){
					
					//Read files and fill lists
					cant_write = aux.File_Read_Line(file_line, i, is_php, cant_write);
					
					temp = false;
										
				}				
				
				if(is_php == true && is_coment == false && file_line.length() > 1){
					
					temp_frag_php.add(file_line);
					
				}
				if(is_coment == true && file_line.contains("*/")) {
					
					is_coment = false;
				
				}
				if(file_line.contains("?>")) {
					
					is_php = false;
					
				}
				
				file_line = buffer_r.readLine();
				i++;
								
			}
			
			file_r.close();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//Identifica e clasifica ás palavras claves do código PHP
	public String Find_Key_Word(String word) {
		
		int i = 0;
		String exist = "String";
		
		while (i < reserved_words.size() && !reserved_words.get(i).equals(word))
			i ++;
		
		if(i < reserved_words.size() && reserved_words.get(i).contains(word))
			exist = "Key";
		
		else if(word.contains("!")) 
			exist = "Not_Key";
		
		else if(word.contains("$")) 
			exist = "variable";
		
		return exist;
	}
	
	//Criar la Structura
	public void Create_Struct(File_Line aux) {
				
		int cant_line = 0;
		int cant_word = 0;
		
		String text = "";
		String find = "";
		String found = "";
		boolean temp = false;
		
		if(!aux.Get_File_line().isEmpty()) {
			cant_line = aux.Get_No_Line();		
		}
		
		if(cant_line > 0) {
			
			for(int k = 0; k < cant_line; k++) {
				
				cant_word = aux.Get_Line_File(k);
								
				for(int j=0; j<cant_word; j++) {
					
					if(aux.Get_File_line().get(k).get(j).Get_Property().isEmpty()) {
						aux.Get_File_line().get(k).get(j).Set_Property(Find_Key_Word(aux.Get_File_line().get(k).get(j).Get_Word()));
					}
					
					if(aux.Get_File_line().get(k).get(j).Get_Property().equals("Key") || aux.Get_File_line().get(k).get(j).Get_Property().equals("Not_Key") || aux.Get_File_line().get(k).get(j).Get_Property().equals("Symbol")) {
						text = text + aux.Get_File_line().get(k).get(j).Get_Word() + " ";
						find = find + aux.Get_File_line().get(k).get(j).Get_Word() + " ";
						temp = false;
					}
					else {
						
						if(temp == false && aux.Get_File_line().get(k).get(j).Get_Property().equals("String")) {
							text = text + aux.Get_File_line().get(k).get(j).Get_Word() + " ";
							find = find + aux.Get_File_line().get(k).get(j).Get_Property() + " ";
							temp = true;
						}
						
						else if(!aux.Get_File_line().get(k).get(j).Get_Property().equals("String")) {
							text = text + aux.Get_File_line().get(k).get(j).Get_Word() + " ";
							find = find + aux.Get_File_line().get(k).get(j).Get_Property() + " ";
							temp = false;
							}
						}
					if(j == cant_word - 1 && aux.Get_Line_File(k + 1) > 0) {
						temp = false;
						found = Find_Struct(find);
						
						if(found!="") {
							//imprimir nome do arquivo
							System.out.println("----------------------------------------------------------------");
							System.out.println("In the file: " + aux.Get_Name_File());
							//imprimir la linea leida
							System.out.println("In line of code could have a security vulnerability in line: " + text);
							//imprimir el patron solución
							System.out.println("The solution proposed by the repositories is: " + found);
							System.out.println("----------------------------------------------------------------");
						}
												
						text = "";
						find = "";
						found = "";
					}
				}				
			}
			find = "";
		}
	}
	
	
	public String Find_Struct(String find){
		
		String found = "";
		String var = "";
		
		try {
					
			int i = 0;
			
			while(!vul.get(i).Get_Possible_Vul().isEmpty()) {
				
				var = vul.get(i).Get_Possible_Vul();
				
				if(var.equals(find)) {
					found = vul.get(i).Get_Possible_Ans();
					i = vul.size();
				}
				
				i++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return found;
	}	
	
	//Print the name of files
	public void Print_Name_File()
	{
		for(int i = 0; i < files.size(); i++)
		{
			System.out.println(files.get(i).Get_Name_File());
		}
	}
	
}