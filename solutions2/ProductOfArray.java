package solutions2;

import java.util.Scanner;

public class ProductOfArray {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int length=input.nextInt();
		int[] nums=new int[length];
		for(int index=0;index<length;index++) {
			nums[index]=input.nextInt();
		}
		productExceptSelf1(nums);
	}
	
	public static void productExceptSelf1(int[] nums) {
		
		int left[]=new int[nums.length];
		left[0]=1;
		for(int index=1;index<nums.length;index++) {
			left[index]=left[index-1]*nums[index-1];
		}
		
		int right[]=new int[nums.length];
		right[nums.length-1]=1;
		for(int index=nums.length-2;index>=0;index--) {
			right[index]=right[index+1]*nums[index+1];
		}
		
		for(int index=0;index<nums.length;index++) {
			nums[index]=left[index]*right[index];
			if(index<nums.length-1)
				System.out.print(nums[index]+",");
		}
		System.out.print(nums[nums.length-1]);
	}
}
