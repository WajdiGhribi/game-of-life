package com.talan.kata;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NeighborUtility {

	public static long countAliveSurroundingCells(Set<Cell> aliveCells, Cell cell, int edgeX, int edgeY) {
		Set<Cell> surroundingCells = getSurroundingCells(cell, edgeX, edgeY); 	
		return surroundingCells.stream().filter(elm -> aliveCells.contains(elm)).count();
	}

	public static Set<Cell> getDeadSurroundingCells(Set<Cell> aliveCells, Cell cell, int edgeX, int edgeY)  {
		Set<Cell> surroundingCells = getSurroundingCells(cell, edgeX, edgeY); 	
		return surroundingCells.stream().filter(elm -> ! aliveCells.contains(elm)).collect(Collectors.toSet());
	}
	
	private static Set<Cell> getSurroundingCells(Cell cell, int edgeX, int edgeY) {
		Set<Cell> neighbors = new HashSet<>();
		int cellXAxis = cell.getX();
		int cellYAxis = cell.getY();
		
		if(cellXAxis < edgeX && cellYAxis > 0)
			neighbors.add(new Cell(cellXAxis + 1 , cellYAxis - 1));
		if(cellXAxis < edgeX)
			neighbors.add(new Cell(cellXAxis + 1 , cellYAxis));
		if(cellXAxis < edgeX && cellYAxis < edgeY)
			neighbors.add(new Cell(cellXAxis + 1 , cellYAxis + 1));
		if(cellYAxis > 0)
			neighbors.add(new Cell(cellXAxis , cellYAxis - 1));
		if(cellYAxis < edgeY)
			neighbors.add(new Cell(cellXAxis , cellYAxis + 1));
		if(cellXAxis > 0 && cellYAxis > 0)
			neighbors.add(new Cell(cellXAxis - 1 , cellYAxis - 1));
		if(cellXAxis > 0)
			neighbors.add(new Cell(cellXAxis - 1 , cellYAxis));
		if(cellXAxis > 0 && cellYAxis < edgeY)
			neighbors.add(new Cell(cellXAxis - 1 , cellYAxis + 1));
		
		return neighbors;
	}

}
