/*
 *	Shaun Mbateng
 *	Dominating Value
 *	This program finds the location of which elements fits the requirements to be the leader,
 *		if any, in a given array of integers.
 *	It has a time complexity of O(N). 
 */

import java.util.Scanner; //For User Inputs

public class DominatingValue 
{
	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in); //For Inputs
		int len; //Length of Array
		int [] values; //Array to Check
		int location; //Location of Leading Value
		Dominator Set = new Dominator();
		
		//Enter and Set Array Length
		System.out.print("Enter the Array Length: ");
		len = cin.nextInt();
		values = new int [len];
		System.out.println();
		
		//Fill Arrays
		for (int i=0; i<len; i++)
		{
			System.out.print("Enter Element "+(i+1)+": ");
			values[i] = cin.nextInt();
		}
		
		cin.close(); //No More Inputs Needed
		location = Set.getLocation(values); //Get Dominating Value
		System.out.println(); //Print Line Space
		
		//Print Message Depending on Result
		if (location==-1)
			System.out.println("There is No Dominating Value");
		else
			System.out.println("The Leading Value is at Element "+(++location));
	}
}