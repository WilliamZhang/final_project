package final_project;

public class SpecFunc implements Function {

	@Override
	// define f(x) = y = x, where x is a double
	public double apply(double x) {
		return x * x + 2 * x + 1;
	}

	@Override
	// define f(x) = x, where x is an array
	public double[] apply(double[] array) {
		int len = array.length;
		double[] array2 = new double[len];

		for (int i = 0; i < len; i++) {
			array2[i] = apply(array[i]);
		}

		return array2;
	}

	@Override
	// define f(x) = x, where x is an array of arrays
	public double[][] apply(double[][] data) {
		int row = data.length;
		int col = data[0].length;
		double[][] data2 = new double[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data2[i][j] = apply(data[i][j]);
			}
		}

		return data2;
	}

	@Override
	// define f(x) = x, where x is a Matrix
	public Matrix apply(Matrix A) {
		double[][] data = A.as_list();
		Matrix B = new Matrix(apply(data));
		return B;
	}

}
