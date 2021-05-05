package unq;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		this.setX(0);
		this.setY(0);
	}
	public Point(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	private void setX(int n){
		x = n;
	}
	
	private void setY(int n){
		y = n;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void movePointTo(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	public Point addPointTo(Point p){
		return new Point(
				this.getX() + p.getX(),
				this.getY() + p.getY()
				);
	}
}
