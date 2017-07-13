package com.mark.util;

public class State {
	
	static public class InputState {
		public int state, color;
		public InputState(int state, int color) {
			this.state = state;
			this.color = color;
		}
		
		@Override
		public boolean equals(Object e) {
			InputState x = (InputState) e;
			return state == x.state && color == x.color;
		}
		
		@Override
		public int hashCode() {
			int hash = state;
			hash = hash * 37 + color;
			return hash;
		}
	}
	
	static public class OutputState {
		public int state, color, turn;
		public OutputState(int state, int color, int turn) {
			this.state = state;
			this.color = color;
			this.turn = turn;
		}
		
		public InputState convertToInput() {
			return new InputState(state, color);
		}
		
		@Override
		public boolean equals(Object e) {
			OutputState x = (OutputState) e;
			return state == x.state && color == x.color && turn == x.turn;
		}
		
		@Override
		public int hashCode() {
			int hash = state;
			hash = hash * 37 + color;
			hash = hash * 37 + turn;
			return hash;
		}
	}

}
