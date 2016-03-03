package model;

import java.lang.Math;

public class Exponential extends Expression {
	private Expression variable;
	private Expression base;
	
	public Exponential(Expression variable, Expression base) {
		this.variable = variable;
		this.base = base;
		
	}
	
	@Override
	public Expression derivative(Variable var) {
		return new Multiply(base, new Exponential(variable, new Subtract(base, new Value(1.0))));
	}

	@Override
	public Expression integrate(Variable var) {
		return null;
	}

	@Override
	public double calc() throws Exception {
		return Math.pow(this.variable.calc(), this.base.calc());
	}

	@Override
	public String stringify() {
		return this.base.stringify() + "^" + this.variable.stringify();
	}

}
