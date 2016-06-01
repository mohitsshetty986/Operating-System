import java.util.*;
class bestfit{	
public static void main(String args[])
{
  int b[]=new int[100];
  int visited[]=new int[100];
  int p[]=new int[100];
  int c[]=new int[100];
  int n,i,j,min,fin=0,flag=0;
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
  min=1000;
  for(j=0;j<n;j++)
   if(b[j]<min && visited[j]==0)
   { 
	min=b[j]; 
	fin=j;
   }

    c[i]=fin;
	visited[fin]=1;
   }
  for(i=0;i<n;i++)
    visited[i]=0;

  for(i=0;i<n;i++)
  {
    for(j=0;j<n;j++)
	{

      if(p[i]<b[c[j]] && visited[c[j]]==0)
      { 
		flag=1; 
		visited[c[j]]=1; 
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
}




/*
 OUTPUT
 
 Enter the number of elements
5
Enter the blocks size
100 200 300 400 500
Enter the process size
123 311 142 99 88
123 Process is allocated in position : 2
311 Process is allocated in position : 4
142 Process is allocated in position : 3
99 Process is allocated in position : 1
88 Process is allocated in position : 5
Press any key to continue...



*/