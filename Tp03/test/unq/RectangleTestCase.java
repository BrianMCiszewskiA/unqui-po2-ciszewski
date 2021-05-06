package unq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class RectangleTestCase {
	private Point pointA;
	private Point pointB;
	
	private Rectangle rectangleA;
	private Rectangle rectangleB;
	private Rectangle rectangleC;
	
	@BeforeEach
	public void setUp() {
		pointA = new Point(5, 10);
		pointB = new Point(-10, 0);
		
		rectangleA = new Rectangle(pointA, pointB);
		rectangleB = new Rectangle(pointA, new Point());
		rectangleC = new Rectangle(new Point(), 10, 15);
	}
	
	@Test
	void testRectangleEsquinasCyD() {
		assertEquals(rectangleA.getEsquinaC().getX(), 5);
		assertEquals(rectangleA.getEsquinaC().getY(), 0);
		assertEquals(rectangleA.getEsquinaD().getX(), -10);
		assertEquals(rectangleA.getEsquinaD().getY(), 10);
	}
	
	@Test
	void testRectangleLados() {
		assertEquals(rectangleA.getHeight(), 10);
		assertEquals(rectangleA.getWidth(), 15);
	}
	
	@Test
	void testRectanglePerimetro() {
		assertEquals(rectangleA.getPerimeter(), 50);
		assertEquals(rectangleB.getPerimeter(), 30);
		assertEquals(rectangleC.getPerimeter(), 50);
	}

	@Test
	void testRectangleArea() {
		assertEquals(rectangleA.getArea(), 150);
		assertEquals(rectangleB.getArea(), 50);
		assertEquals(rectangleC.getArea(), 150);
	}
	
	@Test
	void testRectangleVerOHor() {
		assertTrue(rectangleA.isHorizontal());
		assertTrue(rectangleB.isVertical());
		assertTrue(rectangleC.isHorizontal());
		

		assertFalse(rectangleA.isVertical());
		assertFalse(rectangleB.isHorizontal());
		assertFalse(rectangleC.isVertical());
	}
	
}
