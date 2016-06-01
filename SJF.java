import java.util.*;
class npsjf
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
		float awt=0,att=0;
		int ans[]=new int[n+1];
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
	    int	small=a[1];
	     for(int i=2;i<=n;i++)	
	    {
	       if(a[i]<small)
	       {
	       	small=a[i];
	       	pos=i;
	       }
	    }
	    bsum=bsum+small;
	    ans[1]=pos;
	    f1[pos]=1;
	    f2[pos]=1;
	  
	    int k=2;
	    for(int i=(small+b[pos]);i<=bsum;i++)
	    {
	       for(int count=1;count<=n;count++)
	       	 { if(a[count]<i && f1[count]!=1) 
	             f2[count]=1;
	         } 
	    pos=-1;   
	    small=999;
	    for(int j=1;j<=n;j++)	
	    {   
	    	if(f2[j]==1 && f1[j]!=1 && b[j]<=small)
	    	{
	    		small=b[j];
	    		pos=j;
	         }	 
	    } 
	    if(pos!=-1)
	    {
	    f1[pos]=1;
	    ans[k++]=pos;
	    i+=b[pos];
	    }
	    
	    
	 }
	    
	    System.out.println("Ghant Chart:");
	   for(int i=1;i<=n;i++)	
	    {   System.out.print(ans[i]+"\t");}
	    
	   
	     System.out.println();
	     System.out.println();
	     System.out.println("Process \t Waiting Time \t Turnaround Time");
	   	
	    for(int i=1;i<=n;i++)
		{   int burst=a[ans[1]],tt=0,j;
		    for( j=1;j<i;j++)
		    burst+=b[ans[j]];
		    tt=burst+b[ans[j]];
		    int ans1= burst - a[ans[i]];
		    awt+=ans1;
		  
		    int ans2= tt - a[ans[i]];
		    att+=ans2;
			System.out.println(p[ans[i]]+" \t\t "+ ans1 +" \t\t "+ans2  );
	    }
	    System.out.println();
	    System.out.println("Average Waiting Time: "+awt/n+"\nAverage Turnaround Time: "+att/n);
	            
    }
}
		
		