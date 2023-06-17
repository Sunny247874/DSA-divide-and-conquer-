package devide_Conqure;

import java.util.Arrays;

public class CountOf_Inversion {

	//Brute froc approche
	//time complexity-> O(n^2)
	public static int inversionCount(int arr[],int n)
	{
		
		int count=0;
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]>arr[j])
				{
					count++;
				}
			}
		}
		
		return count;
	}
	
	//Divide Conqure Method
	//time complexity--> O(n log n)
	public static int mergeProcedure(int arr1[],int l,int mid,int h)
	{
		int swap=0;
		// taken the extra space - O(n)
		int []lsubarray=Arrays.copyOfRange(arr1,l,mid+1);
		int []rsubarray=Arrays.copyOfRange(arr1, mid+1, h+1);
		
		int i=0,j=0,k=l;
		
		while(i<lsubarray.length && j<rsubarray.length)
		{
			if(lsubarray[i]<=rsubarray[j])
			{
				arr1[k++]=lsubarray[i++];
			}
			else
			{
				arr1[k++]=rsubarray[j++];
				
				swap+=(mid+1)-(l-i);
			}
		}
		
		
		while(i<lsubarray.length)
		{
			arr1[k++]=lsubarray[i++];
			
		}
		while(j<rsubarray.length)
		{
			arr1[k++]=rsubarray[j++];
		}
		
		return swap;
	}
	
	// function definition of counting of number of inversions via Divide and Conquer Approach
	    
	public static int inversionCountOpt(int arr1[],int l,int h)
	{
		int count=0;
		
		if(l<h)
		{
			//1. Divide the array into subproblems
			
			int mid=l+(h-l)/2;
			//2. Conquer the subproblems via the concept of Recursion
            // left subarray
			count+=inversionCountOpt(arr1,l,mid);
			//right subarray
			count+=inversionCountOpt(arr1,mid+1,h);
			
			//3. Combine the result of left and right subarray to get the final solution
			
			count+=mergeProcedure(arr1,l,mid,h);
			
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,5,2,8,3,4};
		int n=arr.length;
		int count=inversionCount(arr,n);
		
		System.out.println("The inversion Count of Brute Force:"+ count);
		
		int arr1[]= {70,50,60,10,20,30,80,15};
		//int n1=arr1.length;
		
		int countOpt=inversionCountOpt(arr1,0,n-1);
		
		System.out.println("The inversion count OFdivide and conqure approach:"+countOpt);
				
		
	}

}
