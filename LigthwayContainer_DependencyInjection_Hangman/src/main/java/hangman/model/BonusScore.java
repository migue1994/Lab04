package hangman.model;

import hangman.exception.ScoreException;

public class BonusScore implements GameScore{
	
	final int bono=10;
	final int penal=5;
	final int maximo=32767;
	final int puntajeInicial=0;
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
		
		int puntaje=0,p2=0; long p1;
		p1=bono*correctCount;
		if(p1<=maximo) puntaje+=p1;
		else puntaje=maximo;
		p2=puntaje-penal*incorrectCount;
		if(p2>=0) puntaje=p2;
		else puntaje=0;
		return puntaje;
	}
	
	public int getPuntajeInicial() {
		return this.puntajeInicial;	
	}

	
}