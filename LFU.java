import java.util.*;
class lfu
{
	public static void main (String args[])
	{
		int check[]=new int[3];
		int stack[]=new int [3];
		int input[]=new int [20];
		int i,j,n,min,temp=0,hit=0;
		Scanner s =new Scanner (System.in);
		System.out.println("Enter the no of pages");
		n=s.nextInt();
		for(i=0;i<n;i++)
			input[i]=s.nextInt();
		stack[0]=-1;
		stack[1]=-1;
		stack[2]=-1;	
		for(i=0;i<n;i++)
		{
			for(j=0;j<3;j++)
			{
				if(stack[j]==input[i])
				{	
					break;
				}	
			}
		if(j!=3)
		{
			check[j]++;
	    	for(j=0;j<3;j++)
				System.out.print(stack[j]+" ");
			System.out.print("HIT!");
			hit++;
		}
		else
		{
	 	min=99;
		for(j=0;j<3;j++)
		{
			if(min>check[j])
			{	
				min=check[j];
				temp=j;
			}
		}
		stack[temp]=input[i];
		check[temp]=1;
		for(j=0;j<3;j++)
		System.out.print(stack[j]+" ");
		}
    	System.out.println();	
	}
	System.out.println("Total number of hit: "+hit);
	System.out.println("HIT ratio: "+(float)hit/n);
	}
}