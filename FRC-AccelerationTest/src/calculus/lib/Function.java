package calculus.lib;

import java.util.HashMap;
import java.util.Map;

public class Function 
{
	private Map<Integer, Double> f = new HashMap<Integer, Double>();
	
	public Function()
	{
		f.clear();
	}
	
	public void addPoint(int time, double value)
	{
		f.put(time, value);
	}
	
	public double at(int time)
	{
		return f.get(time);
	}
	
	public void clear()
	{
		f.clear();
	}
	
	public double area(int a, int b, int deltaX)
	{
		double area = at(a);
		
		for(int i = a + deltaX; i < b; i += deltaX)
		{
			area += 2 * at(i);
		}
		
		area += at(b);
		
		return (area * deltaX / 2);
	}
}
