package com.talan.kata;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class CellImpl.
 */
public class CellImpl implements Cell {

	/** The x coordinate. */
	private int x;
	
	/** The y coordinate. */
	private int y;

	/**
	 * Instantiates a new cell impl.
	 *
	 * @param xAxis the x axis
	 * @param yAxis the y axis
	 */
	public CellImpl(int xAxis, int yAxis) {
		x = xAxis;
		y = yAxis;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	/**
	 * Get the neighbors cells.
	 *
	 * @param edgeX the edge in x axis
	 * @param edgeY the edge in y axis
	 * @return neighbors
	 */
	@Override
	public Set<Cell> getSurroundingCells(int edgeX, int edgeY) {
		Set<Cell> neighbors = new HashSet<>();
		
		addRightNeighbors(neighbors, edgeX, edgeY);
		addLeftNeighbors(neighbors, edgeY);
		addTopAndBottomNeighbors(neighbors, edgeY);
		
		return neighbors;
	}

	/**
	 * Adds the top and bottom neighbors.
	 *
	 * @param neighbors the neighbors
	 * @param edgeY the edge Y
	 */
	private void addTopAndBottomNeighbors(Set<Cell> neighbors, int edgeY) {
		if (y > 0){
			neighbors.add(new CellImpl(x, y - 1));
		}
		if (y < edgeY){
			neighbors.add(new CellImpl(x, y + 1));
		}	
	}

	/**
	 * Adds the left neighbors.
	 *
	 * @param neighbors the neighbors
	 * @param edgeY the edge Y
	 */
	private void addLeftNeighbors(Set<Cell> neighbors, int edgeY) {
		
		if (x > 0 && y > 0){
			neighbors.add(new CellImpl(x - 1, y - 1));
		}
		if (x > 0){
			neighbors.add(new CellImpl(x - 1, y));
		}
		if (x > 0 && y < edgeY){
			neighbors.add(new CellImpl(x - 1, y + 1));
		}
		
	}

	/**
	 * Adds the right neighbors.
	 *
	 * @param neighbors the neighbors
	 * @param edgeX the edge X
	 * @param edgeY the edge Y
	 */
	private void addRightNeighbors(Set<Cell> neighbors, int edgeX, int edgeY) {
		if (x < edgeX && y > 0){
			neighbors.add(new CellImpl(x + 1, y - 1));
		}
		if (x < edgeX){
			neighbors.add(new CellImpl(x + 1, y));
		}
		if (x < edgeX && y < edgeY){
			neighbors.add(new CellImpl(x + 1, y + 1));	
		}
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
