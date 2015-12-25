package com.java.se7.enums.recipes.type4;

public enum Currency {
      PENNY(1) {
              @Override
              public String color() {
                      return "copper";
              }
      },
      NICKLE(5) {
              @Override
              public String color() {
                      return "bronze";
              }
      },
      DIME(10) {
              @Override
              public String color() {
                      return "silver";
              }
      },
      QUARTER(25) {
              @Override
              public String color() {
                      return "silver";
              }
      };
      private int value;

      public abstract String color();

      private Currency(int value) {
        this.value = value;
      }

      public int getValue() {
        return this.value;
      }
  }

