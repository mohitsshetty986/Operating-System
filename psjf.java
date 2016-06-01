import java.util.*;
class psjf
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter no of processes");
		int n=s.nextInt();
		int a[]=new int[n+1];
		int b[]=new int[n+1];
		int p[]=new int[n+1];
		int f1[]=new int[n+1];
	    int f2[]=new int[n+1];
	    int tt[]=new int[n+1];
	    int wt[]=new int[n+1];
		float awt=0,att=0;
		int ans[]=new int[50];
		int pos=1,bsum=0;
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter the bursttime and arrival time of Process "+i);
			p[i]=i;
			b[i]=s.nextInt();
			a[i]=s.nextInt();
	    }
	    System.out.println();
	    System.out.println("Process \t Bursttime \t Arrival time");

	    for(int i=1;i<=n;i++)
		{
			System.out.println(""+p[i]+" \t\t "+b[i]+" \t\t "+a[i]);
	    }
	   System.out.println();
	    for(int i=1;i<=n;i++)
	    {
	      bsum=	bsum+b[i];
	    }
	    for(int i=1;i<=n;i++)
	    {
	      f1[i]=b[i];
	    }
	    int	small=a[1];pos=1;
	     for(int i=2;i<=n;i++)
	    {
	       if(a[i]<=small)
	       {
	       	  if(a[i]==small)
	       	  {	if(b[i]<b[pos])
	       	  	{  small=a[i];
	            	pos=i;
	           	}
	       	  }
	       	  else
	       	  {
	       	  	small=a[i];
	       	    pos=i;
	       	  }

	       }
	    }
	    bsum=bsum+small;
	    ans[1]=pos;
	    f1[pos]--;
	    f2[pos]=1;

	    int k=2;

	    for(int i=(small+1);i<bsum;i++)
	    {
	       for(int j=1;j<=n;j++)
	       {
	       	if(a[j]<=i)
	       	{f2[j]=1;

	       	}
	       }
          int smallbt=999;
	       for(int j=1;j<=n;j++)
	       {
	       	if(f2[j]==1 && f1[j]>0 && b[j]<smallbt)
	    	{
	    		smallbt=b[j];
	    		pos=j;
	         }
	       }
	       ans[k++]=pos;
	       f1[pos]--;

	   }
	   System.out.println("Ghant Chart:");
	   for(int i=1;i<k;i++)
	    {
	    	System.out.print(ans[i]+"\t");
	    }
          System.out.println();

        for(int i=1;i<=n;i++)
		{
		   for(int j=1;j<k;j++)
		   {
		   	if(ans[j]==i)
		   		pos=j;
		   }
		   tt[i]=pos-a[i]+small;
		}
		 for(int i=1;i<=n;i++)
		{
			att=att+tt[i];
		}
		att=att/n;

		 for(int i=1;i<=n;i++)
		{   int pos1=0,pos2=0;
		   for(int j=1;j<k;j++)
		   {
		   	if(ans[j]==i && ans[j-1]!=i)
		   	{
		   		pos1=j;
		   		wt[i]=wt[i]+pos1-pos2;

		   	}
		   	if(ans[j]==i && ans[j+1]!=i)
		   	{
		   		pos2=j+1;

		   	}
		   }

		   wt[i]=wt[i]-a[i]+small-1;

     	}

         for(int i=1;i<=n;i++)
		{
			awt=awt+wt[i];
		}
		awt=awt/n;

	     System.out.println();
	     System.out.println();
	     System.out.println("Process \t Waiting Time \t Turnaround Time");

	    for(int i=1;i<=n;i++)
		{
			System.out.println(p[i]+" \t\t "+ wt[i] +" \t\t "+tt[i]  );
	    }
	    System.out.println();
	    System.out.println("Average Waiting Time: "+awt+"\nAverage Turnaround Time: "+att);

    }
}

