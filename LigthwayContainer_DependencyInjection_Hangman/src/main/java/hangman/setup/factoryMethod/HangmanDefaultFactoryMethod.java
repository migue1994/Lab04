package hangman.setup.factoryMethod;

<<<<<<< HEAD
=======
import hangman.model.*;
>>>>>>> inyección de dependencias
import hangman.model.English;
import hangman.model.Language;
import hangman.model.dictionary.EnglishDictionaryDataSource;
import hangman.model.dictionary.HangmanDictionary;
import hangman.view.HangmanPanel;
import hangman.view.HangmanStickmanPanel;

public class HangmanDefaultFactoryMethod extends HangmanFactoryMethod {
    @Override
    public Language createLanguage() {
        return new English();
    }

    @Override
    public HangmanDictionary createDictionary() {
        return new EnglishDictionaryDataSource();
    }

    @Override
    public HangmanPanel createHangmanPanel() {
        return new HangmanStickmanPanel();
    }
<<<<<<< HEAD
=======
    
    public GameScore createGame() {
        return new OriginalScore();
    }
>>>>>>> inyección de dependencias
}