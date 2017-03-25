package com.talan.kata;

import java.util.HashSet;
import java.util.Set;

public class GameImpl implements Game
{
	private Set<Cells> aliveCells = new HashSet<Cells>();
	
	public Set<Cells> getAliveCells() {
		return aliveCells;
	}


}
