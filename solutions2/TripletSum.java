package solutions2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TripletSum {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		int length=input.nextInt();
		int[] nums=new int[length];
		for(int index=0;index<length;index++) {
			nums[index]=input.nextInt();
		}
		triplets(nums);
	}
	
	public static void triplets(int[] nums) {
		Set<List<Integer>> ans=new HashSet<>();
		Arrays.sort(nums);
		for(int index=0;index<nums.length-1;index++) {
			int left=index+1;
			int right=nums.length-1;
			while(left<right) {
				if(nums[index]+nums[left]==-nums[right]) {
					ans.add(Arrays.asList(nums[index],nums[left],nums[right]));
					left++;
					right--;
				}
				else if(nums[index]+nums[left]<-nums[right]) {
					left++;
				}
				else
				{
					right--;
				}
			}
		}
		System.out.println(ans);
	}

}
