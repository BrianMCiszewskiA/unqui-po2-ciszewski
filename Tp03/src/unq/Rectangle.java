package unq;

public class Rectangle extends Quadrilateral {
	private Point esquinaA;
	private Point esquinaB;
	
	/**
	 * @param points Se piden dos puntos que sean las esquinas opuestas
	*/
	public Rectangle(Point a, Point b) {

		this.setEsquinaA(a);
		this.setEsquinaB(b);
	}
	public Rectangle(Point point, int height, int width) {
		this(point, new Point(point.getX()+width, point.getY()+height));
	}
	
	private void setEsquinaA(Point point) {
		esquinaA = point;
	}
	private void setEsquinaB(Point point) {
		esquinaB = point;
	}
	@Override
	public Point getEsquinaA() {
		return esquinaA;
	}
	@Override
	public Point getEsquinaB() {
		return esquinaB;
	}
	
	@Override
	public Point getEsquinaC() {
		return new Point (this.getEsquinaA().getX(), this.getEsquinaB().getY());
	}
	@Override
	public Point getEsquinaD() {
		return new Point (this.getEsquinaB().getX(), this.getEsquinaA().getY());
	}
	
	
	public boolean isHorizontal() {
		return this.getWidth() > this.getHeight();
	}
	public boolean isVertical() {
		return this.getWidth() < this.getHeight();
	}
}
