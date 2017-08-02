package com.java.se7.design.vendingmachine;

public class DispensingState implements State {
	VendingMachine machine;

	DispensingState(VendingMachine machine) {
		this.machine = machine;
	}

	public void insertCoin() throws Exception {
		throw new Exception("wait ... previous order is processing");
	}

	public void pressButton() throws Exception {
		throw new Exception("wait ... previous order is processing");
	}

	public void dispense() throws Exception {
		machine.setMachineState(machine.getNoCoinInsertedState());
	}
}
