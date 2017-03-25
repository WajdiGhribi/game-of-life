package com.talan.kata;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;



public class GameTest 
{
	private Game game;
	private Set<Cell> aliveCells;
	
	@Before
	public void setUp() {
		game = new GameImpl();
		aliveCells = new HashSet<Cell>();
	}
	
	@Test
	public void gameShouldHasNoAliveCellsWhenItStarts() {
		assertThat(game.getAliveCells().size()).isEqualTo(0);
	}
	
	@Test
	public void gameShouldHasOnlyOneAliveCellsWhenAliveCellIsAdded() {
		Cell cell = new Cell(1, 2);
		aliveCells.add(cell);
		game.setAliveCells(aliveCells);
		assertThat(game.getAliveCells()).containsExactly(cell);
	}
	
	@Test
	public void singleCellShouldDieWhenGenerationOccurs() {
		Cell cell = new Cell(2, 3);
		aliveCells.add(cell);
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells().size()).isEqualTo(0);
	}
	
	@Test
	public void cellSurroundedByTwoNeighborsShouldSurviveWhenGenerationOccurs() {
		Cell currentCell = new Cell(2, 3);
		Cell firstNeighbor = new Cell(2, 4);
		Cell secondNeighbor = new Cell(2, 2);
		aliveCells.add(currentCell);
		aliveCells.add(firstNeighbor);
		aliveCells.add(secondNeighbor);
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells()).containsExactly(currentCell);
	}
	
	@Test
	public void cellSurroundedByThreeNeighborsShouldSurviveWhenGenerationOccurs() {
		Cell currentCell = new Cell(2, 3);
		Cell firstNeighbor = new Cell(2, 4);
		Cell secondNeighbor = new Cell(2, 2);
		Cell thirdNeighbor = new Cell(1, 4);
		aliveCells.add(currentCell);
		aliveCells.add(firstNeighbor);
		aliveCells.add(secondNeighbor);
		aliveCells.add(thirdNeighbor);
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells()).containsOnly(currentCell, firstNeighbor, thirdNeighbor);
	}

	@Test
	public void cellSurroundedByFourNeighborsShouldDieWhenGenerationOccurs() {
		Cell currentCell = new Cell(2, 3);
		Cell firstNeighbor = new Cell(2, 4);
		Cell secondNeighbor = new Cell(2, 2);
		Cell thirdNeighbor = new Cell(1, 4);
		Cell fourthNeighbor = new Cell(3, 2);
		aliveCells.add(currentCell);
		aliveCells.add(firstNeighbor);
		aliveCells.add(secondNeighbor);
		aliveCells.add(thirdNeighbor);
		aliveCells.add(fourthNeighbor);
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells()).doesNotContain(currentCell);
	}
	
}
