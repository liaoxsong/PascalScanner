/**
 * A simple Token class containing only a String.
 */
package co.songliao.pascalscanner;

public class Token {
    public String lexeme;
    public TokenType type;

    public Token(String l, TokenType t) {
        this.lexeme = l;
        this.type = t;
    }
}