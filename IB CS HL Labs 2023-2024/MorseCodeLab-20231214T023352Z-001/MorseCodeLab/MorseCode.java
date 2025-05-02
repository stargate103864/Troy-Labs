/* 
 * @author:
 *  period:
 *
 *  directions: complete the methods below. the lab should be case insensitive
 *
 *  You should use the TreeNode class provided in this project
 *  I have been told the java version of TreeNode is more complicated
 *  to use than this simpler TreNode class provided by The College Board
 *  during the years of the AP Computer Science AB test
 */

import java.util.TreeMap;

public class MorseCode
{
    private static final char DOT = '.';
    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode decodeTree;

    // this method is complete
    public static void start()
    {
        codeMap = new TreeMap<Character, String>();
        decodeTree = new TreeNode(new Character(' '), null, null);
        // put a space in the root of the decoding tree

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }

    /**
     *  Inserts a letter and its Morse code string into the encoding map (codeMap)
     *  and calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char letter, String code)
    {
        codeMap.put(letter, code);
        treeInsert(letter, code);
    }

    /**
     *  Inserts a letter according to its Morse code string into the 
     *  decoding tree.  Each dot-dash string corresponds to a path
     *  in the tree from the root to a node: at a "dot" go left, at a "dash" go
     *  right.  The node at the end of the path holds the symbol
     *  for that code string.  See the word documents for more help.
     */
    private static void treeInsert(char letter, String code)
    {
        char[] yeet = code.toCharArray();
        TreeNode var1 = decodeTree;
        for (char x : yeet) {
            if (x == DOT) 
            {
                if (var1.getLeft() == null)
                {
                    var1.setLeft(new TreeNode(" "));
                }
                var1 = var1.getLeft();
            }
            if (x == DASH) 
            {
                if (var1.getRight() == null)
                {
                    var1.setRight(new TreeNode(" "));
                }
                var1 = var1.getRight();
            }
        }
        var1.setValue(letter);
    }

    /**
     *   Converts text into a Morse code message.  Adds a space after a dot-dash
     *   sequence for each letter.  Other spaces in the text are transferred directly
     *   into the encoded message.
     *   Returns the encoded message.
     */
    public static String encode(String text)
    {
        StringBuffer morse = new StringBuffer(400);
        char[] yoinkers = text.toUpperCase().toCharArray();
        for (char lmnop : yoinkers) 
        {
            if (codeMap.containsKey(lmnop))
            {
                morse.append(codeMap.get(lmnop) + " ");
            }
            else
            {
                morse.append(" ");
            }
        }
        return morse.toString();
    }

    /**
     *   Converts a Morse code message into a text string.  Assumes that dot-dash
     *   sequences for each letter are separated by one space.  Additional spaces are
     *   transferred directly into text.
     *   Returns the plain text message.
     */
    public static String decode(String morse)
    {
        StringBuffer text = new StringBuffer(100);

        String[] whyme = morse.split("[\\s]");
        for (String x : whyme) {
            if (x.equals(" ")) {
                text.append(" ");
            } else {
                char[] poodle = x.toCharArray();
                TreeNode head = decodeTree;
                for (char lol : poodle) {
                    if (lol == DOT)
                        head = head.getLeft();
                    if (lol == DASH)
                        head = head.getRight();
                }
                text.append(head.getValue());
            }
        }
        return text.toString();
    }
}