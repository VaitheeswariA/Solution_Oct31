package solutions2;


import java.util.Scanner;



public class GreaterElement {
	
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int length=input.nextInt();
		Node head=new Node(input.nextInt());
		Node temp=head;
		for(int index=0;index<length-1;index++) {
			Node current=new Node(input.nextInt());
			temp.next=current;
			temp=temp.next;
		}
		Node temp1=greater(head);
		System.out.print("[");
		while(temp1.next!=null) {
			System.out.print(temp1.data+",");
			temp1=temp1.next;
		}
		System.out.print(temp1.data);
		System.out.print("]");
	}
	
	public static Node  greater(Node head) {
		Node checkNode=head;
		while(checkNode.next!=null) {
			if(checkNode.next.data >checkNode.data) {
				checkNode.data=checkNode.next.data;
				checkNode=checkNode.next;
			}
			else {
				Node tempCheck=checkNode;
				int max=0;
				while(tempCheck.next!=null) {
					if(tempCheck.next.data>checkNode.data) {
						max=tempCheck.next.data;
						break;
					}
					tempCheck=tempCheck.next;
				}
				checkNode.data=max;
				checkNode=checkNode.next;
			}
		}
		checkNode.data=0;
		return head;
	}
}
