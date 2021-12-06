
public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("this is my new sorting method");
		functionarray();
		System.out.println("this is my new sorting method end");

	}
		
 public static void functionarray() {		
	int[] arr= {23,125,6,8,10,31,9,56,7,23,363,98};
	
	int len=arr.length,temp,j;
	
		
	for(int i=0;i<=len-1;i++)
	
	{
		for(j=0;j<=i;j++)
		{
			
			if(arr[j]<=arr[i])
			{
				temp=arr[i];
				
			}
		
			else
			{
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}

		}

		
		}	
	
	for(int x=0;x<=len-1;x++) 
	{
	System.out.println(arr[x]);	
	}
		
}
	
	
	

}
