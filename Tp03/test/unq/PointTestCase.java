package unq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class PointTestCase {
	private Point pointA;
	private Point pointB;
	private Point point0;
	private Point negativePoint;
	
	@BeforeEach
	public void setUp(){
		pointA = new Point(1, 5);
		pointB = new Point(4, 0);
		point0 = new Point();
		negativePoint = new Point(-1, -10);
	}
	
	@Test
	void testPoint() {
		assertEquals(pointA.getX(), 1);
		assertEquals(pointA.getY(), 5);
	}
	
	@Test
	void testPoint0() {
		assertEquals(point0.getX(), 0);
		assertEquals(point0.getY(), 0);
	}
	
	@Test
	void testNegativePoint() {
		assertEquals(negativePoint.getX(), -1);
		assertEquals(negativePoint.getY(), -10);
	}
	
	@Test
	void testPointSum() {
		Point pointC = pointA.addPointTo(pointB);
		Point pointD = pointA.addPointTo(negativePoint);
		
		assertEquals(pointC.getX(), 5);
		assertEquals(pointC.getY(), 5);

		assertEquals(pointD.getX(), 0);
		assertEquals(pointD.getY(), -5);
	}

}
