package com.mark.core;

import java.awt.Color;

import com.mark.display.GUI;
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
	private int size;
	private GUI g;
	private InputState startState;
	
	public Turmite(Point st, Rule rule, int height, int width, int size, InputState startState) {
		this.rule = rule;
		this.height = height;
		this.width = width;
		this.pos = st;
		this.size = size;
		this.box = new int[height * width];
		this.startState = startState;
		clearBox(width, height);
	}
	
	public void setGUI(GUI g) {
		this.g = g;
	}
	
	public void performIteration(int number_of_iterations) throws InterruptedException {
		
		InputState state = startState;
		for(int i = 1; i <= number_of_iterations; ++i) {
			Thread.sleep(10);
			
			// Calculate next state
			OutputState output = rule.getResult(state);
			
			if(output.turn == 1)
				pos.turn("RIGHT");
			if(output.turn == -1)
				pos.turn("LEFT");
			
			if(output.color == 1) {
				box[pos.x*width + pos.y] = 1;
				g.setBlock(pos.x, pos.y, 1, size); 
			}
			else{
				box[pos.x*width + pos.y] = 0;
				g.setBlock(pos.x, pos.y, 0, size);
			}
			pos.inc(size);
			
			state = output.convertToInput();
			state.color = box[width*pos.x+ pos.y];
		}
	}
	
	private void clearBox(int width, int height) {
		for(int i = 0; i < width; ++i) {
			for(int j = 0; j < height; ++j) {
				box[i*width + j] = 0;
			}
		}
	}

	public int[] returnResult() {
		return box;
	}
	
}
