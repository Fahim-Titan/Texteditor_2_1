package tex.the.text.editor;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Tomas
 */
public class TextHighlighter {

    private Highlighter.HighlightPainter yellowPainter;
    JTextPane pane;

    public TextHighlighter(JTextPane tp) {
        pane = tp;
        yellowPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.green);
    }

    public boolean isSubString(String str, String word, int start) {
        int w = 0;
        for (int i = start; i < word.length(); i++) {
            if (str.charAt(i) != word.charAt(w++)) {
                return false;
            }
        }
        return true;
    }

    public void highlightWord(String word, boolean matchCase) {
        StyledDocument document = pane.getStyledDocument();
        try {
            for (int index = 0; index + word.length() <= document.getLength(); index++) {
                String match = document.getText(index, word.length());
                if (matchCase) {
                    if (word.equals(match)) {
                        pane.getHighlighter().addHighlight(index, index + word.length(),
                                yellowPainter);
                    }
                } else {
                    if (word.toLowerCase().equals(match.toLowerCase())) {
                        pane.getHighlighter().addHighlight(index, index + word.length(),
                                yellowPainter);
                    }
                }
            }
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }


    }

}
