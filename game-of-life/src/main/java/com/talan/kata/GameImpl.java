package com.talan.kata;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameImpl implements Game
{
	private Set<Cell> aliveCells = new HashSet<>();
	private int edgeX;
	private int edgeY;
	
	public GameImpl(int edgeXAxis, int edgeYAxis) {
		edgeX = edgeXAxis;
		edgeY = edgeYAxis;
	}

	@Override
	public void setAliveCells(Set<Cell> inputAliveCells) {
		this.aliveCells = inputAliveCells
							.stream()
								.filter(cell -> (cell.getX() >= 0 && cell.getX() <= edgeX))
									.filter(cell -> (cell.getY() >= 0 && cell.getY() <= edgeY))
										.collect(Collectors.toSet());
	}

	@Override
	public Set<Cell> getAliveCells() {
		return aliveCells;
	}

	@Override
	public void executeGeneration() {
		Set<Cell> nextGeneration = new HashSet<>();
		for (Cell cell : aliveCells) {
			long aliveSurroundingCellsCount = NeighborUtility.countAliveSurroundingCells(aliveCells, cell, edgeX, edgeY);
			if (aliveSurroundingCellsCount == 2 || aliveSurroundingCellsCount == 3) {
				nextGeneration.add(cell);
			}
			resurrectDeadCells(cell, nextGeneration);
		}
		aliveCells = nextGeneration;
		
	}

	private void resurrectDeadCells(Cell cell, Set<Cell> nextGeneration) {
		Set<Cell> deadSurroundingCells = NeighborUtility.getDeadSurroundingCells(aliveCells, cell, edgeX, edgeY);
		for (Cell deadCell : deadSurroundingCells) {
			long liveNeighborCount = NeighborUtility.countAliveSurroundingCells(aliveCells , deadCell, edgeX, edgeY);
			if (liveNeighborCount == 3) {
				nextGeneration.add(deadCell);
			}
		}
	}

}
