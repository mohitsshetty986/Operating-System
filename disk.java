import java.util.*;
class disk{
	static int minsd[]=new int[5];
	static int opt;
	static int ans[]=new int[100];
	public static void main(String args[]){
		Scanner scr=new Scanner(System.in);
		int n,k=0;
		System.out.println("Enter number of processes");
		n=scr.nextInt();
		int q[]=new int[n+1];
		System.out.println("Enter initial head position");
		q[0]=scr.nextInt();
		System.out.println("Enter number of cylinders");
		int c=scr.nextInt();
		System.out.println("Enter the processes");
		for(int i=1;i<=n;i++)
			q[i]=scr.nextInt();
		while(opt!=6)
		{
		System.out.println("Enter the option");
		System.out.println("1. FCFS");
		System.out.println("2. SSTF");
		System.out.println("3. SCAN");
		System.out.println("4. CSCAN");
		System.out.println("5. CLOOK");
		System.out.println("6. EXIT");
		opt=scr.nextInt();
		switch(opt)
		{
			case 1: fcfs(q,n);
					break;
			case 2: sstf(q,n);
					break;
			case 3: scan(q,n,c);
					break;
			case 4: cscan(q,n,c);
					break;
			case 5: clook(q,n);
					break;
			default:break;	
		}
		}
		int minimum=minsd[0];
		for(int m=0;m<5;m++)
		{
			if(minimum>minsd[m])
			{	
				minimum=minsd[m];
				k=m;
			}	
		}
		System.out.println("Option "+(k+1)+" has minimum seek distance of "+minimum);
		}
	static void fcfs(int q[],int n){
		
		for(int i=0;i<n+1;i++)
			ans[i]=q[i];
		seek(ans,n);
	}
	
	static void sstf(int q[],int n){
		int head=q[0];
		int small,i,k=0;
		int visited[]=new int[n+1];
		ans[0]=head;
		for(int j=1;j<n+1;j++)
		{	small=999;
			for(i=1;i<n+1;i++)
			{
				if(small>Math.abs((head-q[i])) && visited[i]!=1)
				{
					small=Math.abs(head-q[i]);
					k=i;
				}
			}
		visited[k]=1;
		ans[j]=q[k];
		}
	
		seek(ans,n);
	}
	
	static void scan(int q[],int n,int c)
	{	int head=q[0];
		int qu[]=new int[n+1];
		int k=0,j=0;
		for(int i=0;i<n+1;i++)
			qu[i]=q[i];
		Arrays.sort(qu);
		for(int i=0;i<n+1;i++)
			if(qu[i]==head)
			{
				k=i;
				break;
			}
		if(Math.abs(qu[k]-qu[k-1])<Math.abs(qu[k]-qu[k+1]))
		{	
			for(int i=k;i>=0;i--)
				ans[j++]=qu[i];
			ans[j++]=0;
			for(int i=k+1;i<=n;i++)
				ans[j++]=qu[i];				
		}
		else
		{
			for(int i=k;i<=n;i++)
				ans[j++]=qu[i];
			ans[j++]=c;
			for(int i=k-1;i>=0;i--)
				ans[j++]=qu[i];				
		}
		seek1(ans,n);
	}
	
		
	static void cscan(int q[],int n,int c)
	{	int head=q[0];
		int qu[]=new int[n+1];
		int k=0,j=0;
		for(int i=0;i<n+1;i++)
			qu[i]=q[i];
		Arrays.sort(qu);
		for(int i=0;i<n+1;i++)
			if(qu[i]==head)
			{
				k=i;
				break;
			}
		if(Math.abs(qu[k]-qu[k-1])<Math.abs(qu[k]-qu[k+1]))
		{	
			for(int i=k;i>=0;i--)
				ans[j++]=qu[i];
			ans[j++]=0;
			ans[j++]=c;
			for(int i=n;i>=k+1;i--)
				ans[j++]=qu[i];				
		}
		else
		{
			for(int i=k;i<=n;i++)
				ans[j++]=qu[i];
			ans[j++]=c;
			ans[j++]=0;
			for(int i=0;i<=k-1;i++)
				ans[j++]=qu[i];				
		}
		seek1(ans,n);
	}
	
		static void clook(int q[],int n)
	{	int head=q[0];
		int qu[]=new int[n+1];
		int k=0,j=0;
		for(int i=0;i<n+1;i++)
			qu[i]=q[i];
		Arrays.sort(qu);
		for(int i=0;i<n+1;i++)
			if(qu[i]==head)
			{
				k=i;
				break;
			}
		if(Math.abs(qu[k]-qu[k-1])<Math.abs(qu[k]-qu[k+1]))
		{	
			for(int i=k;i>=0;i--)
				ans[j++]=qu[i];
			for(int i=n;i>=k+1;i--)
				ans[j++]=qu[i];				
		}
		else
		{
			for(int i=k;i<=n;i++)
				ans[j++]=qu[i];
			for(int i=0;i<=k-1;i++)
				ans[j++]=qu[i];				
		}
		seek(ans,n);
	}				
	static void seek(int ans[],int n)
	{	
		int sd=0;
			System.out.print(ans[0]+" ");
		for(int i=1;i<=n;i++)
		{	System.out.print(ans[i]+" ");
			sd=sd+Math.abs(ans[i-1]-ans[i]);
		}
		System.out.println();	
		System.out.println("Seek Distance : "+sd);
		minsd[opt-1]=sd;
		
	}
	
	static void seek1(int ans[],int n)
	{	
		int sd=0;
			System.out.print(ans[0]+" ");
		for(int i=1;i<=n+1;i++)
		{	System.out.print(ans[i]+" ");
			sd=sd+Math.abs(ans[i-1]-ans[i]);
		}
		System.out.println();	
		System.out.println("Seek Distance : "+sd);
		minsd[opt-1]=sd;
	}
}





			/* OUTPUT
			Enter number of processes
4
Enter initial head position
53
Enter number of cylinders
200
Enter the processes
23
45
67
89
Enter the option
1. FCFS
2. SSTF
3. SCAN
4. CSCAN
5. CLOOK
6. EXIT
1
53 23 45 67 89
Seek Distance : 96
Enter the option
1. FCFS
2. SSTF
3. SCAN
4. CSCAN
5. CLOOK
6. EXIT
2
53 45 67 23 89
Seek Distance : 140
Enter the option
1. FCFS
2. SSTF
3. SCAN
4. CSCAN
5. CLOOK
6. EXIT
3
53 45 23 0 67 89
Seek Distance : 142
Enter the option
1. FCFS
2. SSTF
3. SCAN
4. CSCAN
5. CLOOK
6. EXIT
4
53 45 23 0 200 89
Seek Distance : 364
Enter the option
1. FCFS
2. SSTF
3. SCAN
4. CSCAN
5. CLOOK
6. EXIT
*/