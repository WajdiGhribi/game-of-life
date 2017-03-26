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
		Rules rules = new RulesImpl();
		game = new GameImpl(4,5, rules);
		aliveCells = new HashSet<Cell>();
	}
	
	@Test
	public void gameShouldHasNoAliveCellsWhenItStarts() {
		assertThat(game.getAliveCells().size()).isEqualTo(0);
	}
	
	@Test
	public void gameShouldHasOnlyOneAliveCellsWhenAliveCellIsAdded() {
		Cell cell = new CellImpl(1, 2);
		aliveCells.add(cell);
		game.setAliveCells(aliveCells);
		assertThat(game.getAliveCells()).containsExactly(cell);
	}
	
	@Test
	public void singleCellShouldDieWhenGenerationOccurs() {
		Cell cell = new CellImpl(2, 3);
		aliveCells.add(cell);
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells().size()).isEqualTo(0);
	}
	
	@Test
	public void cellSurroundedByTwoNeighborsShouldSurviveWhenGenerationOccurs() {
		Cell currentCell = new CellImpl(2, 3);
		Cell firstNeighbor = new CellImpl(2, 4);
		Cell secondNeighbor = new CellImpl(2, 2);
		aliveCells.add(currentCell);
		aliveCells.add(firstNeighbor);
		aliveCells.add(secondNeighbor);
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells()).contains(currentCell);
	}
	
	@Test
	public void cellSurroundedByThreeNeighborsShouldSurviveWhenGenerationOccurs() {
		Cell currentCell = new CellImpl(2, 3);
		Cell firstNeighbor = new CellImpl(2, 4);
		Cell secondNeighbor = new CellImpl(2, 2);
		Cell thirdNeighbor = new CellImpl(1, 4);
		aliveCells.add(currentCell);
		aliveCells.add(firstNeighbor);
		aliveCells.add(secondNeighbor);
		aliveCells.add(thirdNeighbor);
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells()).contains(currentCell);
	}

	@Test
	public void cellSurroundedByFourNeighborsShouldDieWhenGenerationOccurs() {
		Cell currentCell = new CellImpl(2, 3);
		Cell firstNeighbor = new CellImpl(2, 4);
		Cell secondNeighbor = new CellImpl(2, 2);
		Cell thirdNeighbor = new CellImpl(1, 4);
		Cell fourthNeighbor = new CellImpl(3, 2);
		aliveCells.add(currentCell);
		aliveCells.add(firstNeighbor);
		aliveCells.add(secondNeighbor);
		aliveCells.add(thirdNeighbor);
		aliveCells.add(fourthNeighbor);
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells()).doesNotContain(currentCell);
	}
	
	@Test
	public void deadCellShouldComesBackToLifeWhenGenerationOccursAndItIsSurroundedByThreeAliveNeigbors() {
		Cell currentCell = new CellImpl(2, 3);
		Cell firstNeighbor = new CellImpl(2, 4);
		Cell secondNeighbor = new CellImpl(2, 2);
		Cell thirdNeighbor = new CellImpl(1, 4);
		aliveCells.add(firstNeighbor);
		aliveCells.add(secondNeighbor);
		aliveCells.add(thirdNeighbor);		
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells()).contains(currentCell);
	}
	
	@Test 
	public void cellInBottomOfXAxisEdgeShouldHaveThreeNeighborWhenGameInitiallyStarted(){
		Cell currentCell = new CellImpl(6, 0);
		aliveCells.add(currentCell);		
		game.setAliveCells(aliveCells);
		Set<Cell> deadCells = NeighborUtility.getDeadSurroundingCells(aliveCells, currentCell, 4, 5);
		assertThat(deadCells.size()).isEqualTo(3);
	}
	
	@Test 
	public void cellInTopOfXAxisEdgeShouldHaveThreeNeighborWhenGameInitiallyStarted(){
		Cell currentCell = new CellImpl(6, 6);
		aliveCells.add(currentCell);		
		game.setAliveCells(aliveCells);
		Set<Cell> deadCells = NeighborUtility.getDeadSurroundingCells(aliveCells, currentCell, 4, 5);
		assertThat(deadCells.size()).isEqualTo(3);
	}
	
	
	@Test 
	public void cellInBottomOfYAxisEdgeShouldHaveThreeNeighborWhenGameInitiallyStarted(){
		Cell currentCell = new CellImpl(0, 0);
		aliveCells.add(currentCell);		
		game.setAliveCells(aliveCells);
		Set<Cell> deadCells = NeighborUtility.getDeadSurroundingCells(aliveCells, currentCell, 4, 5);
		assertThat(deadCells.size()).isEqualTo(3);
	}
	
	@Test 
	public void cellInTopOfYAxisEdgeShouldHaveThreeNeighborWhenGameInitiallyStarted(){
		Cell currentCell = new CellImpl(0, 6);
		aliveCells.add(currentCell);		
		game.setAliveCells(aliveCells);
		Set<Cell> deadCells = NeighborUtility.getDeadSurroundingCells(aliveCells, currentCell, 4, 5);
		assertThat(deadCells.size()).isEqualTo(3);
	}
		
	@Test 
	public void cellsOutOfEdgeShouldNotBeAddedToGrid(){

		aliveCells.add(new CellImpl(5, 5));
		aliveCells.add(new CellImpl(-1, 5));	
		aliveCells.add(new CellImpl(4, -1));
		aliveCells.add(new CellImpl(4, 6));
		game.setAliveCells(aliveCells);
		assertThat(game.getAliveCells().size()).isEqualTo(0);
	}
	
	@Test 
	public void CellInCoordinate00ShouldBeAliveWhenGenerationOccursAndItIsSurroundedByThreeAliveCells(){
		aliveCells.add(new CellImpl(1, 1));
		aliveCells.add(new CellImpl(1, 0));	
		aliveCells.add(new CellImpl(0, 1));
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells().size()).isEqualTo(4);
	}
	
	
	@Test 
	public void CellInCoordinate66ShouldBeAliveWhenGenerationOccursAndItIsSurroundedByThreeAliveCells(){
		aliveCells.add(new CellImpl(3, 5));
		aliveCells.add(new CellImpl(3, 4));	
		aliveCells.add(new CellImpl(4, 4));
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.getAliveCells().size()).isEqualTo(4);
	}
	
	@Test
	public void outPutResultShouldBeReflectGenerationStrategy(){
		aliveCells.add(new CellImpl(3, 5));
		aliveCells.add(new CellImpl(3, 4));	
		aliveCells.add(new CellImpl(4, 4));
		String output = "4 5\n"+
				"......\n"+
				"......\n"+
				"......\n"+
				"....**\n"+
				"....**\n";
		game.setAliveCells(aliveCells);
		game.executeGeneration();
		assertThat(game.toString().equals(output)).isTrue();
	}
}
