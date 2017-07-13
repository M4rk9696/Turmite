package com.mark.util;

public class Point {
	public int x, y;
	// 1 - North, 2 - East, 3 - South, 4 - West
	private Direction direction;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.direction = Direction.NORTH;
	}
	
	public void inc() {
		switch(direction) {
		case NORTH:
			y -= 1;
			break;
		case SOUTH:
			y += 1;
			break;
		case WEST:
			x -= 1;
		case EAST:
			x += 1;
		}
	}
	
	public void turn(String side) {
		if(side == "LEFT")
			direction.rotate(-1);
		if(side == "RIGHT")
			direction.rotate(1);
	}
	
	public enum Direction {
		NORTH(0),
		EAST(1),
		SOUTH(2),
		WEST(3);
		
		private int dir;
		private Direction(int dir) {
			this.dir = dir;
		}
		public int getint() {
			return dir;
		}
		public void rotate(int x) {
			dir += x;
			if(dir > 3)
				dir -= 4;
			if(dir < 0)
				dir += 4;
		}
	}

}
