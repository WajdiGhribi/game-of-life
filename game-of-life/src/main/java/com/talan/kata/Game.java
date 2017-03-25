package com.talan.kata;

import java.util.Set;

public interface Game {
	
	public Set<Cells> getAliveCells();

	public void setAliveCells(Set<Cells> aliveCells);
	
}
