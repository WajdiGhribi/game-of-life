package com.talan.kata;

import java.util.Set;

public interface Cell {
	public Set<Cell> getSurroundingCells(int edgeX, int edgeY);
	public int getX();
	public int getY();
}
