package Thesis;

import java.util.Scanner;

public class Main_XSS {

	public static void main(String[] args) {
		
		Process to_process = new Process();
		
		System.out.println ("Hello");

        System.out.println ("Please, enter the forlder's path where the project is located.:");

        String path = "";

        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        path = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner

        System.out.println ("Wait however the app tests the files at the path you entered: \"" + path +"\"");
        
        to_process.To_Process(path);
        
        System.out.println ("The process is over");
		
	}

}