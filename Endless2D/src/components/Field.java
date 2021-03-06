package components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class Field extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = -6805038923918428732L;
	protected double width, height;
	protected int gridSize;
	protected double blockSizeX, blockSizeY;
	
	public Field()
	{
		width = 640;
		height = 480;
		gridSize = 12;
		init();
	}
	public Field(String name, int w, int h, int gS)
	{
		width = w;
		height = h;
		gridSize = gS;
		init();
	}
	private void init()
	{
		blockSizeX = width/gridSize;
		blockSizeY = height/gridSize;
		this.setPreferredSize(new Dimension((int)width, (int)height));
		this.setEnabled(true);
		this.setFocusable(true);
	}
	
	@Override
	public abstract void actionPerformed(ActionEvent e);
	@Override
	public abstract void paintComponent(Graphics g);
	
	public int getGridSize()
	{
		return gridSize;
	}
	public double getBlockX()
	{
		return blockSizeX;
	}
	public double getBlockY()
	{
		return blockSizeY;
	}
	
	
	
	
	
}
