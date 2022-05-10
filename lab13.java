import java.io.FileInputStream;
import java.util.ArrayList;

public class lab13 {

	ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public void readData(String filename)
	{
		try {
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new FileInputStream(filename)));
			String inn;
			//inn = input.readLine();
		
			while((inn = input.readLine()) != null)
			{
				arrayList.add(Integer.parseInt(inn));
			}
			input.close();
		}
		catch(Exception e) 
		{	
		}
	}
	
	public long getTotalCount() 
	{
		long totalCount = arrayList.stream()
				.count();
		return totalCount;
	}
	
	public long getOddCount()
	{
		long oddCount = arrayList.stream()
				.filter(x-> x % 2 == 1)
				.count();
		return oddCount;
	}
	
	public long getEvenCount()
	{
		long evenCount = arrayList.stream()
				.filter(x-> x % 2 == 0)
				.count();
		return evenCount;
	}
	
	public long getDistinctGreaterThanFiveCount() 
	{
		long totalCount = arrayList.stream()
				.distinct()
				.filter(x -> x > 5)
				.count();
		return totalCount;
	}
	
	public Integer[] getResult1()
	{
		Integer[] result = arrayList.stream()
				.sorted()
				.filter(x -> x % 2 == 0)
				.filter(x -> (x > 5 && x < 50))
				.toArray(Integer[]::new);
		return result;
	}
	
	public Integer[] getResult2()
	{
		Integer[] result = arrayList.stream()
				.limit(50)
				.map(x -> ((x * x) * 3))
				.toArray(Integer[]::new);
		return result;
	}
	
	public Integer[] getResult3()
	{
		Integer[] result = arrayList.stream()
				.filter(x -> x % 2 == 1)
				.map(x -> (x*2))
				.sorted()
				.skip(20)
				.distinct()
				.toArray(Integer[]::new);
		return result;
	}
	
	
}
