package com.talan.kata;

import java.util.Set;

/**
 * The Interface Rules.
 */
public interface Rules {
	
	  /**
  	 * Should survive.
  	 *
  	 * @param aliveCells the alive cells
  	 * @param cell the cell
  	 * @param edgeX the edge X
  	 * @param edgeY the edge Y
  	 * @return true, if cell should survive
  	 */
  	public boolean shouldSurvive(Set<Cell> aliveCells, Cell cell, int edgeX, int edgeY);

	  /**
  	 * Should reborn.
  	 *
  	 * @param aliveCells the alive cells
  	 * @param deadCell the dead cell
  	 * @param edgeX the edge X
  	 * @param edgeY the edge Y
  	 * @return true, if the cell sould be reborn
  	 */
  	public boolean shouldReborn(Set<Cell> aliveCells, Cell deadCell, int edgeX, int edgeY);
}
