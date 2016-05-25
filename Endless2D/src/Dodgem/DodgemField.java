package Dodgem;

import components.Field;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import components.Entity;

public class DodgemField extends Field implements KeyListener
{
	private static final long serialVersionUID = 5367865662677506729L;
	private long start, finish;
	private JFrame parent;
	private Entity player;
	private ArrayList<Entity> enemies;
	private Timer t;
	private int counter;
	private int lives;
	private int rate;
	public DodgemField(JFrame f)
	{
		super();
		start = System.currentTimeMillis();
		parent = f;
		player = new Entity(320, 240, 0, 0, 20, 20, 0, 0);
		enemies = new ArrayList<Entity>();
		t = new Timer(5, this);
		counter = 0;
		lives = 10;
		addKeyListener(this);
		JOptionPane.showMessageDialog(null, "Hit OK to start!");
		t.start();
		setFocusable(true);
		setEnabled(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		rate = 80;
		width = parent.getWidth();
		height = parent.getHeight();
		counter++;
		player.update();
		if(player.getX() < 0)
			player.setX(0);
		else if(player.getX() > width-player.getWidth())
			player.setX(width-player.getWidth());
		else if(player.getY() < 0)
			player.setY(0);
		else if(player.getY() > height - player.getHeight())
			player.setY(height - player.getHeight());
		for(int j=0; j < enemies.size(); j++)
		{
			enemies.get(j).update();
			
			Rectangle r1 = new Rectangle((int)player.getX(), (int)player.getY(), player.getWidth(), player.getHeight());
			Rectangle r2 = new Rectangle((int)enemies.get(j).getX(), (int)enemies.get(j).getY(), enemies.get(j).getWidth(), enemies.get(j).getHeight());
			if(r1.intersects(r2))
			{
				enemies.remove(j);
				lives--;
				if(lives == 0)
				{
					finish = System.currentTimeMillis();
					long temp = (finish - start)/1000;
					JOptionPane.showMessageDialog(null, "Game Over! You lasted " + temp + " seconds.");
					int i = JOptionPane.showConfirmDialog(null, "Play again?");
					if(i == 0)
					{
						enemies = new ArrayList<Entity>();
						player = new Entity();
						player.setX(width/2);
						player.setY(height/2);
						counter = 0;
						lives = 10;
						t.restart();
					}
					else
						System.exit(0);
				}
				if(enemies.size() == 0)
					break;
				else if(j != 0)
					j--;
			}
			if(enemies.get(j).getX() < -20 || enemies.get(j).getX() > width || enemies.get(j).getY() > height || enemies.get(j).getY() < -20)
			{
				enemies.remove(j);
			}
			
		}
		
		if(counter%rate == 0)
		{
			int x,y;
			double velx,vely;
			double r = Math.random();
			if(r < .25)
			{
				x=-19;
				y=(int)(Math.random()*height);
			}
			else if(r < .5)
			{
				x=(int)width;
				y=(int)(Math.random()*height);
			}
			else if(r < .75)
			{
				x=(int)(Math.random()*width);
				y=-19;
			}
			else
			{
				x=(int)(Math.random()*width);
				y=(int)height;
			}
			velx = (player.getX() - x)/150;
			vely = (player.getY() - y)/150;
			enemies.add(new Entity(x, y, velx, vely, 20, 20, 0, 0));
		}
		if(counter%1000 == 0)
		{
			if(rate != 20)
			{
				//System.out.println("FASTER");
				rate -= 10;
			}
		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, (int)width, (int)height);
		g2.setColor(Color.BLACK);
		g2.fillRect((int)player.getX(), (int)player.getY(), player.getWidth(), player.getHeight());
		g2.setColor(Color.RED);
		for(Entity x : enemies)
			g2.fillRect((int)x.getX(), (int)x.getY(), x.getWidth(), x.getHeight());
		g2.setColor(Color.BLUE);
		g2.drawString(""+lives, (int)(width/2), 12);
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		//System.out.println("pressed");
		if(KeyEvent.VK_UP == e.getKeyCode())
			player.setVelY(-2);
		else if(KeyEvent.VK_DOWN == e.getKeyCode())
			player.setVelY(2);
		else if(KeyEvent.VK_LEFT == e.getKeyCode())
			player.setVelX(-2);
		else if(KeyEvent.VK_RIGHT == e.getKeyCode())
			player.setVelX(2);
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT)
			player.setVelX(0);
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
			player.setVelY(0);
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	
}
