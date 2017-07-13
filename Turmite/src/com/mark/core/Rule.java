package com.mark.core;

import java.util.HashMap;
import java.util.Map;

import com.mark.util.State.InputState;
import com.mark.util.State.OutputState;

public class Rule {
	Map<InputState, OutputState> rule = new HashMap<InputState, OutputState>();
	
	public void add(InputState x, OutputState y) {
		rule.put(x, y);
	}
	
	public OutputState getResult(InputState x) {
		return rule.get(x);
	}

}
