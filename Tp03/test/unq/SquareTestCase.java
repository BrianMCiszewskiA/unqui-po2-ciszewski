package unq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquareTestCase {
	private Point pointA;
	private Point pointB;
	
	private Square squareA;
	private Square squareB;
	private Square squareC;
	
	@BeforeEach
	public void setUp() {
		pointA = new Point(5, 10);
		pointB = new Point(-10, 0);
		
		squareA = new Square(pointA, 10);
		squareB = new Square(pointB, 5);
		squareC = new Square(15);
	}
	
	@Test
	void testSquareEsquinas() {
		assertEquals(squareC.getEsquinaC().getX(), 0);
		assertEquals(squareC.getEsquinaC().getY(), 15);
		assertEquals(squareC.getEsquinaD().getX(), 15);
		assertEquals(squareC.getEsquinaD().getY(), 0);
		assertEquals(squareC.getEsquinaA().getX(), 0);
		assertEquals(squareC.getEsquinaA().getY(), 0);
		assertEquals(squareC.getEsquinaB().getX(), 15);
		assertEquals(squareC.getEsquinaB().getY(), 15);
	}
	
	@Test
	void testSquareLados() {
		assertEquals(squareA.getHeight(), 10);
		assertEquals(squareA.getWidth(), 10);
		assertEquals(squareB.getHeight(), squareB.getWidth());
	}
	
	@Test
	void testSquarePerimetro() {
		assertEquals(squareA.getPerimeter(), 40);
		assertEquals(squareB.getPerimeter(), 20);
		assertEquals(squareC.getPerimeter(), 60);
	}

	@Test
	void testSquareArea() {
		assertEquals(squareA.getArea(), 100);
		assertEquals(squareB.getArea(), 25);
		assertEquals(squareC.getArea(), 225);
	}
}
