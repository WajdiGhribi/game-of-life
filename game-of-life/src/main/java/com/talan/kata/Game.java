package com.talan.kata;

import java.util.Set;

/**
 * The Interface Game.
 */
public interface Game {

	/**
	 * Gets the alive cells.
	 *
	 * @return the alive cells
	 */
	public Set<Cell> getAliveCells();

	/**
	 * Sets the alive cells.
	 *
	 * @param aliveCells the new alive cells
	 */
	public void setAliveCells(Set<Cell> aliveCells);

	/**
	 * Execute generation.
	 */
	public void executeGeneration();

}
