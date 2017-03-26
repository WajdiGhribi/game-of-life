package com.talan.kata;

import java.util.Set;

/**
 * The Class RulesImpl.
 */
public class RulesImpl implements Rules {
	
	  @Override
	  public boolean shouldSurvive(Set<Cell> aliveCells, Cell cell, int edgeX, int edgeY){
			long aliveSurroundingCellsCount = NeighborUtility.countAliveSurroundingCells(aliveCells, cell, edgeX, edgeY);
			return aliveSurroundingCellsCount == 2 || aliveSurroundingCellsCount == 3;
	  }

	  @Override
	  public boolean shouldReborn(Set<Cell> aliveCells, Cell deadCell, int edgeX, int edgeY){
			long liveNeighborCount = NeighborUtility.countAliveSurroundingCells(aliveCells , deadCell, edgeX, edgeY);
			return liveNeighborCount == 3;
	  }
	  
}
