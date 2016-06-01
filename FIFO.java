import java.util.*;

class FIFO
{
	public static void main(String args[])
	{
     
		int stack[]=new int[3],input[]=new int[20],i,j,k,n,hit=0;
		System.out.println("Enter the no of pages");
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        System.out.println("Enter the pages");
		for(i=0;i<n;i++)
	    	input[i]=s.nextInt();
        stack[0]=-1;
		stack[1]=-1;
		stack[2]=-1;
		for(i=0,k=0;i<n;i++)
		{
			for(j=0;j<3;j++)
			{
				if(stack[j]==input[i])
					break;
			}
			if(j!=3)
			{
			for(j=0;j<3;j++)
				System.out.print(" "+stack[j]);
			System.out.println(" HIT!");
			hit++;
			continue;
			}
			else
			{
			j=k%3;
			k++;
			stack[j]=input[i];
			for(j=0;j<3;j++)
				System.out.print(" "+stack[j]);
			}
			System.out.println("");
			
		}
		float ratio = (float)hit/n;
		System.out.println("Number Of Hits: "+hit);
		System.out.println("Hit Ratio= "+ ratio);
	}
}
