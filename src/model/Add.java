package model;

public class Add extends Expression {
	private Expression left, right;
	
	public Add(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Expression derivative(Variable var) throws Exception {
		Expression deriv = new Add(this.left.derivative(var), this.right.derivative(var));
		return deriv;
	}

	@Override
	public Expression integrate(Variable var) throws Exception {
		Expression integration = new Add(this.left.integrate(var), this.right.integrate(var));
		return integration;
	}

	@Override
	public double calc() throws Exception {
		return this.left.calc() + this.right.calc();
	}

	@Override
	public String stringify() {
		return this.left.stringify() + " + " + this.right.stringify();
	}

}
