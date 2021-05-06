package unq;

public class Square extends Quadrilateral{
	private Point esquinaA;
	private int side;
	
	/**
	 * El cuadrado se va a construir hacia arriba y la derecha del punto dado, comenzando en el (0,0) si no se da un punto 
	*/
	public Square(int side) {
		this.setEsquinaA(new Point());
		this.setSide(side);
	}
	public Square(Point point, int side) {
		this.setEsquinaA(point);
		this.setSide(side);
	}
	
	private void setEsquinaA(Point point) {
		esquinaA = point;
	}
	private void setSide(int n) {
		side = n;
	}
	
	public int getSide() {
		return side;
	}
	@Override
	public Point getEsquinaA() {
		return esquinaA;
	}
	@Override
	public Point getEsquinaB() {
		return new Point (this.getEsquinaD().getX(), this.getEsquinaC().getY());
	}
	@Override
	public Point getEsquinaC() {
		return new Point (this.getEsquinaA().getX(), this.getEsquinaA().getY() + this.getSide());
	}
	@Override
	public Point getEsquinaD() {
		return new Point (this.getEsquinaA().getX() + this.getSide(), this.getEsquinaA().getY());
	}
	
	@Override
	public int getWidth() {
		return this.getSide();
	}
	@Override
	public int getHeight() {
		return this.getSide();
	}

}
