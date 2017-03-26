package com.talan.kata;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NeighborUtility {

	public static long countAliveSurroundingCells(Set<Cell> aliveCells, Cell cell, int edgeX, int edgeY) {
		Set<Cell> surroundingCells = cell.getSurroundingCells(edgeX, edgeY); 	
		return surroundingCells.stream().filter(elm -> aliveCells.contains(elm)).count();
	}

	public static Set<Cell> getDeadSurroundingCells(Set<Cell> aliveCells, Cell cell, int edgeX, int edgeY)  {
		Set<Cell> surroundingCells = cell.getSurroundingCells(edgeX, edgeY); 	
		return surroundingCells.stream().filter(elm -> ! aliveCells.contains(elm)).collect(Collectors.toSet());
	}
}
