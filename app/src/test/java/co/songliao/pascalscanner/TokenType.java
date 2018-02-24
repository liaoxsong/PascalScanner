package co.songliao.pascalscanner;

/**
 * Created by liaosong on 2018/2/23.
 *
 * e.g. a rough example..
 * var a: double = 5.0;
 * 'var' is keyword
 * 'a' is identifier
 *  ':' is symbol?
 *  'double' is type
 *  '=' is assign operator
 *  '5.0' is a constant
 *  ';' is symbol
 *
*/

public enum TokenType {
    //relational operator =, <>, <, <=, >=, >
    EQUAL, NOTEQUAL, LESS, LESSEQUAL, GREATEQUAL, GREATER,

    //addop +, -, or
    PLUS, MINUS, OR,

    //mulop * / div mod and, (not sure about 'div')
    MULTI, DIV, MOD, AND,

    //assignop
    ASSIGN,

    //keyword, partially referred from http://wiki.freepascal.org/Reserved_words
    ARRAY, BEGIN, CONST, DO, ELSE, END, FOR, FUNCTION,
    IF, NOT, PROCEDURE, PROGRAM, STRING, THEN, VAR, WHILE,

    //types
    INTEGER, REAL,

    //ID is identifier
    ID,

    SEMICOLON, COMMA, COLON , LEFTPAREN, RIGHTPAREN, QUOTE
}