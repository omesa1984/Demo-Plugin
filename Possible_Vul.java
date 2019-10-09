package Thesis;

public class Possible_Vul {
	
	private String vul;
	private String possible_ans;
	
	Possible_Vul(){
		vul = "";
		possible_ans = "";
	}
	
	public String Get_Possible_Vul() { return vul; }
	public String Get_Possible_Ans() { return possible_ans; } 
	
	public void Set_Possible_Vul(String a_vul) {
		vul = a_vul;
	}
	public void Set_Possible_Ans(String a_ans) { possible_ans = a_ans; }
	
}