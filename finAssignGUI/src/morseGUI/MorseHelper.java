package morseGUI;

/**
 * @author Darren Morkel, November 2021
 */
/**
 * Constructs the Morse Helper class with the given classes and supplies the
 * encode and decode classes to the finalMorse program.
 */
public class MorseHelper {

    /**
     * Holds the Morse code in a String array and will be used to encode and
     * decode the textField chars index's into the given corresponding chars
     */
    public static final String[] MORSE = new String[]{
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
        "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-",
        ".....", "-....", "--...", "---..", "----.", "-----"};

    /**
     * Holds the Alphanumeric chars in a Char array and will be used to encode
     * and decode the textField chars index's into the given corresponding chars
     */
    public static final char[] ALPHA = new char[]{
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9'};

    /**
     * Encodes the textField into Morse code by using a for loop that runs until
     * the length of the ALPHA char array, finds each char index of the
     * textField and encodes it by appending the corresponding MORSE to each
     * index position.
     */
    public static String encode(String textField) {
        StringBuffer encoded = new StringBuffer();
        for (int m = 0; m < textField.length(); m++) {
            for (int n = 0; n < ALPHA.length; n++) {
                if (textField.charAt(m) == ' ' || textField.charAt(m) == '\n') {
                    encoded.append("  ");
                    break;
                }

                if (textField.charAt(m) == ALPHA[n]) {
                    encoded.append(MORSE[n]);
                    encoded.append(" ");
                    break;
                }
            }
        }
        String txt = encoded.toString();
        return txt.substring(0, txt.length() - 1);
    }

    /**
     * Decodes the textField from MORSE code into regular ALPHA chars, splits
     * the textField with two appended spaces.
     */
    public static String decode(String textField) {
        StringBuffer decoded = new StringBuffer();
        String[] words = textField.split("  ");
        for (int a = 0; a < words.length; a++) {
            String[] code = words[a].split(" ");
            for (int b = 0; b < code.length; b++) {
                for (int c = 0; c < MORSE.length; c++) {
                    if (code[b].equals(MORSE[c])) {
                        decoded.append(ALPHA[c]);
                        break;
                    }
                }
            }
            decoded.append(" ");
        }
        String txt = decoded.toString();
        return txt.substring(0, txt.length() - 1);
    }
}
