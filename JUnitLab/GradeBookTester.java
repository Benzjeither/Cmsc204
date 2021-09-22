import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	// gB = gradeBook
	GradeBook gB1 = new GradeBook(5);
	GradeBook gB2 = new GradeBook(5);
	
	@BeforeEach
	void setUp() throws Exception {

		// gB = gradeBook
	
		gB1.addScore(25.5);
		gB1.addScore(25.5);
		gB2.addScore(35.6);
		gB2.addScore(50.3);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		gB1 = null;
		gB2 = null;
	}

	@Test
	void testAddScore() {
	
		assertTrue(gB1.toString().equals("25.5 25.5 "));
		assertTrue(gB2.toString().equals("35.6 50.3 "));
	}

	@Test
	void testSum() {
		assertEquals(51, gB1.sum(), .0001);
		assertEquals(85.9, gB2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(25.5, gB1.minimum(), .001);
		assertEquals(35.6, gB2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(25.5, gB1.finalScore(), .0001);
		assertEquals(50.3, gB2.finalScore(), .0001);
	}



}
