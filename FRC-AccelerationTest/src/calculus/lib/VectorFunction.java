package calculus.lib;

public class VectorFunction 
{
	public Function fx, fy, fz;
	
	public VectorFunction(Function x, Function y, Function z)
	{
		fx = x;
		fy = y;
		fz = z;
	}
	
	public Vector at(int t)
	{
		return new Vector(fx.at(t), fy.at(t), fz.at(t));
	}
	
	public Vector area(int a, int b, int deltaX)
	{
		return new Vector(fx.area(a, b, deltaX), fy.area(a, b, deltaX), fz.area(a, b, deltaX));
	}
}
