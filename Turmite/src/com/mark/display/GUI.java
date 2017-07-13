package com.mark.display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GUI extends JFrame {
	int width, height;
	BufferedImage image;
	
	public GUI(int height, int width, int[] img) {
		super("Automata");
		setBounds(100, 100, width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.width = width;
		this.height = height;
		image = new BufferedImage(height, width, BufferedImage.TYPE_INT_BGR);
		image.setRGB(0, 0, width, height, img, 0, width);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}

}
