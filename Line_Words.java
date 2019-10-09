package Thesis;

import java.util.ArrayList;
import java.util.List;

//lista de palavras por linhas
public class Line_Words {
	private List<Word_Property> list_words;
		
	public Line_Words() {
		list_words = new ArrayList<Word_Property>();		
	}
	
	public Line_Words(List<Word_Property> list_words) {
		this.list_words = list_words;
	}
	
	public List<Word_Property> Get_Words_File() {return list_words;}
	public void Add_Words_Property(Word_Property word) {list_words.add(word);}
	public int Search_Words_Property(Word_Property word) {
		int pos_words = 0;
		
		while (pos_words < list_words.size() && list_words.get(pos_words).Get_Word() != word.Get_Word())
			pos_words ++;
				
		
		return pos_words;
	}
	public void Update_Words_property(Word_Property word) {
		 
		list_words.set(Search_Words_Property(word), word);
		 
	}
	
	public void Biuld_List_Word(String string_test) {}
}