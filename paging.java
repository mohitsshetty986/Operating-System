import java.util.*;

class paging
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int pagetable[][],i,j;
		System.out.println("Enter the size of pages");
		int pagesize=s.nextInt();
		System.out.println("Enter the size of frame");
		int framesize=s.nextInt();
		pagetable=new int[pagesize][2];
		pagetable[0][0]=2;
		pagetable[0][1]=20;
		pagetable[1][0]=5;
		pagetable[1][1]=5;
		pagetable[2][0]=8;
		pagetable[2][1]=10;
		pagetable[3][0]=10;
		pagetable[3][1]=20;
		int z=4;
		System.out.println("Enter the no of pages");
		int inputsize=s.nextInt();
		
		System.out.println("Enter the input sequence");
		int input[]=new int[inputsize];
		for(i=0;i<inputsize;i++)
			input[i]=s.nextInt();
		
		for(i=0;i<inputsize;i++)
		{
			for(j=0;j<pagesize;j++)
			{
				if(input[i]==pagetable[j][0])
					break;
			}
			if(j==pagesize)
			{
				int q=1,g;
				for(g=0;g<pagesize;g++)
				{
					if(pagetable[g][1]==q)
						q++;
				}
				System.out.println("Fault Occured");
				pagetable[z][0]=input[i];
				pagetable[z][1]=q;
				z++;
			}
			else
			{
				System.out.println("Hit Occured for "+input[i]);
			}
		}
		
		for(i=0;i<pagesize;i++)
		{	
			System.out.println("Page: "+pagetable[i][0]+" Frame: "+pagetable[i][1]);
		}
		
	}
}

/*
OUTPUT:
H:\Studies\OS\Experiments\Experiment 10>java paging
Enter the size of pages
10
Enter the size of frame
50
Enter the no of pages
5
Enter the input sequence
8
6
2
3
4
Hit Occured for 8
Fault Occured
Hit Occured for 2
Fault Occured
Fault Occured
Page: 2 Frame: 20
Page: 5 Frame: 5
Page: 8 Frame: 10
Page: 10 Frame: 20
Page: 6 Frame: 1
Page: 3 Frame: 2
Page: 4 Frame: 3
Page: 0 Frame: 0
Page: 0 Frame: 0
Page: 0 Frame: 0
*/