package com.java.se7.concurrency.recipes.thread.scenarios.parkinglot;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingLot {
  private boolean freeParkingLots[][];
  private Lock lockParkingLots;
  private Semaphore semaphore;

  public ParkingLot(int rows, int columns) {
    freeParkingLots = new boolean[rows][columns];
    lockParkingLots = new ReentrantLock();
    semaphore = new Semaphore(rows*columns);

    for (int i=0; i<rows; i++) {
      for (int j=0;j<columns; j++) {
        freeParkingLots[i][j] = true;
      }
    }
  }

  public void parkVehicle() {
    try {
      semaphore.acquire();
      int[] lotNumber = getFreeParkingLot();
      int vacantRow = lotNumber[0];
      int vacantColumn = lotNumber[1];
      long duration = (long)(Math.random()*10);
      System.out.printf("Parking vehicle in row %d and column %d in duration %d", vacantRow, vacantColumn, duration);
      TimeUnit.SECONDS.sleep(duration);
      freeParkingLots[vacantRow][vacantColumn] = true;
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }

  public int[] getFreeParkingLot() {
    int ret[] = {-1, -1};
    try {
      lockParkingLots.lock();
      for (int i=0; i<freeParkingLots[0].length; i++) {
        for (int j=0;j<freeParkingLots[1].length; j++) {
          if (freeParkingLots[i][j]) {
            ret[0] = i;
            ret[1] = j;
            freeParkingLots[i][j] = false;
            break;
          }
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      lockParkingLots.unlock();
    }
    return ret;
  }
}
