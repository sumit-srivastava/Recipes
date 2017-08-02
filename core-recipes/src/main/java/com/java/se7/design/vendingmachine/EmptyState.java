package com.java.se7.design.vendingmachine;

public class EmptyState implements State {
	VendingMachine machine;

	public EmptyState(VendingMachine machine) {
		this.machine = machine;
	}

	public void insertCoin() throws Exception {
		throw new Exception("Can not process the request");
	}

	public void pressButton() throws Exception {
		throw new Exception("Invalid Action");
	}

	public void dispense() throws Exception {
		throw new Exception("Invalid Action");
	}
}
