import java.util.*;
 class FCFS
{
 public static void main (String [] args)
 {
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter Number of Process");
   int n = sc.nextInt();
   int pid[]=new int[n];
   int ar[]=new int[n];
   int bt[]=new int[n];
   int ct[]=new int[n];
   int tat[]=new int[n];
   int wt[]=new int[n];
   int temp;
   float totalwt=0,totaltat=0;
   for (int i=0;i<n;i++)
   {
       System.out.println("Enter the Process "+(i+1)+" arrival time");
       ar[i]=sc.nextInt();
   }
   for (int i=0;i<n;i++)
   {
    System.out.println("Enter the Process "+(i+1)+" burst time");
    bt[i]=sc.nextInt();   
   }

   for(int i=0;i<n;i++)
   {
       for(int j=0;j<n-(i+1);j++){
       if(ar[j]>ar[j+1])
       {
           temp=ar[j];
           ar[j]=ar[j+1];
           ar[j+1]=temp;
           temp=bt[j];
           bt[j]=bt[j+1];
           bt[i+1]=temp;
           temp=pid[j];
           pid[j]=pid[j+1];
           pid[j+1]=temp;
       }
       }
   }

   for(int i=0;i<n;i++)
   {
       if(i==0)
       {
           ct[i]=ar[i]+bt[i];
       }
       else
       {
           ct[i]=ct[i-1]+bt[i];
       }
       tat[i]=ct[i]-ar[i];
       wt[i]=tat[i]-bt[i];
       totalwt+=wt[i];
       totaltat+=tat[i];
   }
   System.out.println("\npid  arrival  brust  complete turn waiting");
    for(int  i = 0 ; i< n;  i++)
     {
       System.out.println(i+1 + "  \t " + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t"  + wt[i] ) ;
      }
       sc.close();
    System.out.println("\naverage waiting time: "+ (totalwt/n));     // printing average waiting time.
    System.out.println("average turnaround time:"+(totaltat/n));    // printing average turnaround time.
}
}

   


