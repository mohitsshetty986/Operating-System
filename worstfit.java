import java.util.*;
class worstfit{	
 static int b[]=new int[100];
 static int visited[]=new int[100];
 static int p[]=new int[100];
 static int c[]=new int[100];
public static void main(String args[])
{
 
  int n,i,j,flag=0;
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
    maximum(n);
    for(j=0;j<n;j++)
    {
      if(p[i]<=b[c[j]] && b[c[j]]!=0)
      { 
		flag=1; 
		b[c[j]]-=p[i]; 
		break;
	  }

      else
		flag=0;
    }

    if(flag==1)
       System.out.println(p[i]+" Process is allocated in position :"+" "+(c[j]+1));

    else
	    System.out.println(p[i]+" Process cannot be allocated to any block");

  }
 }
 
 static void maximum(int n){
 	 int fin=0,max=0;
 	 for(int i=0;i<n;i++)
        visited[i]=0;
 	 for(int i=0;i<n;i++)
  	{
 	 max=0;
 	 for(int j=0;j<n;j++)
  	 if(b[j]>max && visited[j]==0)
     { 
		max=b[j]; 
		fin=j;
      }

      c[i]=fin;
	  visited[fin]=1;
  }
 }
}



/*
 *
 *OUTPUT
 *
 *
 *Enter the number of elements
4
Enter the blocks size
100 350 450 600
Enter the process size
123 345 675 345
123 Process is allocated in position : 4
345 Process is allocated in position : 4
675 Process cannot be allocated to any block
345 Process is allocated in position : 3
Press any key to continue...

*/