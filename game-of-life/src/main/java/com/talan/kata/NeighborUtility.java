package com.talan.kata;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class NeighborUtility.
 */
public class NeighborUtility {


	private NeighborUtility(){
		
	}
	
	/**
	 * Count alive surrounding cells.
	 *
	 * @param aliveCells the alive cells
	 * @param cell the cell
	 * @param edgeX the edge X
	 * @param edgeY the edge Y
	 * @return the number of alive surrounding cells
	 */
	public static long countAliveSurroundingCells(Set<Cell> aliveCells, Cell cell, int edgeX, int edgeY) {
		Set<Cell> surroundingCells = cell.getSurroundingCells(edgeX, edgeY);
		return surroundingCells.stream().filter(elm -> aliveCells.contains(elm)).count();
	}

	/**
	 * Gets the dead surrounding cells.
	 *
	 * @param aliveCells the alive cells
	 * @param cell the cell
	 * @param edgeX the edge X
	 * @param edgeY the edge Y
	 * @return the dead surrounding cells
	 */
	public static Set<Cell> getDeadSurroundingCells(Set<Cell> aliveCells, Cell cell, int edgeX, int edgeY) {
		Set<Cell> surroundingCells = cell.getSurroundingCells(edgeX, edgeY);
		return surroundingCells.stream().filter(elm -> !aliveCells.contains(elm)).collect(Collectors.toSet());
	}
}
