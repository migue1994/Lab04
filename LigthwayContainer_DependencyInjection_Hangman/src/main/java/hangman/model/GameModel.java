/***************************************************************
* file: GameModel.java
* author:   Christopher Santos
*           Omar Rodriguez
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 10/11/2016
*
* purpose: This is the model component for the game screen
*
****************************************************************/ 
package hangman.model;

import hangman.exception.ScoreException;
import hangman.model.dictionary.HangmanDictionary;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class GameModel {
    private int incorrectCount;
    private int correctCount;
    private LocalDateTime dateTime;
    private int gameScore;
    private int[] lettersUsed;
    
    
    private HangmanDictionary dictionary;
    
    private Scanner scan;
    private String randomWord;
    private char[] randomWordCharArray;
	
    private GameScore game;
    private boolean inicial;
    
   
    public GameModel(HangmanDictionary dictionary, GameScore game){
        //this.dictionary = new EnglishDictionaryDataSource();
        this.dictionary=dictionary;
        this.game=game;
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScore = game.getPuntajeInicial();
        this.inicial=true;
        
    }
    
    //method: reset
    //purpose: reset this game model for a new game
    public void reset(){
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScore =game.getPuntajeInicial();
        this.inicial=true;
    }

    //setDateTime
    //purpose: sets game date/time to system date/time
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }
    
    //method: makeGuess
    //purpose: check if user guess is in string. Return a
    // list of positions if character is found in string
    public ArrayList<Integer> makeGuess(String guess){
        char guessChar = guess.charAt(0);
        ArrayList<Integer> positions = new ArrayList<>();
        for(int i = 0; i < randomWordCharArray.length; i++){
            if(randomWordCharArray[i] == guessChar){
                positions.add(i);
            }
        }
        if(positions.size() == 0){
            incorrectCount++;
        } else {
            correctCount += positions.size();
        }
        this.inicial=false;
        try {
			updateScore();
		} catch (ScoreException e) {
			e.printStackTrace();
		}
        return positions;        
    }
    
    //Actualiza el puntaje de acuerdo a la cantidad de respuestas correctas e incorrectas.
    public void updateScore() throws ScoreException {
    	try{
    		if(inicial) this.gameScore=game.getPuntajeInicial();
    		else this.gameScore=game.calculateScore(correctCount, incorrectCount);
    	}
    	catch(ScoreException e) {
    		e.printStackTrace();
    	}
    }
    
    //getDateTime
    //purpose: returns current displayed date/time
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-uuuu hh:mm:ss a");
        return dtf.format(dateTime);
    }

    //setScore
    //purpose: sets score value to points
    public void setScore(int score) {
        this.gameScore = score;
    }
    
    //getScore
    //purpose: returns current score value
    public int getScore() throws ScoreException {
    	updateScore();
        return gameScore;
    }

    //name: selectRandomWord()
    //purpose: selects random word from dictionary
    private String selectRandomWord() {
        Random rand = new Random();
        List<String> words = dictionary.getAvailableWords();
        return words.get(rand.nextInt(words.size()));
    }

    //method: getIncorrectCount
    //purpose: return number of incorrect guesses made so far
    public int getIncorrectCount() {
        return incorrectCount;
    }

    //method: getCorrectCount
    //purpose: return number of correct guesses made so far
    public int getCorrectCount() {
        return correctCount;
    }

    //method: getGameScore
    //purpose: return current score
    public int getGameScore() throws ScoreException {
    	updateScore();
        return gameScore;
    }

    //method: setGameScore
    //purpose: set current game score
    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }
    
    //method: getWordLength
    //purpose: return length of current word
    public int getWordLength(){
        return randomWord.length();
    }

    public List<Character> getCharacterSet() {
        return new ArrayList<>(dictionary.getCharacterSet());
    }
}
