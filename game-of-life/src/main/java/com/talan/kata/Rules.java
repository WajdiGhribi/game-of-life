package com.talan.kata;

import java.util.Set;

public interface Rules {
	
	  public boolean shouldSurvive(Set<Cell> aliveCells, Cell cell, int edgeX, int edgeY);

	  public boolean shouldReborn(Set<Cell> aliveCells, Cell deadCell, int edgeX, int edgeY);
}
