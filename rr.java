import java.util.*;
import java.util.*;
public class rr1
 { static int qe=0,k=0,qs=0,totalburst=01,queuecall=0;
  public static void main(String[] args) 
 {
 	int n,temp=0,i,j,timediff=0,q,x=0,l=0;
    System.out.println("enter no of jobs");
    Scanner s=new Scanner(System.in);
    n=s.nextInt(); 
    q=s.nextInt(); 
	int a[]= new int[32000];
 	int b[]= new int[32000];
	int wt[]= new int[32000];
 	int tt[]= new int[32000];
	int ct[]= new int[32000];
	int rq[]= new int[32000];
    int ghant[]= new int[32000];
 	int p[]= new int[32000];
    for( i=0;i<n;i++)
 	{
 		a[i]=s.nextInt();
 		b[i]=s.nextInt();
 	    p[i]=i+1;
 	}
 	     for(i=0;i<n;i++)
         totalburst=totalburst+b[i];
	     System.out.println(totalburst);
 	     sortarr(a,b,p,n);//for sorting by arrival time.
         timediff=a[0];//used for st and wt
         queue(a,b,p,rq,n,(b[0]+a[0]),totalburst);
        
         for(i=0;i<n;i++)
         System.out.println(a[i]+"\t"+b[i]+"\t"+p[i]);
        
      
	    
	 /*    for(i=0;i<qe;i++)
           System.out.print(" "+rq[i]);
    	*/
    	 for( i=n;i<totalburst;i++)//coz of 32000
 	       b[i]=10000;   
	    
	     for(i=0;k<totalburst-1;i++)
	     {  l=0;
	       	x=retpro(a,b,p,rq,n);//get process no.
	           if(x==9999)
	        	continue;
	        	else
	        		{
	        			while(l<q)//quanta=q
	        		{  
	        			if(b[x]!=0) //if completes before q
	        		{	
	        			ghant[k]=p[x];//add to chart
	        		    l++;
	        		    k++;
	        		    b[x]=b[x]-1;
	        		    
	        		}  
	        			else
	        			l=q+1;//to make while condition false
	        		 }
	        		 } 
	       if(rq[qs]==0&&b[x]>0)//to avoid unwanted calling	       	 
	      queue(a,b,p,rq,n,k,totalburst); //to fill ready queue
	       			}
	     	System.out.println(" ");  			
	    /*for(i=0;i<qe;i++)//test case 
           System.out.print(" "+rq[i]);
    */	
    	System.out.println(" ");
	    for(i=0;i<totalburst-1;i++)//to print chart
        	System.out.print(" "+ghant[i]);
        System.out.println(" ");
        for(i=1;i<totalburst;i++)//to print chart
           System.out.print(" "+i);
      
        }
        public static void queue(int[] a,int[] b,int[] p,int[] rq,int n,int k,int totalburst)
            {  
        	int i;
        	for(i=0;i<n;i++)
        	if(a[i]<=k&&b[i]>0&&k<=totalburst)
        		{
        		/*	for(int j=0;j<qe;j++)//test case 
                    System.out.print(" "+rq[j]+i);
        		*/
        			rq[qe]=p[i];
        			qe++;
        		}
        		queuecall=rq[qs];
        	/*	if(a[i]>a[p[rq[qe]]])
        			totalburst+=1;
        	*/
        		// System.out.print(" "+rq[]);//test case
        	}
       
       	public static int retpro(int[] a,int[] b,int[] p,int[] rq,int n)
            {int x,y=0;
          //  y=retbool(a,b,p,rq,n);
            x=proid(a,b,p,rq,n);
            	if(qs==qe+1||b[x]==0)
            	{
            		//	System.out.print(" "+rq[qe-1]);
            			return 9999;
            	}
            	else if(y==1)
            	{
            		totalburst+=1;
            		return 9999;
            	}
            	else  if(y==0)
            		return x;
            		else return 0;
            	}
            
        
            
            				
        public static int proid(int[] a,int[] b,int[] p,int[] rq,int n)//finds position in array
            {int i;
                 	for(i=0;i<n;i++)
         				if(p[i]==rq[qs])
            		   		break;	
          //System.out.print(" "+rq[qs]+qs+i);		   		
               qs++;	
              return i;				
            }
        	
        public static int retbool(int[] a,int[] b,int[] p,int[] rq,int n)
        { int x,i;
            	for(i=0;i<n;i++)
         				if(b[i]==0)
            		   		continue;
            		   	else 
            		   		break;
            if (i==n)
            	return 0;
            else return 1;
        	
        	
        }	
        	
        	
        	
        public static int start(int[] ghant,int n,int totalburst,int timediff)
        {
       	 int i;
       	 for(i=0;i<totalburst;i++)
       	 if(ghant[i]==n)
       	 break;
       	 return i+timediff;//i+1 because time is i+1 		
        }
        public static int complete(int[] ghant,int n,int totalburst,int timediff)
        {
       	 int i;
       	 for(i=totalburst-1;i>=0;i--)
       	 if(ghant[i]==n)
       	 break;
       	 return i+timediff;//i+1 because time is i+1 		
        }      
        public static void sortarr(int[] a,int[] b,int p[],int n)
       { 
       	 int i,j,temp;
       	 for(i=0;i<n;i++)	
 		 for( j=i+1;j<n;j++)
 		 {
 		  if(a[i]>a[j])
         {
         temp=a[i];
         a[i]=a[j];
         a[j]=temp;
         temp=b[i];
         b[i]=b[j];
         b[j]=temp;
         temp=p[i];
         p[i]=p[j];
         p[j]=temp;
         }
         else if(a[i]==a[j])
         {
         if(b[i]>b[j])
         {
         temp=a[i];
         a[i]=a[j];
         a[j]=temp;
         temp=b[i];
         b[i]=b[j];
         b[j]=temp;
         temp=p[i];
         p[i]=p[j];
         p[j]=temp;
         }
         }
 		 }//end of for
       }
        /*  public static int sortburst(int[] a,int[] b,int p[],int n)
       {
       	int temp,i,j;
       	for(i=0;i<=n;i++)	
 		for( j=i+1;j<=n;j++)
 		{ 
 			if(b[i]==0)
         	b[i]=10000;
        if(b[i]==0)
 		 {
 		 temp=a[i];
         a[i]=a[n];
         a[n]=temp;
         temp=b[i];
         b[i]=b[n];
         b[n]=temp;
         temp=p[i];
         p[i]=p[n];
         p[n]=temp;	
 		 }
         if(b[i]>b[j])
         {
         temp=a[i];
         a[i]=a[j];
         a[j]=temp;
         temp=b[i];
         b[i]=b[j];
         b[j]=temp;
         temp=p[i];
         p[i]=p[j];
         p[j]=temp;
         }
         else if(b[i]==b[j])
         {
         if(a[i]>a[j])
         {
         temp=a[i];
         a[i]=a[j];
         a[j]=temp;
         temp=b[i];
         b[i]=b[j];
         b[j]=temp;
         temp=p[i];
         p[i]=p[j];
         p[j]=temp;
         }
         }
 		}
        
         temp=p[0];
         b[0]=b[0]-1;
         return temp;
       }//end of sortburst*/
 }
