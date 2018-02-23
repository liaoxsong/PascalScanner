package co.songliao.pascalscanner;

import junit.framework.Test;

import java.util.HashMap;

public class LookUpTable {

    public static HashMap<String, TokenType> TABLE = new HashMap<>();

    static {
        //EQUAL, NOTEQUAL, LESS, LESSEQUAL, BIGGEREQUAL, BIGGER,
        TABLE.put("=", TokenType.EQUAL);
        TABLE.put("<>", TokenType.NOTEQUAL);
        TABLE.put("<", TokenType.LESS);
        TABLE.put("<=", TokenType.LESSEQUAL);
        TABLE.put(">=", TokenType.GREATEQUAL);
        TABLE.put(">", TokenType.GREATER);

        //PLUS, MINUS, OR,
        TABLE.put("+", TokenType.PLUS);
        TABLE.put("-", TokenType.MINUS);
        TABLE.put("or", TokenType.OR);

        //mulop * / div mod and, (not sure about 'div')
//		MULTI, DIV, MOD, AND,
        TABLE.put("*", TokenType.MULTI);
        TABLE.put("/", TokenType.DIV);
        TABLE.put("%", TokenType.MOD);
        TABLE.put("and", TokenType.AND);

//				ASSIGN,
        TABLE.put(":=", TokenType.ASSIGN);
//
//				//keyword, partially referred from http://wiki.freepascal.org/Reserved_words
//				ARRAY, BEGIN, CONST, DO, ELSE, END, FOR, FUNCTION,
//				IF, NOT, PROCEDURE, PROGRAM, STRING, THEN, VAR, WHILE,

        TABLE.put("array", TokenType.ARRAY);
        TABLE.put("begin", TokenType.BEGIN);
        TABLE.put("const", TokenType.CONST);
        TABLE.put("do", TokenType.DO);
        TABLE.put("else", TokenType.ELSE);
        TABLE.put("end", TokenType.END);
        TABLE.put("for", TokenType.FOR);
        TABLE.put("function", TokenType.FUNCTION);
        TABLE.put("if", TokenType.IF);
        TABLE.put("not", TokenType.NOT);
        TABLE.put("procedure", TokenType.PROCEDURE);
        TABLE.put("program", TokenType.PROGRAM);
        TABLE.put("string", TokenType.STRING);
        TABLE.put("then", TokenType.THEN);
        TABLE.put("var", TokenType.VAR);
        TABLE.put("while", TokenType.WHILE);

//				INTEGER, REAL,
        TABLE.put("integer", TokenType.INTEGER);
        TABLE.put("real", TokenType.REAL);

//				ID
        TABLE.put("", TokenType.ID);


    }

}