package com.talan.kata;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class GameImpl.
 */
public class GameImpl implements Game {
	
	/** The alive cells. */
	private Set<Cell> aliveCells = new HashSet<>();
	
	/** The rules. */
	private Rules rules;
	
	/** The edge X. */
	private int edgeX;
	
	/** The edge Y. */
	private int edgeY;
	
	/** The alive caracther. */
	private char ALIVE_CELL = '*';
	
	/** The dead caracther. */
	private char DEAD_CELL = '.';

	/**
	 * Instantiates a new game impl.
	 *
	 * @param edgeXAxis the edge X axis
	 * @param edgeYAxis the edge Y axis
	 * @param survivingRules the surviving rules
	 */
	public GameImpl(int edgeXAxis, int edgeYAxis, Rules survivingRules) {
		edgeX = edgeXAxis;
		edgeY = edgeYAxis;
		rules = survivingRules;
	}

	@Override
	public void setAliveCells(Set<Cell> inputAliveCells) {
		this.aliveCells = inputAliveCells.stream().filter(cell -> cell.getX() >= 0 && cell.getX() <= edgeX)
				.filter(cell -> cell.getY() >= 0 && cell.getY() <= edgeY).collect(Collectors.toSet());
	}

	@Override
	public Set<Cell> getAliveCells() {
		return aliveCells;
	}

	/** 
	 * Execute generation
	 *
	 */
	@Override
	public void executeGeneration() {
		Set<Cell> nextGeneration = new HashSet<>();
		for (Cell cell : aliveCells) {
			if (rules.shouldSurvive(aliveCells, cell, edgeX, edgeY)) {
				nextGeneration.add(cell);
			}
			resurrectDeadCells(cell, nextGeneration);
		}
		aliveCells = nextGeneration;

	}

	/**
	 * Resurrect dead cells.
	 *
	 * @param cell the cell
	 * @param nextGeneration the next generation
	 */
	private void resurrectDeadCells(Cell cell, Set<Cell> nextGeneration) {
		Set<Cell> deadSurroundingCells = NeighborUtility.getDeadSurroundingCells(aliveCells, cell, edgeX, edgeY);
		for (Cell deadCell : deadSurroundingCells) {
			if (rules.shouldReborn(aliveCells, deadCell, edgeX, edgeY)) {
				nextGeneration.add(deadCell);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(edgeX + 1);
		buffer.append(" ");
		buffer.append(edgeY + 1);
		buffer.append("\n");
		for (int x = 0; x <= edgeX; x++) {
			for (int y = 0; y <= edgeY; y++) {
				
				// To avoid aliveCells.contains(new Cell(x, y)): creating an object in each caracther
				if (containsAliveCells(aliveCells, x, y)) {
					buffer.append(ALIVE_CELL);
				} else {
					buffer.append(DEAD_CELL);
				}
			}
			buffer.append("\n");
		} 
		return buffer.toString();
	}

	/**
	 * Contains alive cells.
	 *
	 * @param aliveCells the alive cells
	 * @param x the x
	 * @param y the y
	 * @return true, if x, y stand for an alive cell 
	 */
	private boolean containsAliveCells(Set<Cell> aliveCells, int x, int y) {
		return aliveCells.stream().filter(elem -> elem.getX() == x && elem.getY() == y).count() > 0;
	}
}
