package model;

public class Value implements Expression {
	protected double value;
	@Override
	public Expression derivative() {
		return null;
	}

	@Override
	public Expression integrate() {
		return null;
	}

	@Override
	public double calc() {
		return value;
	}

}