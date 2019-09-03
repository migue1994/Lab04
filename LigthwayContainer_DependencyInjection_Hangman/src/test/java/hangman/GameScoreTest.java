package hangman;

import hangman.model.*;
import hangman.exception.*;
import java.beans.Transient;
import org.junit.*;

public class GameScoreTest {
	
	private OriginalScore originalScore=new OriginalScore();
	private BonusScore bonusScore=new BonusScore();
	private PowerScore powerScore=new PowerScore();
	private int totalScore;
	
	/******************************Probes Original Score**********************************/
	@Test
	public void invalidCorrectCountOriginal() throws ScoreException {
		try {
			totalScore=originalScore.calculateScore(-1, 5);
			Assert.assertTrue("Deberia lanzar la excepcion de valor invalido",1==0);
		}
		catch(ScoreException e) {
			Assert.assertEquals(e.getMessage(), ScoreException.INVALID_VALUE);
		}
	}
	
	@Test
	public void invalidIncorrectCountOriginal() throws ScoreException {
		try {
			totalScore=originalScore.calculateScore(5, -2);
			Assert.assertTrue("Deberia lanzar la excepcion de valor invalido",0==2);
		}
		catch(ScoreException e) {
			Assert.assertEquals(e.getMessage(), ScoreException.INVALID_VALUE);
		}
	}
	
	@Test
	public void invalidIncorrectAndCorrectCountOriginal() throws ScoreException {
		try {
			totalScore=originalScore.calculateScore(0,0);
			Assert.assertTrue("Deberia lanzar la excepcion de valor invalido",1==0);
		}
		catch(ScoreException e) {
			Assert.assertEquals(e.getMessage(), ScoreException.INVALID_VALUE);
		}
	}
	
	@Test
	public void puntajeMinimoCeroOriginal() throws ScoreException {
		try {
			totalScore=originalScore.calculateScore(0,20);
			Assert.assertEquals(0,totalScore);
		}
		catch(ScoreException e) {
			Assert.assertTrue("No deberia lanzar excepciones",1==0);
		}
	}
	
	@Test
	public void puntajeMaximoCienOriginal() throws ScoreException {
		try {
			totalScore=originalScore.calculateScore(20,0);
			Assert.assertEquals(100,totalScore);
		}
		catch(ScoreException e) {
			Assert.assertTrue("No deberia lanzar excepciones",1==0);
		}
	}
	
	@Test
	public void puntajeEntreCeroYCienOriginal() throws ScoreException {
		try {
			totalScore=originalScore.calculateScore(4,2);
			Assert.assertEquals(80,totalScore);
		}
		catch(ScoreException e) {
			Assert.assertTrue("No deberia lanzar excepciones",1==0);
		}
	}
	
	/******************************Probes Bonus Score**********************************/
	@Test
	public void invalidCorrectCountBonus() throws ScoreException {
		try {
			totalScore=bonusScore.calculateScore(-5, 1);
			Assert.assertTrue("Deberia lanzar la excepcion de valor invalido",1==0);
		}
		catch(ScoreException e) {
			Assert.assertEquals(e.getMessage(), ScoreException.INVALID_VALUE);
		}
	}
	
	@Test
	public void invalidIncorrectCountBonus() throws ScoreException {
		try {
			totalScore=bonusScore.calculateScore(4, -9);
			Assert.assertTrue("Deberia lanzar la excepcion de valor invalido",1==0);
		}
		catch(ScoreException e) {
			Assert.assertEquals(e.getMessage(), ScoreException.INVALID_VALUE);
		}
	}
	
	@Test
	public void invalidIncorrectAndCorrectCountBonus() throws ScoreException {
		try {
			totalScore=bonusScore.calculateScore(0,0);
			Assert.assertTrue("Deberia lanzar la excepcion de valor invalido",1==0);
		}
		catch(ScoreException e) {
			Assert.assertEquals(e.getMessage(), ScoreException.INVALID_VALUE);
		}
	}
	
	@Test
	public void puntajeMinimoCeroBonus() throws ScoreException {
		try {
			totalScore=bonusScore.calculateScore(0,3);
			Assert.assertEquals(0,totalScore);
		}
		catch(ScoreException e) {
			Assert.assertTrue("No deberia lanzar excepciones",1==0);
		}
	}
	
	@Test
	public void puntajeMaximoEsCapacidadMaximaDeEnteroBonus() throws ScoreException {
		try {
<<<<<<< HEAD
			totalScore=bonusScore.calculateScore(33000,0);
=======
			totalScore=bonusScore.calculateScore(70000,0);
>>>>>>> inyección de dependencias
			Assert.assertEquals(32767,totalScore);
		}
		catch(ScoreException e) {
			Assert.assertTrue("No deberia lanzar excepciones",1==0);
		}
	}
	
	@Test
	public void puntajeEntreCeroYMaximoBonus() throws ScoreException {
		try {
			totalScore=bonusScore.calculateScore(20,5);
			Assert.assertEquals(175,totalScore);
		}
		catch(ScoreException e) {
			Assert.assertTrue("No deberia lanzar excepciones",1==0);
		}
	}
	/******************************Probes Power Score**********************************/
	@Test
	public void invalidCorrectCountPower() throws ScoreException {
		try {
			totalScore=powerScore.calculateScore(-5, 1);
			Assert.assertTrue("Deberia lanzar la excepcion de valor invalido",1==0);
		}
		catch(ScoreException e) {
			Assert.assertEquals(e.getMessage(), ScoreException.INVALID_VALUE);
		}
	}
	
	@Test
	public void invalidIncorrectCountPower() throws ScoreException {
		try {
			totalScore=powerScore.calculateScore(4, -9);
			Assert.assertTrue("Deberia lanzar la excepcion de valor invalido",1==0);
		}
		catch(ScoreException e) {
			Assert.assertEquals(e.getMessage(), ScoreException.INVALID_VALUE);
		}
	}
	
	@Test
	public void invalidIncorrectAndCorrectCountPower() throws ScoreException {
		try {
			totalScore=powerScore.calculateScore(0,0);
			Assert.assertTrue("Deberia lanzar la excepcion de valor invalido",1==0);
		}
		catch(ScoreException e) {
			Assert.assertEquals(e.getMessage(), ScoreException.INVALID_VALUE);
		}
	}
	
	@Test
	public void puntajeMinimoCeroPower() throws ScoreException {
		try {
			totalScore=powerScore.calculateScore(1,30);
			Assert.assertEquals(0,totalScore);
		}
		catch(ScoreException e) {
			Assert.assertTrue("No deberia lanzar excepciones",1==0);
		}
	}
	
	@Test
	public void puntajeMaximoQuinientosPower() throws ScoreException {
		try {
			totalScore=powerScore.calculateScore(4,33);
			Assert.assertEquals(500,totalScore);
		}
		catch(ScoreException e) {
			Assert.assertTrue("No deberia lanzar excepciones",1==0);
		}
	}
	
	@Test
	public void puntajeEntreCeroYQuinientosPower() throws ScoreException {
		try {
			totalScore=powerScore.calculateScore(4,50);
			Assert.assertEquals(380,totalScore);
		}
		catch(ScoreException e) {
			Assert.assertTrue("No deberia lanzar excepciones",1==0);
		}
	}

}















