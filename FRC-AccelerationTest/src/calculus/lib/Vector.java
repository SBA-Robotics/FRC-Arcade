package calculus.lib;

public class Vector 
{
	public double[] components;
	
	public Vector(int dimension)
	{
		components = new double[dimension];
	}
	
	public Vector(double... comp)
	{
		components = comp;
	}
	
	public double magnitude()
	{
		double sum = 0;
		
		for(double i : components)
		{
			sum += Math.pow(i, 2);
		}
		
		return Math.sqrt(sum);
	}
}
