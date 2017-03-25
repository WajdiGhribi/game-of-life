package com.talan.kata;

import java.util.HashSet;
import java.util.Set;

public class GameImpl implements Game
{
	private Set<Cell> aliveCells = new HashSet<>();
	
	@Override
	public void setAliveCells(Set<Cell> aliveCells) {
		this.aliveCells = aliveCells;
	}

	@Override
	public Set<Cell> getAliveCells() {
		return aliveCells;
	}

	@Override
	public void executeGeneration() {
		Set<Cell> nextGeneration = new HashSet<>();
		for (Cell cell : aliveCells) {
			long aliveSurroundingCellsCount = NeighborUtility.countAliveSurroundingCells(aliveCells , cell);
			if (aliveSurroundingCellsCount == 2 || aliveSurroundingCellsCount == 3) {
				nextGeneration.add(cell);
			}
			resurrectDeadCells(cell, nextGeneration);
		}
		aliveCells = nextGeneration;
		
	}

	private void resurrectDeadCells(Cell cell, Set<Cell> nextGeneration) {
		Set<Cell> deadSurroundingCells = NeighborUtility.getDeadSurroundingCells(aliveCells, cell);
		for (Cell deadCell : deadSurroundingCells) {
			long liveNeighborCount = NeighborUtility.countAliveSurroundingCells(aliveCells , deadCell);
			if (liveNeighborCount == 3) {
				nextGeneration.add(deadCell);
			}
		}
	}

}
