package com.talan.kata;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;



public class GameTest 
{
	private Game game;
	
	@Before
	public void setUp() {
		game = new GameImpl();
	}
	
	@Test
	public void gameShouldHasNoAliveCellsWhenItStarts() {
		assertThat(game.getAliveCells().size()).isEqualTo(0);
	}
}
