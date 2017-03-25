package com.talan.kata;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NeighborUtility {

	public static long countAliveSurroundingCells(Set<Cell> aliveCells, Cell cell) {
		Set<Cell> surroundingCells = getSurroundingCells(cell); 	
		return surroundingCells.stream().filter(x -> aliveCells.contains(x)).count();
	}

	public static Set<Cell> getDeadSurroundingCells(Set<Cell> aliveCells, Cell cell) {
		Set<Cell> surroundingCells = getSurroundingCells(cell); 	
		return surroundingCells.stream().filter(x -> ! aliveCells.contains(x)).collect(Collectors.toSet());
	}
	
	private static Set<Cell> getSurroundingCells(Cell cell) {
		Set<Cell> neighbors = new HashSet<>();
		neighbors.add(new Cell(cell.getX() + 1 , cell.getY() - 1)); 
		neighbors.add(new Cell(cell.getX() + 1 , cell.getY()));
		neighbors.add(new Cell(cell.getX() + 1 , cell.getY() + 1));
		neighbors.add(new Cell(cell.getX() , cell.getY() - 1));
		neighbors.add(new Cell(cell.getX() , cell.getY() + 1));
		neighbors.add(new Cell(cell.getX() - 1 , cell.getY() - 1));
		neighbors.add(new Cell(cell.getX() - 1 , cell.getY()));
		neighbors.add(new Cell(cell.getX() - 1 , cell.getY() + 1));
		return neighbors;
	}

}
