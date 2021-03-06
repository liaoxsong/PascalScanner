package co.songliao.pascalscanner;

/**
 * Created by liaosong on 2018/2/23.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author steinmee
 */
public class SimpleScanner {


    // CONSTANTS
    private static final int START = 0;
    private static final int IN_ID = 1;
    private static final int IN_NUM = 2;
    private static final int COMMENT_START = 3;


    // Completion states
    private static final int ERROR = 10;
    private static final int ID_COMPLETE = 11;
    private static final int NUM_COMPLETE = 12;
    private static final int SYMBOL_COMPLETE = 13;

    // Instance variables
    private String theSource = "";
    private int currentIndex = 0;

    private final static String SYMBOLS = "+-*/%():,;'=";

    // Constructor
    public SimpleScanner(String toScan) {
        this.theSource = toScan;
    }

    // Instance functions
    public Token nextToken() {
        Token answer = null;
        // if there is no more string to consume, return null
        if (currentIndex >= theSource.length()) return null;

        String lexeme = "";

        // Start in start state
        int currentState = SimpleScanner.START;
        while (currentState < SimpleScanner.ERROR) {
            //System.out.println("While index is " + currentIndex + " and state is " + currentState);
            // By default the char is whitespace
            char currentChar = ' ';
            if (currentIndex >= theSource.length() && currentState != 0) {
                currentChar = ' ';
            } else if (currentIndex < theSource.length()) {
                currentChar = theSource.charAt(currentIndex);
            } else break;

            switch (currentState) {
                case SimpleScanner.COMMENT_START:
                    lexeme += currentChar;
                    //if found a '{' or exceeds the length of input, throw error
                    if (currentChar == '{' || currentIndex == theSource.length() -1) {
                        currentState = ERROR;
                    } else if (currentChar == '}') {
                        lexeme = "";
                        currentState = START;
                    }
                    currentIndex++;
                    break;
                case SimpleScanner.START:
                    if (currentChar == '{') {
                        currentIndex++;
                        lexeme = "{";
                        currentState = SimpleScanner.COMMENT_START;
                    } else if (Character.isLetter(currentChar)) {
                        lexeme += currentChar;
                        currentState = SimpleScanner.IN_ID;
                        currentIndex++;
                    } else if (Character.isDigit(currentChar)) {
                        lexeme += currentChar;
                        currentState = SimpleScanner.IN_NUM;
                        currentIndex++;
                    } else if (Character.isWhitespace(currentChar)) {
                        currentIndex++;
                    } else if (SYMBOLS.indexOf("" + currentChar) > 0 ) {
                       currentState = SimpleScanner.SYMBOL_COMPLETE;
                        lexeme = lexeme + currentChar;
                        currentIndex++;

                    } else {
                        currentIndex++;
                        currentState = SimpleScanner.ERROR;
                        lexeme = lexeme + currentChar;
                    }
                    break;

                //接收到第一个字符来到这
                case SimpleScanner.IN_ID:
                    if (Character.isLetterOrDigit(currentChar)) {
                        lexeme = lexeme + currentChar;
                        currentIndex++;
                    } else {//如果没有就complete了
                        currentState = SimpleScanner.ID_COMPLETE;
                    }
                    break;

                case SimpleScanner.IN_NUM:
                    if (Character.isDigit(currentChar)) {
                        lexeme = lexeme + currentChar;
                        currentIndex++;
                    } else {
                        currentState = SimpleScanner.NUM_COMPLETE;
                    }
                    break;

                default:
                    System.out.println("Never get here");
                    break;
            } /// end switch
        } // end while


        // Now we are in a completion state:
        switch (currentState) {
            case ERROR:
                //todo: for debugging sake, we dont throw error and continue to find next token
                answer = new Token(lexeme, null);
                break;
            case ID_COMPLETE:
                TokenType idToken = LookUpTable.TABLE.get(lexeme);
                if (idToken == null) idToken = TokenType.ID;
                answer = new Token(lexeme, idToken);
                break;
            case NUM_COMPLETE:
                answer = new Token(lexeme, TokenType.INTEGER);
                break;
            case SYMBOL_COMPLETE:
                TokenType whichToken = LookUpTable.TABLE.get(lexeme);
                answer = new Token(lexeme, whichToken);
                break;
        }
        return answer;
    }
}
