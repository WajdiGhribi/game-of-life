package com.talan.kata;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;



public class GameTest 
{
	private Game game;
	private Set<Cells> aliveCells;
	
	@Before
	public void setUp() {
		game = new GameImpl();
		aliveCells = new HashSet<Cells>();
	}
	
	@Test
	public void gameShouldHasNoAliveCellsWhenItStarts() {
		assertThat(game.getAliveCells().size()).isEqualTo(0);
	}
	
	@Test
	public void gameShouldHasOnlyOneAliveCellsWhenAliveCellIsAdded() {
		Cells cell = new Cells(1, 2);
		aliveCells.add(cell);
		game.setAliveCells(aliveCells);
		assertThat(game.getAliveCells()).containsExactly(cell);
	}
}
