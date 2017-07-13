package com.mark.core;

import java.awt.Color;

import com.mark.util.Point;
import com.mark.util.State.InputState;
import com.mark.util.State.OutputState;

public class Turmite {
	// State, Color, Next State, Next Color, Rotation
	private Rule rule;
	private Point pos;
	private int[] box;
	private int height;
	private int width;
	private InputState startState;
	
	public Turmite(Point st, Rule rule, int height, int width, InputState startState) {
		this.rule = rule;
		this.height = height;
		this.width = width;
		this.pos = st;
		this.box = new int[height * width];
		this.startState = startState;
	}
	
	public void performIteration(int number_of_iterations) {
		
		InputState state = startState;
		for(int i = 1; i <= number_of_iterations; ++i) {
			pos.inc();
			
			// Calculate next state
			OutputState output = rule.getResult(state);
			if(output.color == 1) {
				box[pos.x * width + pos.y] = 1; 
			}
			else box[pos.x * width + pos.y] = 0;
			
			if(output.turn == 1)
				pos.turn("RIGHT");
			if(output.turn == -1)
				pos.turn("LEFT");
			state = output.convertToInput();
		}
	}
	
	public int[] returnResult() {
		return box;
	}
	
}
