package components;

import java.awt.Color;

public class BasicBlock 
{
	private int gridX, gridY;
	private Color color;
	
	public BasicBlock(int x, int y)
	{
		setGridX(x);
		setGridY(y);
		setColor(Color.BLACK);
	}
	public BasicBlock(int x, int y, Color c)
	{
		setGridX(x);
		setGridY(y);
		setColor(c);
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getGridX() {
		return gridX;
	}
	public void setGridX(int gridX) {
		this.gridX = gridX;
	}
	public int getGridY() {
		return gridY;
	}
	public void setGridY(int gridY) {
		this.gridY = gridY;
	}
}
