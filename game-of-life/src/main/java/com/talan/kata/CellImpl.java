package com.talan.kata;

import java.util.HashSet;
import java.util.Set;

public class CellImpl implements Cell {

	private int x;
	private int y;
	
	public CellImpl(int xAxis, int yAxis) {
		x = xAxis;
		y = yAxis;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public Set<Cell> getSurroundingCells(int edgeX, int edgeY) {
		Set<Cell> neighbors = new HashSet<>();

		
		if(x < edgeX && y > 0)
			neighbors.add(new CellImpl(x + 1 , y - 1));
		if(x < edgeX)
			neighbors.add(new CellImpl(x + 1 , y));
		if(x < edgeX && y < edgeY)
			neighbors.add(new CellImpl(x + 1 , y + 1));
		if(y > 0)
			neighbors.add(new CellImpl(x , y - 1));
		if(y < edgeY)
			neighbors.add(new CellImpl(x , y + 1));
		if(x > 0 && y > 0)
			neighbors.add(new CellImpl(x - 1 , y - 1));
		if(x > 0)
			neighbors.add(new CellImpl(x - 1 , y));
		if(x > 0 && y < edgeY)
			neighbors.add(new CellImpl(x - 1 , y + 1));
		
		return neighbors;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellImpl other = (CellImpl) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

}
