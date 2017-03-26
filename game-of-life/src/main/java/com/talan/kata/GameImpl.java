package com.talan.kata;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameImpl implements Game
{
	private Set<Cell> aliveCells = new HashSet<>();
	private Rules rules;
	private int edgeX;
	private int edgeY;
	private char ALIVE = '*';
	private char DEAD = '.';
	
	public GameImpl(int edgeXAxis, int edgeYAxis, Rules survivingRules) {
		edgeX = edgeXAxis;
		edgeY = edgeYAxis;
		rules = survivingRules;
	}

	@Override
	public void setAliveCells(Set<Cell> inputAliveCells) {
		this.aliveCells = inputAliveCells
							.stream()
								.filter(cell -> (cell.getX() >= 0 && cell.getX() <= edgeX))
									.filter(cell -> (cell.getY() >= 0 && cell.getY() <= edgeY))
										.collect(Collectors.toSet());
	}

	@Override
	public Set<Cell> getAliveCells() {
		return aliveCells;
	}

	@Override
	public void executeGeneration() {
		Set<Cell> nextGeneration = new HashSet<>();
		for (Cell cell : aliveCells) {
			if (rules.shouldSurvive(aliveCells, cell, edgeX, edgeY)) {
				nextGeneration.add(cell);
			}
			resurrectDeadCells(cell, nextGeneration);
		}
		aliveCells = nextGeneration;
		
	}

	private void resurrectDeadCells(Cell cell, Set<Cell> nextGeneration) {
		Set<Cell> deadSurroundingCells = NeighborUtility.getDeadSurroundingCells(aliveCells, cell, edgeX, edgeY);
		for (Cell deadCell : deadSurroundingCells) {
			if (rules.shouldReborn(aliveCells , deadCell, edgeX, edgeY)) {
				nextGeneration.add(deadCell);
			}
		}
	}
	
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(edgeX);
        buffer.append(" ");
        buffer.append(edgeY);
        buffer.append("\n");
        for (int x = 0; x <= edgeX; x++) {
            for (int y = 0; y <= edgeY; y++) {
                if (containsAliveCells(aliveCells, x ,y)) {
                    buffer.append(ALIVE);
                } else {
                    buffer.append(DEAD);
                }
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    // To avoid aliveCells.contains(new Cell(x, y)): creating an object in each caracther 
	private boolean containsAliveCells(Set<Cell> aliveCells, int x, int y) {
		return aliveCells.stream()
				.filter(elem -> elem.getX() == x && elem.getY() == y)
					.count() > 0;
	}
}
