package com.talan.kata;

import java.util.Set;

public interface Game {
	
	public Set<Cell> getAliveCells();

	public void setAliveCells(Set<Cell> aliveCells);

	public void executeGeneration();
	
}
