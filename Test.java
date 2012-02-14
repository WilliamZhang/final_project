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

		// test method is_almost_symmetric
		System.out.println("testing method is_almost_symmetric: ");
		System.out.println(C.is_almost_symmetric());
		System.out.println();

		// test method is_almost_zero
		System.out.println("testing method is_almost_zero: ");
		System.out.println(C.is_almost_zero());
		System.out.println();

		// test method norm
		System.out.println("testing method norm: ");
		System.out.println(B.norm(1));
		System.out.println();

		// test method norm_infi
		System.out.println("testing method norm_infi: ");
		System.out.println(B.norm_infi());
		System.out.println();

		// test method norm_frob
		System.out.println("testing method norm_frob: ");
		System.out.println(B.norm_frob());
		System.out.println();

		// test method condition_number
		System.out.println("testing method condition_number: ");
		System.out.println(C.condition_number());
		System.out.println();
		
		// test method exp
		System.out.println("testing method exp: ");
		double[][] dexp = {{1,2},{3,4}};
		Matrix L = Matrix.from_list(dexp);
		L.exp().show();
		System.out.println();
		
		
	}

}
