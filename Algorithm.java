package final_project;

public class Algorithm {

	private Function function;
	private double h = 1e-6;

	public Algorithm() {

	}

	public Algorithm(Function function) {
		this.function = function;
	}

	// implement the function D(f), first derivative of f
	public double D(Function f, double x) {
		return (f.apply(x + h) - f.apply(x - h)) / 2 / h;
	}

	// implement the function eval_fitting_function used for the next function
	public Matrix eval_fitting_function(Function[] f, Matrix c, double x) {
		Matrix A = c;
		Matrix tmp;

		if (f.length == 1) {
			tmp = A.rmul(f[0].apply(x));
		} else {
			double s = 0.0;
			for (int i = 0; i < f.length; i++) {
				s += f[i].apply(x) * A.getitem(i, 0);
			}
			tmp = new Matrix(1, 1);
			tmp.setitem(0, 0, s);
		}

		return tmp;
	}

	// implement the function fit_least_squares
	public Box<double[][], Double, Matrix> fit_least_squares(double[][] points,
			Function[] f) {
		Box<double[][], Double, Matrix> container = new Box<double[][], Double, Matrix>();

		int prow = points.length;
		int flen = f.length;
		Matrix A = new Matrix(prow, flen);
		Matrix b = new Matrix(prow, 1);

		for (int i = 0; i < prow; i++) {
			double weight = 0.0;
			if (points[i].length > 2) {
				weight = 1.0 / points[i][2];
			} else {
				weight = 1.0;
			}
			double val = weight * points[i][1];
			b.setitem(i, 0, val);
			for (int j = 0; j < flen; j++) {
				double val2 = weight * f[j].apply(points[i][0]);
				A.setitem(i, j, val2);
			}
		}

		Matrix c = ((A.transpose().mul(A)).inverse()).mul(A.transpose().mul(b));
		Matrix chi = A.mul(c).add(b.neg());
		double chi2 = Math.pow(chi.norm(2), 2);

		double x = 1.0;
		Matrix fitting_f = eval_fitting_function(f, c, x);

		container.setT(c.as_list());
		container.setU(chi2);
		container.setV(fitting_f);

		return container;
	}

	// implement the function g used for the next function
	public double g(double x) {
		// f(x)=0 <=> g(x)=x
		return function.apply(x) + x;
	}

	// implement the function solve_fixed_point
	public double solve_fixed_point(Function f, double x) {
		double ap = 1e-6;
		double rp = 1e-4;
		int ns = 100;

		Algorithm al = new Algorithm(f);
		double Dg = D(al.function, g(x));

		for (int k = 0; k < ns; k++) {
			if (Math.abs(Dg) >= 1) {
				throw new ArithmeticException("error D(g)(x)>=1");
			}
			double x_old = x;
			x = g(x);
			double tmp = Math.max(ap, norm(x) * rp);
			if (k > 2 && norm(x_old - x) < tmp) {
				return x;
			}
		}

		throw new ArithmeticException("no convergence");
	}

	// implement the function norm
	public double norm(double x) {
		return Math.abs(x);
	}

	// implement the function solve_bisection
	public double solve_bisection(Function f, double a, double b) {
		double ap = 1e-6;
		double rp = 1e-4;
		int ns = 100;

		double fa = f.apply(a);
		double fb = f.apply(b);
		if (fa == 0) {
			return a;
		}
		if (fb == 0) {
			return b;
		}
		if (fa * fb > 0) {
			throw new ArithmeticException(
					"f(a) and f(b) must have opposite sign");
		}
		for (int k = 0; k < ns; k++) {
			double x = (a + b) / 2;
			double fx = f.apply(x);
			double tmp = Math.max(ap, norm(x) * rp);
			if (fx == 0 || norm(b - a) < tmp) {
				return x;
			} else if (fx * fa < 0) {
				b = x;
				fb = fx;
			} else {
				a = x;
				fa = fx;
			}
		}

		throw new ArithmeticException("no convergence");
	}

	// implement the function solve_newton
	public double solve_newton(Function f, double x) {
		double ap = 1e-6;
		double rp = 1e-4;
		int ns = 20;

		for (int k = 0; k < ns; k++) {
			double fx = f.apply(x);
			double Dfx = D(f, x);
			if (norm(Dfx) < ap) {
				throw new ArithmeticException("unstable solution");
			}
			double x_old = x;
			x = x - fx / Dfx;
			double tmp = Math.max(ap, norm(x) * rp);
			if (k > 2 && norm(x - x_old) < tmp) {
				return x;
			}
		}

		throw new ArithmeticException("no convergence");
	}
}
