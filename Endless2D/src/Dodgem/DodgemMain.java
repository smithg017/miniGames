package Dodgem;

import java.awt.Dimension;

import javax.swing.JFrame;

public class DodgemMain 
{
	public static void main(String args[])
	{
		JFrame f = new JFrame("Dodgem");
		f.setPreferredSize(new Dimension(640,480));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(200, 100);
		f.add(new DodgemField(f));
		f.pack();
		f.setVisible(true);
	}
}
