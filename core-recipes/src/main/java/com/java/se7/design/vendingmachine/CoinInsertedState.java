package com.java.se7.design.vendingmachine;

public class CoinInsertedState implements State {
	VendingMachine machine = null;

	public CoinInsertedState(VendingMachine machine) {
		this.machine = machine;
	}

	public void insertCoin() throws Exception {
		throw new Exception("Coin is already inserted.");
	}

	public void dispense() throws Exception {
		throw new Exception("Dispense button is not pressed.");

	}

	public void pressButton() throws Exception {
		machine.setMachineState(machine.getDispensingState());
	}
}