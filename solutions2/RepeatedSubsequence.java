package solutions2;

import java.util.ArrayList;
import java.util.Scanner;

public class RepeatedSubsequence {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.next();
		ArrayList<String> subsequence=new ArrayList<>();

		subsequence=subseq("",s);
		System.out.println(subsequence);
		boolean flag=true;
		int count=0;
		for(int index=0;index<subsequence.size();index++) {
			int n=subsequence.get(index).length();
			int index1=2;
			if(subsequence.get(index).length()>3) {
				flag=true;
				for(int limit=2;limit<=subsequence.get(index1).length()/2;limit++) {
					String subCheck=subsequence.get(index).substring(0,limit);
					while(index1<n-1) {
						String original=subsequence.get(index).substring(index1,index1+limit);
						if(!original.equals(subCheck)){
							flag=false;
						}
						index1+=2;
					}
					
				}
				
			}
			if(flag)
			{
			count++;
			flag=false;
			System.out.println(subsequence.get(index));
			}
		}
		
		
		System.out.println(count);
		
	}
	static ArrayList<String> subseq(String processed,String unprocessed)
	{
		if(unprocessed.isEmpty()) {
			ArrayList<String> eachseq=new ArrayList<>();
			eachseq.add(processed);
			return eachseq;
		}
		
		char ch=unprocessed.charAt(0);
		
		ArrayList<String> left=subseq(processed+ch,unprocessed.substring(1));
		ArrayList<String> right=subseq(processed,unprocessed.substring(1));
		
		left.addAll(right);
		return left;
 	}
}
