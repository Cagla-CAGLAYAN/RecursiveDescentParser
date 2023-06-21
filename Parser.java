import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Parser {
    static int nextToken;
    static char[] lexeme;
    static char nextChar;
    static int lexLen;
    static FileReader in_fp;
    static int charClass;



    static void addChar() {
        if (lexLen <= 20) {
            lexeme[nextChar++] = nextChar;
            lexeme[lexLen] = '\0';
        } else {
            System.out.println("error! lexeme is too long");
        }
    }


    static void getChar() {

        try {
            int readChar = in_fp.read();
            if (Character.isLetter(nextChar)) {
                charClass = TokenType.LETTER;
            } else if (Character.isDigit(nextChar)) {
                charClass = TokenType.DIGIT;
            } else {
                charClass = TokenType.UNKNOWN;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int lex() {
        lexLen = 0;
        //int charClass = 0;
        switch (charClass) {
            case TokenType.LETTER:
                addChar();
                getChar();
                while (charClass == TokenType.LETTER || charClass == TokenType.DIGIT) {
                    addChar();
                    getChar();
                }
                nextToken = TokenType.IDENTIFIER;
                break;

            case TokenType.DIGIT:
                addChar();
                getChar();
                while (charClass == TokenType.DIGIT) {
                    addChar();
                    getChar();
                }
                nextToken = TokenType.INT_LIT;
                break;
        }
        return nextToken;
    }


    static char lookup(String lexeme){
        if(Objects.equals(charClass, "topla")){
            Lexer.addChar();
            nextToken = TokenType.ADD_OP;
        }
        else if(Objects.equals(charClass, "çıkar")){
            Lexer.addChar();
            nextToken = TokenType.SUB_OP;
        }
        else if(Objects.equals(charClass,"çarp")){
            Lexer.addChar();
            nextToken = TokenType.MULT_OP;
        }
        else if(Objects.equals(charClass,"böl")){
            Lexer.addChar();
            nextToken = TokenType.DIV_OP;
        }
        else if(Objects.equals(charClass,"sol parantez")){
            Lexer.addChar();
            nextToken = TokenType.LEFT_PAREN;
        }
        else if(Objects.equals(charClass,"sağ parantez")){
            Lexer.addChar();
            nextToken = TokenType.RIGHT_PAREN;
        }

        else if(Objects.equals(charClass,"eşittir")) {
            Lexer.addChar();
            nextToken = TokenType.ASSIGN_OP;
        }

        return (char) nextToken;


    }


}