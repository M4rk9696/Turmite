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
	
	public void inc(int sz) {
		switch(this.direction) {
		case NORTH:
			y -= sz;
			break;
		case SOUTH:
			y += sz;
			break;
		case WEST:
			x -= sz;
			break;
		case EAST:
			x += sz;
		}
	}
	
	public void turn(String side) {
		if(side == "LEFT")
			direction = direction.rotate(-1);
		if(side == "RIGHT")
			direction = direction.rotate(1);
//		System.out.println(direction);
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
		public int mod(int a, int b) {
			if(a < 0)
				a += b;
			return a%b;
		}
		public Direction rotate(int x) {
			return values()[mod(dir + x, 4)];
		}
	}

}
