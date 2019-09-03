package hangman.model;

import java.lang.Math;

import hangman.exception.*;

public class PowerScore implements GameScore{
	
	final int puntajeMaximo=500;
	final int bono=5;
	final int penal=8;
	final int puntajeInicial=0;
	private int totalScore;
	/**
	 * Pre: Se recibe la cantidad de letras correctas e incorrectas.
	 * Pos: Retorna el puntaje total dependiendo de las penalizaciones y los bonos.
	 * @param correctCount: Cantidad de letras correctas.
	 * @param incorrectCount: Cantidad de letras incorrectas.
	 */
	public int calculateScore(int correctCount, int incorrectCount) throws ScoreException{
		
		if(correctCount<0 || incorrectCount<0 || (correctCount==0 && incorrectCount==0)) {
			throw new ScoreException(ScoreException.INVALID_VALUE); 
		}
		
		int puntaje=0;
		
		for(int i=1;i<=correctCount;i++) {
			puntaje+=Math.pow(bono,i);
		}
		
		puntaje-=penal*incorrectCount;
		
		
		if(puntaje>500) puntaje=500;
		else if(puntaje<0) puntaje=0;
		
		this.totalScore=puntaje;
		return puntaje;
	}
	
	public int getPuntajeInicial() {
		return this.puntajeInicial;	
	}
	
	public int getPuntajeFinal() {
		return this.totalScore;
		
	}
}