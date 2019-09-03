package hangman.model;

import hangman.exception.*;

public interface GameScore{
	
	public int calculateScore(int correctCount, int incorrectCount) throws ScoreException;
	
	public int getPuntajeInicial();
	public int getPuntajeFinal();
	
}