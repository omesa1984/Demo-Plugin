package Thesis;

//propiedades das palavras
public class Word_Property{
	private String word;
	private String property;
	
	public Word_Property() {
		word = "";
		property = "";
	}
	
	public Word_Property(String word) {
		this.word = word;
		property = "";
	}
	
	public Word_Property(String word, String property) {
		this.word = word;
		this.property = property;
	}
	
	public String Get_Word() {return word;}
	public String Get_Property() {return property;}
	
	public void Set_Word(String word) {this.word = word;}
	public void Set_Property(String property) {this.property = property;}
}