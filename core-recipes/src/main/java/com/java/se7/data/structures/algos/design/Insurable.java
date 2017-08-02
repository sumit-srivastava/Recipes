package com.java.se7.data.structures.algos.design;

public interface Insurable extends Sellable, Transportable {
  /** Returns insured value in cents */
  public int insuredValue();
}
