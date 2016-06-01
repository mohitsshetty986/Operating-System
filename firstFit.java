import java.util.*;
class firstFit{	
public static void main(String args[])
{
  int b[]=new int[100];
  int visited[]=new int[100];
  int p[]=new int[100];
  int n,i,j,max=0,position=-1;
  System.out.println("Enter the number of elements");
  Scanner s=new Scanner(System.in);
  n=s.nextInt();
  System.out.println("Enter the blocks size");
  for(i=0;i<n;i++)
   b[i]=s.nextInt();
  System.out.println("Enter the process size");

  for(i=0;i<n;i++)
    {
    	p[i]=s.nextInt();
		visited[i]=0;
	}

  for(i=0;i<n;i++)
	{
    max=0;
	for(j=0;j<n;j++)
      if(max<b[j] && visited[j]!=1)
		{ 
		max=b[j]; 
		position=j;
		}	
	visited[position]=1;
	if(p[i]<max)
	  System.out.println(p[i]+" Process is allocated in position :"+" "+(position+1));
    else
      System.out.println(p[i]+" Process cannot be allocated to any block");

  }
}
}



/* OUTPUT
 *
 *Enter the number of elements
4
Enter the blocks size
100 300 500 700
Enter the process size
123 234 345 699
123 Process is allocated in position : 4
234 Process is allocated in position : 3
345 Process cannot be allocated to any block
699 Process cannot be allocated to any block
Press any key to continue...

*/