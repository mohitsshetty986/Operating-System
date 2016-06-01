import java.util.*;
class lru
{
	public static void main (String args[])
	{
	


	int check[]=new int[3],stack[]=new int [3] ,input[]=new int [20] ,i,j,p=3,n,min,temp=0,hit=0;
	Scanner s =new Scanner (System.in);

	System.out.println("Enter the no of pages");
	n=s.nextInt();
	for(i=0;i<n;i++)
	input[i]=s.nextInt();
	stack[0]=-1;
	stack[1]=-1;
	stack[2]=-1;
	check[0]=0;
	check[1]=1;
	check[2]=2;
	for(i=0;i<n;i++)
	{
		for(j=0;j<3;j++)
		{
			if(stack[j]==input[i])
			break;
		}
	if(j!=3)
	{
		check[j]=p;
		p++;
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
		{	min=check[j];
		temp=j;
		}

	}
	stack[temp]=input[i];
	check[temp]=p;
	p++;
	for(j=0;j<3;j++)
	System.out.print(stack[j]+" ");
	}
    System.out.println();	
}
System.out.println("Total number of hit: "+hit);
System.out.println("HIT ratio: "+(float)hit/n);
}
}




/* OUTPUT Enter the no of pages
5
6
5
7
2
6
6 -1 -1
6 5 -1
6 5 7
2 5 7
6 5 7
Total number of hit: 0
HIT ratio: 0.0
Press any key to continue...


*/