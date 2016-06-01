import java.util.*;

class Banker{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of process and number of resources");
		int n=s.nextInt();
		int m=s.nextInt();
		int max[][]=new int [n][m];
		int alloc[][]=new int[n][m];
		int need[][]=new int[n][m];
		int totalloc[]=new int[m];
		int totinstan[]=new int[m];
		int finish[]=new int[n];
		String seq=new String();
		
		System.out.println("Enter Total no of instances for every resource");
		for(int i=0;i<m;i++)
			totinstan[i]=s.nextInt();
		
		System.out.println("Enter Max matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				max[i][j]=s.nextInt();
				
		System.out.println("Enter Allocated matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				alloc[i][j]=s.nextInt();
				totalloc[j]+=alloc[i][j];
				}
		
		for(int i=0;i<m;i++)
			totinstan[i]=totinstan[i]-totalloc[i];
			
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				need[i][j]=max[i][j]-alloc[i][j];
					
	//	for(int i=0;i<m;i++)
	//		System.out.print(totinstan[i]+" ");
		
		while(true){
			int avail[]=new int[m];
			for(int i=0;i<m;i++)
				avail[i]=totinstan[i];
			
			for(int i=0;i<n;i++){
				if(finish[i]==1)
					continue;
				int j=0;
				while(j<m && need[i][j]<=avail[j]) 
					j++;
				if(j==m){
					finish[i]=1;
					seq=seq+i;
					for(int z=0;z<m;z++)
						avail[z]+=alloc[i][z];
				}	
			}
				if(Arrays.equals(avail,totinstan))
					break;
				else
					for(int z=0;z<m;z++)
						totinstan[z]=avail[z];
		}
	//	for(int i=0;i<n;i++)
	//	System.out.print(finish[i]+"");
		if(seq.length()==n){
		System.out.println("Safe state!!");	
		System.out.println("Sequence is :"+seq);
		}		
		else
		System.out.println("Unsafe state!!");
			
			
	}
}




/*
 *OUTPUT
 *
 *Enter number of process and number of resources
5
3
Enter Total no of instances for every resource
10
5
7
Enter Max matrix
7 5 3
3 2 2
9 0 2
2 2 2
4 3 3
Enter Allocated matrix
0 1 0
2 0 0
3 0 2
2 1 1
0 0 2
Safe state!!
Sequence is :13402
Press any key to continue...


*/