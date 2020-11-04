import java.util.*;
public class Main {
	
	static ArrayList<String> pk=new ArrayList<String>();
	public static void the_order(char ch[],String p,int i,int check) {
		
		if(i>=ch.length) {
			if(p.length()==ch.length-1)
			pk.add(p);
			return;
		}
		if(check==0) {
			the_order(ch,p+Character.toString(ch[i]),i+1,0);
			the_order(ch,p,i+1,1);
		}
		else if(check==1) {
			
			the_order(ch,p+Character.toString(ch[i]),i+1,1);
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		char ch[]=s.toCharArray();
		the_order(ch,"",0,0);
		Collections.sort(pk);
		System.out.println(pk.get(0));

	}

}
