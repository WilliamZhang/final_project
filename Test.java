package final_project;

public class Test {
	/**
	 * The following is the test client used to test if Matrix works well or
	 * not. Also, each test has a comment to explain which part in Matrix is
	 * tested.
	 */

	public static void main(String[] args) {
		// testing constructor one
		System.out.println("testing constructor one: ");
		Matrix A = new Matrix(3, 3);
		A.show();
		System.out.println();

		// testing constructor two
		System.out.println("testing constructor two: ");
		Matrix B = new Matrix(3, 3, 1.1);
		B.show();
		System.out.println();

		// testing constructor three
		System.out.println("testing constructor three: ");
		double[][] data = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Matrix C = new Matrix(data);
		C.show();
		System.out.println();

		// testing accessor method getitem
		System.out.println("testing accessor method getitem: ");
		System.out.println("\t" + C.getitem(1, 1));
		System.out.println();

		// testing mutator method setitem
		System.out.println("testing mutator method setitem: ");
		C.setitem(1, 1, 5.5555);
		C.show();
		System.out.println();

		// testing method row
		System.out.println("testing method row: ");
		C.row(1).show();
		System.out.println();

		// testing method column
		System.out.println("testing method column: ");
		C.col(1).show();
		System.out.println();

		// testing method as_list
		System.out.println("testing method as_list: ");
		double[][] d = C.as_list();
		Matrix D = new Matrix(d);
		D.show();
		System.out.println();

		// testing method str
		System.out.println("testing method str: ");
		System.out.println(D.str());
		System.out.println();

		// testing method random
		System.out.println("testing method random: ");
		Matrix E = Matrix.random(4, 4);
		E.show();
		System.out.println();

		// testing method identity
		System.out.println("testing method identity: ");
		Matrix F = Matrix.identity(5);
		F.show();
		System.out.println();

		// testing method identity2
		System.out.println("testing method identity2: ");
		Matrix G = Matrix.identity2(5, 6.6);
		G.show();
		System.out.println();

		// testing method identity3
		System.out.println("testing method identity3: ");
		Matrix H = Matrix.identity3(5, 6.6, 3.33);
		H.show();
		System.out.println();

		// testing method diagonal
		System.out.println("testing method diagonal: ");
		double[] diag = { 1, 3, 5 };
		Matrix Diag = Matrix.diagonal(diag);
		Diag.show();
		System.out.println();

		// testing method from_list
		System.out.println("testing method from_list: ");
		Matrix fromlist = Matrix.from_list(data);
		fromlist.show();
		System.out.println();

		// testing method add
		System.out.println("testing method add: ");
		A.add(B).show();
		System.out.println();

		// testing method sub
		System.out.println("testing method sub: ");
		A.sub(B).show();
		System.out.println();

		// testing method radd
		System.out.println("testing method radd: ");
		A.radd(B).show();
		System.out.println();

		// testing method rsub
		System.out.println("testing method rsub: ");
		A.rsub(B).show();
		System.out.println();

		// testing method neg
		System.out.println("testing method neg: ");
		B.neg().show();
		System.out.println();

		// testing method rmul
		System.out.println("testing method rmul: ");
		B.rmul(0.5).show();
		System.out.println();

		// testing method mul
		System.out.println("testing method mul: ");
		B.mul(C).show();
		System.out.println();

		// testing method rdiv
		System.out.println("testing method rdiv: ");
		C.rdiv(1.1).show();
		System.out.println();

		// testing method div
		System.out.println("testing method div: ");
		B.div(C).show();
		System.out.println();

		// testing method inverse
		System.out.println("testing method inverse: ");
		double[][] din = { { 1, 2, 3 }, { 2, 1, 2 }, { 1, 3, 4 } };
		Matrix I = new Matrix(din);
		Matrix inver = I.inverse();
		inver.show();
		System.out.println();

		// testing method solve
		System.out.println("testing method solve: ");
		Matrix b = new Matrix(3, 1, 2);
		Matrix J = C.solve(b);
		J.show();
		System.out.println();

		// testing method equal
		System.out.println("testing method equal: ");
		System.out.println(inver.equal(C));
		System.out.println(J.equal(b));
		System.out.println();

		// testing method swap_rows
		System.out.println("testing method swap_rows: ");
		inver.swap_rows(1, 2);
		inver.show();
		System.out.println();

		// testing method transpose
		System.out.println("testing method transpose: ");
		Matrix K = inver.transpose();
		K.show();
		System.out.println();

		// testing method is_almost_symmetric
		System.out.println("testing method is_almost_symmetric: ");
		System.out.println(C.is_almost_symmetric());
		System.out.println();

		// testing method is_almost_zero
		System.out.println("testing method is_almost_zero: ");
		System.out.println(C.is_almost_zero());
		System.out.println();

		// testing method norm
		System.out.println("testing method norm: ");
		System.out.println(B.norm(1));
		System.out.println();

		// testing method norm_infi
		System.out.println("testing method norm_infi: ");
		System.out.println(B.norm_infi());
		System.out.println();

		// testing method norm_frob
		System.out.println("testing method norm_frob: ");
		System.out.println(B.norm_frob());
		System.out.println();

		// testing method condition_number
		System.out.println("testing method condition_number: ");
		System.out.println(C.condition_number());
		System.out.println();

		// testing method exp
		System.out.println("testing method exp: ");
		double[][] dexp = { { 1, 2 }, { 3, 4 } };
		Matrix L = Matrix.from_list(dexp);
		L.exp().show();
		System.out.println();

		// testing method Cholesky
		System.out.println("testing method Cholesky: ");
		double[][] cholesky = { { 3, 3, 5 }, { 3, 5, 9 }, { 5, 9, 17 } };
		Matrix Cho = Matrix.from_list(cholesky);
		Cho.Cholesky().show();
		System.out.println();

		// testing method is_positive_definite
		System.out.println("testing method is_positive_definite: ");
		System.out.println(Cho.is_positive_definite());
		System.out.println();

		// testing method Markovitz
		System.out.println("testing method Markovitz: ");
		double[][] mark1 = { { 0.04, 0.006, 0.02 }, { 0.006, 0.09, 0.06 },
				{ 0.02, 0.06, 0.16 } };
		double[][] mark2 = { { 0.10 }, { 0.12 }, { 0.15 } };
		Matrix cov = Matrix.from_list(mark1);
		Matrix mu = Matrix.from_list(mark2);
		double r_free = 0.05;
		Box<Matrix, Matrix, Matrix> container = cov.Markovitz(mu, r_free);
		container.getT().show();
		container.getU().show();
		container.getV().show();
		System.out.println();

		// testing method sqrt
		System.out.println("testing method sqrt: ");
		Matrix sqrt = new Matrix(3, 3, 4);
		sqrt.sqrt().show();
		System.out.println();

		// testing f(x), where x is a double
		System.out.println("testing function f(x), where x is a double: ");
		Function f = new SpecFunc();
		double x = 2.0;
		System.out.println(f.apply(x));
		System.out.println();

		// testing f(x), where x is an array
		System.out.println("testing function f(x), where x is an array: ");
		double[] array = { 1, 2, 3 };
		double[] array2 = f.apply(array);
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();
		System.out.println();

		// testing f(x), where x is an array of arrays
		System.out
				.println("testing function f(x), where x is an array of arrays: ");
		double[][] fdata = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] fdata2 = f.apply(fdata);
		int frow = fdata2.length;
		int fcol = fdata2.length;
		for (int i = 0; i < frow; i++) {
			for (int j = 0; j < fcol; j++) {
				System.out.printf("%9.4f", fdata2[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		// testing f(x), where x is a Matrix
		System.out.println("testing function f(x), where x is a Matrix: ");
		Matrix fA = new Matrix(fdata);
		Matrix fB = f.apply(fA);
		fB.show();
		System.out.println();

		// testing method D
		System.out.println("testing method D: ");
		Function Df = new SpecFunc();
		Algorithm Algo = new Algorithm();
		System.out.println(Algo.D(Df, 2));
		System.out.println();

		// testing method fit_least_squares
		System.out.println("testing method fit_least_squares: ");
		double[][] f_points = { { 1, 2 }, { 3, 4 } };
		Function[] f_fls = { new SpecFunc() };
		Box<double[][], Double, Matrix> f_container = Algo.fit_least_squares(
				f_points, f_fls);
		Matrix f_fitA = new Matrix(f_container.getT());
		f_fitA.show();
		System.out.printf("%9.4f", f_container.getU());
		System.out.println();
		f_container.getV().show();
		System.out.println();

		// testing method solve_fixed_point
		System.out.println("testing method solve_fixed_point: ");
		double sfp_x = -2.0;
		Function sfp_f = new SpecFunc();
		Algorithm sfpAl = new Algorithm(sfp_f);
		System.out.println(sfpAl.solve_fixed_point(sfp_f, sfp_x));
		System.out.println();

		// testing method solve_bisection
		System.out.println("testing method solve_bisection: ");
		double sb_a = -1.0;
		double sb_b = 0.0;
		Function sb_f = new SpecFunc();
		Algorithm sbnAl = new Algorithm();
		System.out.println(sbnAl.solve_bisection(sb_f, sb_a, sb_b));
		System.out.println();

		// testing method solve_newton
		System.out.println("testing method solve_newton: ");
		double sn_x = 0.0;
		Function sn_f = new SpecFunc();
		System.out.println(sbnAl.solve_newton(sn_f, sn_x));
		System.out.println();

	}

}
