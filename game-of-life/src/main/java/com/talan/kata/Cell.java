package com.talan.kata;

import java.util.Set;

/**
 * The Interface Cell.
 */
public interface Cell {
	
	/**
	 * Gets the surrounding cells.
	 *
	 * @param edgeX the edge X
	 * @param edgeY the edge Y
	 * @return the surrounding cells
	 */
	public Set<Cell> getSurroundingCells(int edgeX, int edgeY);

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX();

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY();
}
