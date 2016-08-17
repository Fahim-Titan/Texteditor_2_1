/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tex.the.text.editor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import say.swing.JFontChooser;
import tex.the.text.editor.dialog.FindStringDialog;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();

        StyledDocument doc = TextEditor.getStyledDocument();

        /*   TextEditor.addMouseMotionListener(new MouseMotionListener() {

         @Override
         public void mouseDragged(MouseEvent e) {
                
         }

         @Override
         public void mouseMoved(MouseEvent e) {
         int x = e.getX();
         int y = e.getY();
         CursorPosition.setText(x + ", " + y);
         }
         });*/

        //   TextEditor.read(null, doc);

        TextEditor.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           /*      int caretPosition = TextEditor.getCaretPosition();
                 CursorPosition.setText(String.valueOf(caretPosition));
                 */
                int column = RXTextUtilities.getColumnAtCaret(TextEditor);
                int row = RXTextUtilities.getLineAtCaret(TextEditor);
                CursorPosition.setText("Line " + row + ", Column" + column);

                wordCount.setText("Word Count: " + getWordCount());
            }
        });

    }

    public int getWordCount() {
        StyledDocument doc = TextEditor.getStyledDocument();
        String str = null;
        try {
            str = doc.getText(0, doc.getLength());
            System.out.println("Start printing: ");
            //    System.err.println(str);
        } catch (BadLocationException ex) {
//            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        /*   char[] ca = str.toCharArray();
         for (char x : ca) {
         System.out.print(x);
         }
         str.replaceAll("\\n", "XX");
         String[] words = str.split(" ");
         */
        boolean op = false;
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (!op) {
                    op = true;
                    count++;
                }
            } else {
                op = false;
            }
        }




        return count;
    }

    public void sortLines() {
        TextEditor.getSelectionStart();


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem6 = new javax.swing.JMenuItem();
        MainPanel = new javax.swing.JPanel(new BorderLayout());
        statusPanel = new javax.swing.JPanel();
        CursorPosition = new javax.swing.JLabel();
        tabSize = new javax.swing.JLabel();
        wordCount = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane(MainPanel);
        TextEditor = new javax.swing.JTextPane();
        MainPanel.add(TextEditor);

        TextLineNumber tln = new TextLineNumber(TextEditor);
        jScrollPane2.setRowHeaderView( tln );
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuOpen = new javax.swing.JMenuItem();
        jMenuSave = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuFindString = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TeX - The Text Editor");
        setPreferredSize(new java.awt.Dimension(800, 600));
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                formCaretPositionChanged(evt);
            }
        });

        MainPanel.setBackground(new java.awt.Color(51, 51, 51));

        statusPanel.setBackground(new java.awt.Color(204, 204, 204));

        CursorPosition.setText("Line 1, Column 1");

        tabSize.setText("Plain Text");

        wordCount.setText("Word Count: ");

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CursorPosition)
                .addGap(88, 88, 88)
                .addComponent(wordCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabSize, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CursorPosition)
                    .addComponent(tabSize)
                    .addComponent(wordCount))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        TextEditor.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                TextEditorCaretPositionChanged(evt);
            }
        });
        TextEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextEditorKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(TextEditor);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        File.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New");
        File.add(jMenuItem1);

        jMenuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuOpen.setText("Open");
        jMenuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpenActionPerformed(evt);
            }
        });
        File.add(jMenuOpen);

        jMenuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuSave.setText("Save");
        jMenuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSaveActionPerformed(evt);
            }
        });
        File.add(jMenuSave);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Save As");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        File.add(jMenuItem4);

        MenuBar.add(File);

        Edit.setText("Edit");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Cut");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Edit.add(jMenuItem5);

        jMenuItem7.setText("Copy");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Edit.add(jMenuItem7);

        jMenuItem8.setText("Paste");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        Edit.add(jMenuItem8);

        jMenuItem9.setText("Sort Lines");
        Edit.add(jMenuItem9);

        MenuBar.add(Edit);

        jMenu1.setText("Find");

        jMenuFindString.setText("Find String");
        jMenuFindString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFindStringActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuFindString);

        MenuBar.add(jMenu1);

        jMenu2.setText("Format");

        jMenuItem2.setText("Font");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        MenuBar.add(jMenu2);

        jMenu3.setText("View");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Hide line & column");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem1);

        MenuBar.add(jMenu3);

        jMenu4.setText("Help");

        jMenuItem3.setText("about");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        MenuBar.add(jMenu4);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        String str = TextEditor.getSelectedText();
        TextEditor.setText(TextEditor.getText().replace(TextEditor.getSelectedText(),""));
        setSysClipboardText(str);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void TextEditorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextEditorKeyTyped
        // TODO add your handling code here:
        //  System.out.println(evt.getKeyChar());
    }//GEN-LAST:event_TextEditorKeyTyped

    private void jMenuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpenActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        int response = jFileChooser.showOpenDialog(Edit);
        if (response == JFileChooser.APPROVE_OPTION) {
            try {
                File openFile = jFileChooser.getSelectedFile();
                TextEditor.setPage(openFile.toURI().toURL());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jMenuOpenActionPerformed

    private void jMenuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSaveActionPerformed
        // TODO add your handling code here:
        saveToFile();
    }//GEN-LAST:event_jMenuSaveActionPerformed

    private void jMenuFindStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFindStringActionPerformed
        // TODO add your handling code here:
        FindStringDialog findDialog = new FindStringDialog(TextEditor, this, rootPaneCheckingEnabled);
        findDialog.setVisible(true);
    }//GEN-LAST:event_jMenuFindStringActionPerformed

    private void formCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formCaretPositionChanged

    private void TextEditorCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TextEditorCaretPositionChanged
        // TODO add your handling code here:
        //  int caretPosition = TextEditor.getCaretPosition();
        // CursorPosition.setText(String.valueOf(caretPosition));
    }//GEN-LAST:event_TextEditorCaretPositionChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // create JFontChooser using 'font' as initial font
        
//        Font prevFont = TextEditor.getFont();
        
        JFontChooser jFontChooser = new JFontChooser();
        // show font chooser dialog and get the result
        int result = jFontChooser.showDialog(MainWindow.this);
        // retrieve selected font
        Font selectedFont = null;
        if (result == JFontChooser.OK_OPTION) {
            selectedFont = jFontChooser.getSelectedFont();
            TextEditor.setFont(selectedFont);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        setSysClipboardText(TextEditor.getSelectedText());
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        about a = new about();
        a.setVisible(true);
                
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        statusPanel.setVisible(false);
        
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
                saveToFile();
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    
    public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    void saveToFile() {
        DefaultEditorKit defaultEditorKit = new DefaultEditorKit();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as");
        Document doc = TextEditor.getStyledDocument();

        if (fileChooser.showSaveDialog(Edit) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedOutputStream out;

            try {
                out = new BufferedOutputStream(new FileOutputStream(file));
                defaultEditorKit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CursorPosition;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JTextPane TextEditor;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuFindString;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuOpen;
    private javax.swing.JMenuItem jMenuSave;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel tabSize;
    private javax.swing.JLabel wordCount;
    // End of variables declaration//GEN-END:variables
}
