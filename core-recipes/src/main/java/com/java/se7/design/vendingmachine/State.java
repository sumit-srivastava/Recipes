package com.java.se7.design.vendingmachine;

public interface State {
	public void insertCoin() throws Exception;

	public void pressButton() throws Exception;

	public void dispense() throws Exception;
}
