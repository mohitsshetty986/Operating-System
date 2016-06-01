import java.util.*;
class optimal{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter The No Of Processes");
	int n=sc.nextInt();
	int framesize=4,i,j,k,temp=0;
	int p[]=new int[n];
	int d[]=new int[n];
	int frame[]=new int[framesize];
	frame[0]=-1;frame[1]=-1;frame[2]=-1;
	System.out.println("Enter The Processes");
	for(i=0;i<n;i++){
		p[i]=sc.nextInt();
	    }

  outer:for(i=0;i<n;i++)
	{   for(int m=0;m<3;m++)
		if(p[i]==frame[m]) continue outer;
		filld(d,p,frame,i);

		for(j=n-1;j>=0;j--)
		{
		if(d[j]==-1)
			continue;
			
		if((k=occur(frame,d[j]))!=-1 && frame[temp]!=-1)
		{frame[k]=p[i];
		 temp++;
		  break;
			}
					
		if(j==0)
		frame[temp++]=p[i];	
		if(temp==3)
			temp=0;	
		
		
	}
	System.out.println(frame[0]+" "+frame[1]+" "+frame[2]);	
    }
    }
    static int occur(int frame[],int value)
    {int i=-1;
    	for(int j=0;j<3;j++)
    	if(frame[j]==value)
    	{ i=j;
    	break;
    	}	
    return i;	
    }
   
   
    static void filld(int d[],int p[],int f[],int n)
    { 
    	int temp=0,j,i,x,z,y ;
    	for(i=0;i<p.length;i++){
	    		d[i]=-1;
      	}
    	for(i=n;i<p.length;i++)
		{	
			for(j=0;j<p.length;j++)
				if(p[i]==d[j])
					break;
	
			if(j==p.length)
				 d[temp++]=p[i];
			
		}
		for(x=d.length-1;x>=0;x--)
		 if(d[x]!=-1)break;
		 x=x+1;
	
	   for(z=2;z>=0;z--){
	    for(y=0;y<d.length;y++)
	    	if(d[y]==f[z])break;
	    if(y==d.length)
	    d[x++]=f[z];
	 }
	    	
	    		 
		 
    }	
	
	
	}