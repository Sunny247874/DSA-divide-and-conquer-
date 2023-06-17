package devide_Conqure;

public class Randamize_QuickSort {

	
	
	
	public static int partition(int arr[],int l,int h)
	{
		//generate the random index within an array
		
		int randomIndex=l+(int)Math.random()% (h-l+1);
		
		//swap (arr[randomIndex],arr[l])
		
		int temp=arr[randomIndex];
		arr[randomIndex]=arr[l];
		arr[l]=arr[randomIndex];
		
		
		
		int pivot=arr[l];
		int i=l;
		for(int j=l+1;j<=h;j++)
			
		{
			if(arr[j]<=pivot)
			{
				i=i+1;
				// swap(arr[i], arr[j])
				
				int tem=arr[i];
				arr[i]=arr[j];
				arr[j]=tem;
			}
		}
		
		// swap (arr[l], arr[i])
        // to get the correct position of the pivot element
		
		int tem=arr[l];
		arr[l]=arr[i];
		arr[i]=tem;
		
		return i;
		
	}
	
	public static void quickSort(int arr[],int l,int h)
	{
		if(l<h)
		{
			// 1. Divide the array into two subproblems
			
			int m=partition(arr,l,h);
			// 2. Conquer the subproblems via the recursion
			
			quickSort(arr,l,m-1);
			quickSort(arr,m+1,h);
		}
	}
	
	
	public static void printArr(int arr[],int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println(" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr= {34,56,23,67,12,58,49};
		int n=arr.length;
		
		System.out.println("Array before Sorting");
		printArr(arr,n);
		
		quickSort(arr,0,n-1);
		
		System.out.println("Array after Sorting");
		printArr(arr,n);
		
	}

}
