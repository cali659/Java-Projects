
public class Main {

	public static void main(String[] args) 
	{
		int array[] = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,100000};
		
		int[] outliersRemoved = removeOutliers(array);
		
		System.out.print("New list: ");
		for(int i : outliersRemoved)
			System.out.print(i + " ");
	}
	
	
	/**
	 * Calculates and removes the statistical outliers from an input array.
	 * A statistical outlier is a value that falls outside of 3 standard deviations from the average.
	 * This method should calculate the average and the standard deviation (of a population).
	 * Then, it should create a new array containing the original values, except for the outliers.
	 * The remaining items should be in the same order as they appeared in the original array.
	 * @param arr - the input array
	 * @return a new array containing the original inputs except for the outliers.
	 */
	public static int[] removeOutliers(int[] arr)
	{
		double sum = 0;
		
		for (int num : arr)
		{
			sum += num;
		}
		
		double mean = sum / arr.length;
		
		double sumSquareDifferences = 0;
		
		for (int num : arr)
		{
			sumSquareDifferences += Math.pow(num - mean, 2);
		}
			
		double standardDeviation = Math.sqrt(sumSquareDifferences / arr.length);
		
		double lower = mean - (3 * standardDeviation);
		double upper = mean + (3 * standardDeviation);
		
		int count = 0;
		
		for (int num : arr)
		{
			if (num >= lower && num <= upper)
			{ 
				count++;
			}
		}
		
		int[] result = new int[count];
		
		int index = 0;
		
		for (int num : arr)
		{
			if (num >= lower && num <= upper)
			{
				result[index] = num;
				index++;
			}
		}
		return result;
	}
	
}
