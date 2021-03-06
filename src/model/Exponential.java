package model;

import java.lang.Math;

import exception.CannotIntegrateException;

public class Exponential extends Expression {
	private Expression base;
	private Expression variable;
	
	public Exponential(Expression base, Expression variable) {
		this.base = base;
		this.variable = variable;
		
		this.varList.addAll(this.base.getUsingVariables());
		this.varList.addAll(this.variable.getUsingVariables());
	}
	
	public Exponential(Expression base, Expression variable, double co) {
		this.base = base;
		this.variable = variable;
		this.coefficient = co;
		
		this.varList.addAll(this.base.getUsingVariables());
		this.varList.addAll(this.variable.getUsingVariables());
	}
	
	@Override
	public Expression derivative(Variable var) throws Exception {
		if(!this.varList.contains(var)) {
			return new Constant(0.0);
		}

		return new Multiply(new Multiply(new Exponential(this.base, this.variable), new Logarithm(new Euler(), this.base), this.coefficient), this.variable.derivative(var));
	}

	@Override
	public Expression integrate(Variable var) throws CannotIntegrateException {
		throw new CannotIntegrateException();
	}

	@Override
	public double calc() throws Exception {
		return Math.pow(this.base.calc(), this.variable.calc()) * this.coefficient;
	}

	@Override
	public String stringify() throws Exception {
		String coeff = "";
		if(this.coefficient != 1) {
			coeff = this.coeffToString();
		}

		return coeff + "exp(" + this.base.stringify() + "," +  "(" +  this.variable.stringify()  + ")" + ")";
	}

}
