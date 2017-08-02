package com.java.se7.design.vendingmachine;

public class NoCoinInsertedState implements State {
	VendingMachine machine;

	public NoCoinInsertedState(VendingMachine machine) {
		this.machine = machine;
	}

	public void insertCoin() throws Exception {
		if (!machine.isEmpty()) {
			machine.setMachineState(machine.getConinInsertedState());
		} else {
			throw new Exception("Can not process request .. Machine is out of stock");
		}
	}

	public void pressButton() throws Exception {
		throw new Exception("No coin inserted ..");
	}

	public void dispense() throws Exception {
		throw new Exception("Invalid Operation");
	}
}
