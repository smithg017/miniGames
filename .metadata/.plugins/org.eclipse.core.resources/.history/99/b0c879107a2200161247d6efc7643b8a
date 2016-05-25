package components;

public class Entity 
{
	private double x, y;
	private double velX, velY;
	private double accX, accY;
	private int width, height;

	public Entity()
	{
		setX(10);
		setY(10);
		setVelX(0);
		setVelY(0);
		setWidth(20);
		setHeight(20);
		setAccX(0);
		setAccY(0);
	}
	public Entity(double locX, double locY, double vX, double vY, int w, int h, double aX, double aY)
	{
		setX(locX);
		setY(locY);
		setVelX(vX);
		setVelY(vY);
		setWidth(w);
		setHeight(h);
		setAccX(aX);
		setAccY(aY);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getVelY() {
		return velY;
	}
	public void setVelY(double velY) {
		this.velY = velY;
	}
	public double getVelX() {
		return velX;
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getAccX() {
		return accX;
	}
	public void setAccX(double accX) {
		this.accX = accX;
	}
	public double getAccY() {
		return accY;
	}
	public void setAccY(double accY) {
		this.accY = accY;
	}



	public void update()
	{
		x += velX;
		y += velY;
		velX += accX;
		velY += accY;
	}
	
}
