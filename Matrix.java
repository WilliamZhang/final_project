package final_project;

public final class Matrix {
	// number of rows
	private final int M;
	// number of columns
	private final int N;
	// M-by-N array
	private final double[][] data;

	// create M-by-N matrix with all 0's filled
	// implement the function __init__
	public Matrix(int M, int N) {
		if (M < 1 || N < 1) {
			throw new RuntimeException("Incompatible matrix dimensions");
		}
		this.M = M;
		this.N = N;
		data = new double[M][N];
	}

	// create M-by-N matrix with all the same double value filled
	// implement the function __init__
	public Matrix(int M, int N, double fill) {
		if (M < 1 || N < 1) {
			throw new RuntimeException("Incompatible matrix dimensions");
		}
		this.M = M;
		this.N = N;
		data = new double[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				data[i][j] = fill;
			}
		}
	}

	// create matrix based on one 2D array
	// implement the function __init__
	public Matrix(double[][] data) {
		M = data.length;
		N = data[0].length;
		this.data = new double[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				this.data[i][j] = data[i][j];
			}
		}
	}

	// copy constructor
	private Matrix(Matrix A) {
		this(A.data);
	}

	// accessor method
	// implement the function __getitem__
	public double getitem(int i, int j) {
		return data[i][j];
	}

	// mutator method
	// implement the function __setitem__
	public void setitem(int i, int j, double val) {
		this.data[i][j] = val;
	}

	// return one row from matrix
	// implement the function row
	public Matrix row(int i) {
		Matrix A = new Matrix(1, N);
		for (int j = 0; j < N; j++) {
			A.data[0][j] = this.data[i][j];
		}
		return A;
	}

	// return one column from matrix
	// implement the function column
	public Matrix col(int j) {
		Matrix A = new Matrix(M, 1);
		for (int i = 0; i < M; i++) {
			A.data[i][0] = this.data[i][j];
		}
		return A;
	}

	// get the data from matrix and store them in one 2D array
	// implement the function as_list
	public double[][] as_list() {
		double[][] d = new double[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				d[i][j] = data[i][j];
			}
		}
		return d;
	}

	// store the data into one string
	// implement the function str
	public String str() {
		String string = "{ ";
		Matrix A = this;
		double[][] d = A.as_list();
		for (int i = 0; i < M - 1; i++) {
			string += "{ ";
			for (int j = 0; j < N - 1; j++) {
				string += d[i][j] + ", ";
			}
			string += d[i][N - 1] + " }, ";
		}
		string += "{ ";
		for (int j = 0; j < N - 1; j++) {
			string += d[M - 1][j] + ", ";
		}
		string += d[M - 1][N - 1] + " } }";
		return string;
	}

	// create and return a random M-by-N matrix with values between 0 and 1
	public static Matrix random(int M, int N) {
		Matrix A = new Matrix(M, N);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				A.data[i][j] = Math.random();
			}
		}
		return A;
	}

	// create and return the N-by-N identity matrix
	// implement the function identity with one argument
	public static Matrix identity(int N) {
		Matrix I = new Matrix(N, N);
		for (int i = 0; i < N; i++) {
			I.data[i][i] = 1;
		}
		return I;
	}

	// implement the function identity with two arguments
	public static Matrix identity2(int N, double one) {
		Matrix I = new Matrix(N, N);
		for (int i = 0; i < N; i++) {
			I.data[i][i] = one;
		}
		return I;
	}

	// implement the function identity with three arguments
	public static Matrix identity3(int N, double one, double fill) {
		Matrix I = new Matrix(N, N, fill);
		for (int i = 0; i < N; i++) {
			I.data[i][i] = one;
		}
		return I;
	}

	// create one diagonal matrix from one array
	// implement the function diagonal
	public static Matrix diagonal(double[] d) {
		int len = d.length;
		Matrix D = new Matrix(len, len);
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i == j) {
					D.data[i][j] = d[i];
				} else {
					D.data[i][j] = 0;
				}

			}
		}
		return D;
	}

	// build a matrix from one 2D array
	// implement the function from_list
	public static Matrix from_list(double[][] data) {
		int m = data.length;
		int n = data[0].length;
		Matrix A = new Matrix(m, n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A.data[i][j] = data[i][j];
			}
		}
		return A;
	}

	// return C = A + B
	// implement the function __add__
	public Matrix add(Matrix B) {
		Matrix A = this;
		if (B.M != A.M || B.N != A.N) {
			throw new RuntimeException("Incompatible matrix dimensions");
		}
		Matrix C = new Matrix(M, N);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				C.data[i][j] = A.data[i][j] + B.data[i][j];
			}
		}
		return C;
	}

	// return C = A - B
	// implement the function __sub__
	public Matrix sub(Matrix B) {
		Matrix A = this;
		if (B.M != A.M || B.N != A.N) {
			throw new RuntimeException("Incompatible matrix dimensions");
		}
		Matrix C = new Matrix(M, N);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				C.data[i][j] = A.data[i][j] - B.data[i][j];
			}
		}
		return C;
	}

	// return C = B + A
	// implement the function radd
	public Matrix radd(Matrix B) {
		return add(B);
	}

	// return C = B - A
	// implement the function rsub
	public Matrix rsub(Matrix B) {
		return this.neg().add(B);
	}

	// return C = -A
	// implement the function neg
	public Matrix neg() {
		Matrix A = new Matrix(M, N);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				A.data[i][j] = (-1) * data[i][j];
			}
		}
		return A;
	}

	// return C = A * x
	// implement the function rmul
	public Matrix rmul(double x) {
		Matrix A = this;
		Matrix C = new Matrix(A.M, A.N);
		for (int i = 0; i < C.M; i++) {
			for (int j = 0; j < C.N; j++) {
				C.data[i][j] = x * A.data[i][j];
			}
		}
		return C;
	}

	// return C = A * B
	// implement the function mul
	public Matrix mul(Matrix B) {
		Matrix A = this;
		if (A.M == B.M && A.N == 1 && B.N == 1) {
			Matrix temp = new Matrix(1, 1);
			double sum = 0;
			for (int i = 0; i < B.M; i++) {
				sum += A.data[i][0] * B.data[i][0];
			}
			temp.data[0][0] = sum;
			return temp;
		}
		if (A.N != B.M) {
			throw new RuntimeException("Incompatible matrix dimensions");
		}
		Matrix C = new Matrix(A.M, B.N);
		for (int i = 0; i < C.M; i++) {
			for (int j = 0; j < C.N; j++) {
				for (int k = 0; k < A.N; k++) {
					C.data[i][j] += (A.data[i][k] * B.data[k][j]);
				}
			}
		}
		return C;
	}

	// return B = A^-1 * x
	// implement the function rdiv
	public Matrix rdiv(double x) {
		Matrix A = this.inverse();
		return A.rmul(x);
	}

	// return C = A / B, aka C = A * B^-1
	// implement the function div
	public Matrix div(Matrix B) {
		Matrix A = this;
		Matrix Bin = B.inverse();
		return A.mul(Bin);
	}

	// return B = A^-1, aka the inverse of matrix A
	public Matrix inverse() {
		Matrix A = new Matrix(this);
		if (A.M != A.N) {
			throw new RuntimeException("Incompatible matrix dimensions");
		}
		Matrix B = Matrix.identity(N);

		// Gaussian elimination with partial pivoting
		for (int i = 0; i < N; i++) {

			// find pivot row and swap
			int max = i;
			for (int j = i + 1; j < N; j++) {
				if (Math.abs(A.data[j][i]) > Math.abs(A.data[max][i])) {
					max = j;
				}
			}
			A.swap_rows(i, max);
			B.swap_rows(i, max);

			// singular
			if (A.data[i][i] == 0.0) {
				throw new RuntimeException("Matrix is singular.");
			}

			// pivot within A and B
			for (int j = i + 1; j < N; j++) {
				double m = A.data[j][i] / A.data[i][i];

				for (int k = i + 1; k < N; k++) {
					A.data[j][k] -= A.data[i][k] * m;
				}
				A.data[j][i] = 0.0;

				for (int k = 0; k < N; k++) {
					B.data[j][k] -= B.data[i][k] * m;
				}
			}

		}

		// elementary transformations
		for (int i = N - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				double m = A.data[j][i] / A.data[i][i];

				A.data[j][i] -= A.data[i][i] * m;

				for (int k = 0; k < N; k++) {
					B.data[j][k] -= B.data[i][k] * m;
				}
			}
		}

		// get the inverse
		for (int i = 0; i < N; i++) {
			double m = A.data[i][i];

			A.data[i][i] = 1.0;

			for (int j = 0; j < N; j++) {
				B.data[i][j] = B.data[i][j] / m;
			}
		}

		return B;
	}

	// return x = A^-1 * b, assuming A is square and has full rank
	public Matrix solve(Matrix v) {
		if (M != N || v.M != N || v.N != 1) {
			throw new RuntimeException("Incompatible matrix dimensions");
		}

		// create copies of the data
		Matrix A = new Matrix(this);
		Matrix b = new Matrix(v);

		// Gaussian elimination with partial pivoting
		for (int i = 0; i < N; i++) {

			// find pivot row and swap
			int max = i;
			for (int j = i + 1; j < N; j++) {
				if (Math.abs(A.data[j][i]) > Math.abs(A.data[max][i])) {
					max = j;
				}
			}
			A.swap_rows(i, max);
			b.swap_rows(i, max);

			// singular
			if (A.data[i][i] == 0.0) {
				throw new RuntimeException("Matrix is singular.");
			}

			// pivot within b
			for (int j = i + 1; j < N; j++) {
				b.data[j][0] -= b.data[i][0] * A.data[j][i] / A.data[i][i];
			}

			// pivot within A
			for (int j = i + 1; j < N; j++) {
				double m = A.data[j][i] / A.data[i][i];
				for (int k = i + 1; k < N; k++) {
					A.data[j][k] -= A.data[i][k] * m;
				}
				A.data[j][i] = 0.0;
			}
		}

		// back substitution
		Matrix x = new Matrix(N, 1);
		for (int j = N - 1; j >= 0; j--) {
			double t = 0.0;
			for (int k = j + 1; k < N; k++) {
				t += A.data[j][k] * x.data[k][0];
			}
			x.data[j][0] = (b.data[j][0] - t) / A.data[j][j];
		}

		return x;
	}

	// return if A equals B or not
	public boolean equal(Matrix B) {
		Matrix A = this;
		if (B.M != A.M || B.N != A.N) {
			throw new RuntimeException("Incompatible matrix dimensions");
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (A.data[i][j] != B.data[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	// swap row i and row j
	// implement the function swap_rows
	public void swap_rows(int i, int j) {
		double[] temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	// return the transpose of the invoking matrix
	// implement the function t
	public Matrix transpose() {
		Matrix A = new Matrix(N, M);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				A.data[j][i] = this.data[i][j];
			}
		}
		return A;
	}

	// print matrix to standard output
	public void show() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%9.4f", data[i][j]);
			}
			System.out.println();
		}
	}

	// is this matrix almost symmetric?
	// implement the function is_almost_symmetric
	public boolean is_almost_symmetric() {
		double ap = 1e-6;
		double rp = 1e-4;
		if (M != N) {
			return false;
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				double delta = Math.abs(data[i][j] - data[j][i]);
				double tmp = Math.max(Math.abs(data[i][j]),
						Math.abs(data[j][i]))
						* rp;
				if (delta > ap && delta > tmp) {
					return false;
				}
			}
		}
		return true;
	}

	// is this matrix almost zero?
	// implement the function is_almost_zero
	public boolean is_almost_zero() {
		double ap = 1e-6;
		double rp = 1e-4;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				double delta = Math.abs(data[i][j] - data[j][i]);
				double tmp = Math.max(Math.abs(data[i][j]),
						Math.abs(data[j][i]))
						* rp;
				if (delta > ap && delta > tmp) {
					return false;
				}
			}
		}
		return true;
	}

	// compute one norm for this matrix; return maximum column sum
	// implement the function norm
	public double norm(int p) {
		double m = 0.0;
		if (M == 1 || N == 1) {
			double s = 0.0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					s += Math.pow(data[i][j], p);
				}
			}
			m = Math.pow(s, 1.0 / p);
		} else {
			if (p != 1) {
				throw new RuntimeException("Not Implemented Error");
			}

			for (int j = 0; j < N; j++) {
				double s = 0;
				for (int i = 0; i < M; i++) {
					s += Math.abs(data[i][j]);
				}
				m = Math.max(m, s);
			}
		}
		return m;
	}

	// compute infinity norm for this matrix; return maximum row sum
	public double norm_infi() {
		double m = 0;
		for (int i = 0; i < M; i++) {
			double s = 0;
			for (int j = 0; j < N; j++) {
				s += Math.abs(data[i][j]);
			}
			m = Math.max(m, s);
		}
		return m;
	}

	// compute frobenius norm; return sqrt of sum of squares of all elements
	public double norm_frob() {
		double m = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				m = Math.hypot(m, data[i][j]);
			}
		}
		return m;
	}

	// compute the condition number for this matrix
	// implement the function condition_number
	public double condition_number() {
		Matrix A = this;
		Matrix Ainv = A.inverse();
		return A.norm(1) * Ainv.norm(1);
	}

	// compute the exp for this matrix
	// implement the function exp
	public Matrix exp() {
		double ap = 1e-6;
		double rp = 1e-4;
		int ns = 40;
		int k = 1;

		Matrix A = this;
		Matrix t = Matrix.identity(A.N);
		Matrix s = Matrix.identity(A.N);

		for (k = 1; k < ns; k++) {
			t = t.mul(A).rmul(1.0 / k);
			s = s.add(t);
			double temp = s.norm(1) * rp;
			if (t.norm(1) < Math.max(ap, temp)) {
				return s;
			}
		}

		if (k == ns) {
			throw new RuntimeException("No Convergence");
		}

		return s;
	}

	// Cholesky Decomposition
	// implement the function Cholesky
	public Matrix Cholesky() {
		Matrix A = new Matrix(this);
		if (A.is_almost_symmetric() == false) {
			throw new ArithmeticException("Not Symmetric");
		}

		for (int k = 0; k < N; k++) {
			if (A.data[k][k] <= 0) {
				throw new ArithmeticException("Not Positive Definitive");
			}
			double p = A.data[k][k] = Math.sqrt(A.data[k][k]);
			for (int i = k + 1; i < N; i++) {
				A.data[i][k] = A.data[i][k] / p;
			}
			for (int j = k + 1; j < N; j++) {
				p = A.data[j][k];
				for (int i = k + 1; i < N; i++) {
					A.data[i][j] = A.data[i][j] - p * A.data[i][k];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				A.data[i][j] = 0;
			}
		}

		return A;
	}

	// implement the function is_positive_definite
	public boolean is_positive_definite() {
		Matrix A = this;
		if (A.is_almost_symmetric() == false) {
			return false;
		}
		try {
			A.Cholesky();
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	// return B = A - x
	public Matrix minus(double x) {
		Matrix A = this;
		Matrix B = new Matrix(this);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				B.data[i][j] = A.data[i][j] - x;
			}
		}
		return B;
	}

	// assess Markovitz risk/return
	// implement the function Markovitz
	public Box<Matrix, Matrix, Matrix> Markovitz(Matrix mu, double r_free) {
		Box<Matrix, Matrix, Matrix> container = new Box<Matrix, Matrix, Matrix>();

		Matrix A = this;
		Matrix x = new Matrix(A.M, 1);
		x = A.inverse().mul(mu.minus(r_free));
		double sum = 0;
		for (int r = 0; r < x.M; r++) {
			sum += x.data[r][0];
		}
		x = x.rmul(1.0 / sum);

		Matrix portfolio = new Matrix(1, x.M);
		for (int i = 0; i < x.M; i++) {
			portfolio.data[0][i] = x.data[i][0];
		}

		Matrix portfolio_return = mu.mul(x);
		Matrix portfolio_risk = (x.mul(A.mul(x))).sqrt();

		container.setT(portfolio);
		container.setU(portfolio_return);
		container.setV(portfolio_risk);

		return container;

	}

	// implement the function sqrt
	public Matrix sqrt() {
		Matrix A = new Matrix(this);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				A.data[i][j] = Math.sqrt(A.data[i][j]);
			}
		}
		return A;
	}

}