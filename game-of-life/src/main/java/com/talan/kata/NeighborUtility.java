package com.talan.kata;

import java.util.HashSet;
import java.util.Set;

public class NeighborUtility {

	public static long countAliveSurroundingCells(Set<Cell> aliveCells, Cell cell) {
		Set<Cell> surroundingCells = getSurroundingCells(cell); 	
		return surroundingCells.stream().filter(aliveCells::contains).count();
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
