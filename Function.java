package final_project;

public interface Function {

	// f(x), where x is a double
	public double apply(double x);

	// f(x), where x is an array
	public double[] apply(double[] array);

	// f(x), where x is an array of arrays
	public double[][] apply(double[][] data);

	// f(x), where x is a Matrix
	public Matrix apply(Matrix A);

}
