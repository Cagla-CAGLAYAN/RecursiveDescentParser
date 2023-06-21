import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Lexer {
    private List <Token> tokens;

    private static class Token{
        private int type;
        
        private String lexeme;

        private Token(int type, String Lexeme){
            this.type = type;
            this.lexeme = lexeme;
        }

    }


    public List<Token> tokens(String input) {
        tokens = new ArrayList<>();

        String regex = "\\s+|\\d+|\\p{L}\\w*|[+*/-]\\[abcdefghıjklmnoprstuvwxyz]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String lexeme = matcher.group().trim();

            if (lexeme.isEmpty()) {
                continue;
            }

            int type;
            if (lexeme.matches("\\d+")) {
                type = TokenType.DIGIT;
            } else if (lexeme.matches("\\+")) {
                type = TokenType.ADD_OP;
            } else if (lexeme.matches("\\*")) {
                type = TokenType.MULT_OP;
            } else if (lexeme.matches("\\/")) {
                type = TokenType.DIV_OP;
            } else if (lexeme.matches("\\-")) {
                type = TokenType.SUB_OP;
            }else if (lexeme.matches("\\(")) {
                type = TokenType.RIGHT_PAREN;
            }else if (lexeme.matches("\\)")) {
                type = TokenType.LEFT_PAREN;
            } else if (lexeme.matches("=")) {
                type = TokenType.ASSIGN_OP;
            } else if (lexeme.matches("\\' '\\t\\n")) {
                type = TokenType.IDENTIFIER;
            }
            else if(lexeme.matches("[abcdefghıjklmnoprstuvwxyz]")){
                type = TokenType.LETTER;
            }
            else {
                type = TokenType.WHITESPACE;
            }

            tokens.add(new Token(type, lexeme));
        }
        return tokens;
    }


    static char[] lexeme;
    static char nextChar;
    static int lexemeLength;






    static void addChar() {
        if (lexemeLength <= 100) {
            lexeme[lexemeLength] = 0;
            lexeme[lexemeLength++] = nextChar;

        }

    }
}

final class TokenType
{
    public static final int LETTER = 0;
    public static final int DIGIT = 1;
    public static final int UNKNOWN = 99;
    public static final int INT_LIT = 10;
    public static final int IDENTIFIER = 11;
    public static final int ASSIGN_OP = 20;
    public static final int ADD_OP = 21;
    public static final int SUB_OP = 22;
    public static final int MULT_OP = 23;
    public static final int DIV_OP = 24;
    public static final int WHITESPACE = 25;
    public static final int LEFT_PAREN = 26;
    public static final int RIGHT_PAREN = 27;


}
