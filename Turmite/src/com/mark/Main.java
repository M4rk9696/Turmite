package com.mark;

import com.mark.core.Rule;
import com.mark.core.Turmite;
import com.mark.display.GUI;
import com.mark.util.Point;
import com.mark.util.State.InputState;
import com.mark.util.State.OutputState;

public class Main {
	
	public static void main(String[] args) {
		
		int h = 500, w = 500;
		Rule rule = new Rule();
		
		rule.add(new InputState(0, 0), new OutputState(0, 1, 1));
		rule.add(new InputState(0, 1), new OutputState(1, 1, 1));
		rule.add(new InputState(1, 0), new OutputState(0, 0, 0));
		rule.add(new InputState(1, 1), new OutputState(1, 0, 0));
		
		Point stPoint = new Point(h/2, w/2);
		InputState state = new InputState(0, 0);
		Turmite t = new Turmite(stPoint, rule, h, w, state);
		
		t.performIteration(1000);
		int[] I = t.returnResult();
		
		GUI gui = new GUI(h, w, I);
		gui.setVisible(true);
		
	}

}
