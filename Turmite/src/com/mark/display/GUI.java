package com.mark.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GUI extends JFrame {
	int width, height;
	BufferedImage image;
	Graphics imgGraphics;
	
	public GUI(int height, int width) {
		super("Automata");
		setBounds(100, 100, width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.width = width;
		this.height = height;
		image = new BufferedImage(height, width, BufferedImage.TYPE_INT_BGR);
		int img[] = new int[width*height];
		image.setRGB(0, 0, width, height, img, 0, width);
		imgGraphics = image.getGraphics();
	}
	
	public void setBlock(int x, int y, int state, int sz) {
		if(state == 1)
			imgGraphics.setColor(Color.BLUE);
		else
			imgGraphics.setColor(Color.BLACK);
		imgGraphics.fillRect(x, y, sz, sz);
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}

}
