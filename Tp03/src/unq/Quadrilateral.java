package unq;

public abstract class Quadrilateral {

	public int getWidth() {
		return Math.abs(this.getEsquinaA().getX() - this.getEsquinaB().getX());
	}
	public int getHeight() {
		return Math.abs(this.getEsquinaA().getY() - this.getEsquinaB().getY());
	}

	public int getArea() {
		return this.getHeight() * this.getWidth();
	}
	public int getPerimeter() {
		return 2*(this.getHeight() + this.getWidth());
	}

	public abstract Point getEsquinaA();
	public abstract Point getEsquinaB();
	public abstract Point getEsquinaC();
	public abstract Point getEsquinaD();
	
}
