/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dictionaryapplication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author HH
 */
public class translateJFrame extends javax.swing.JFrame {
    /**
     * Creates new form translateJFrame
     */
    
    private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
    private static final String CLIENT_SECRET = "PUBLIC_SECRET";
    private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
    private String lang1 = "en";
    private String lang2 = "vi";
    
    public translateJFrame() {
        initComponents();
    }
    
    private void sound(String word, String lang) {
        String link = "https://translate.google.com/translate_tts?ie=UTF-8&client=tw-ob&tl=" + lang + "&q=" + word.replace(" ", "+");
        try {
            URL url = new URL(link);
            BufferedInputStream in = new BufferedInputStream(url.openStream());
            Player m = new Player(in);
            m.play();
            m.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(DictionaryApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | JavaLayerException ex) {
            Logger.getLogger(DictionaryApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void translate(String lang1, String lang2, String text) throws Exception {
    // TODO: Should have used a 3rd party library to make a JSON string from an object
    String jsonPayload = new StringBuilder()
      .append("{")
      .append("\"fromLang\":\"")
      .append(lang1)
      .append("\",")
      .append("\"toLang\":\"")
      .append(lang2)
      .append("\",")
      .append("\"text\":\"")
      .append(text)
      .append("\"")
      .append("}")
      .toString();

    URL url = new URL(ENDPOINT);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
    conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
    conn.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonPayload.getBytes());
            os.flush();
        }

    int statusCode = conn.getResponseCode();
    BufferedReader br = new BufferedReader(new InputStreamReader(
        (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
      ));
    String output;
    while ((output = br.readLine()) != null) {
        lang2JTextArea.setText(output);        
    }
    conn.disconnect();
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lang1JTextArea = new javax.swing.JTextArea();
        lang1JLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lang2JTextArea = new javax.swing.JTextArea();
        lang2JLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        sound2JLabel = new javax.swing.JLabel();
        sound1JLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dịch văn bản");
        setBackground(new java.awt.Color(0, 51, 204));
        setResizable(false);

        lang1JTextArea.setColumns(20);
        lang1JTextArea.setLineWrap(true);
        lang1JTextArea.setRows(5);
        jScrollPane1.setViewportView(lang1JTextArea);

        lang1JLabel.setText("Tiếng Anh");

        jButton1.setText("Biên dịch");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lang2JTextArea.setEditable(false);
        lang2JTextArea.setBackground(new java.awt.Color(204, 204, 255));
        lang2JTextArea.setColumns(20);
        lang2JTextArea.setLineWrap(true);
        lang2JTextArea.setRows(5);
        jScrollPane3.setViewportView(lang2JTextArea);

        lang2JLabel.setText("Tiếng Việt");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-data-transfer-20.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        sound2JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-sound-23.png"))); // NOI18N
        sound2JLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sound2JLabelMouseClicked(evt);
            }
        });

        sound1JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-sound-23.png"))); // NOI18N
        sound1JLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sound1JLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sound2JLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sound1JLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 176, Short.MAX_VALUE)
                                .addComponent(lang1JLabel)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lang2JLabel)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sound1JLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lang1JLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)
                                .addComponent(lang2JLabel, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sound2JLabel)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(lang1JLabel.getText().equals("Tiếng Anh")) {
            lang1JLabel.setText("Tiếng Việt");
            this.lang1 = "vi";
            lang2JLabel.setText("Tiếng Anh");
            this.lang2 = "en";
        } else {
            lang2JLabel.setText("Tiếng Việt");
            this.lang2 = "vi";
            lang1JLabel.setText("Tiếng Anh");
            this.lang1 = "en";
        }
           
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
//        if (lang1JLabel.getText().equals("Tiếng anh")) {
//            this.lang1 = "en";
//            this.lang2 = "vi";
//        } else {
//            this.lang2 = "en";
//            this.lang1 = "vi";
//        }
        String in = lang1JTextArea.getText();
        try {
            translate(lang1, lang2, in);
        } catch (Exception ex) {
            Logger.getLogger(translateJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sound1JLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sound1JLabelMouseClicked
        // TODO add your handling code here:
        sound(lang1JTextArea.getText(), lang1);
    }//GEN-LAST:event_sound1JLabelMouseClicked

    private void sound2JLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sound2JLabelMouseClicked
        // TODO add your handling code here:
        sound(lang2JTextArea.getText(), lang2);
    }//GEN-LAST:event_sound2JLabelMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lang1JLabel;
    private javax.swing.JTextArea lang1JTextArea;
    private javax.swing.JLabel lang2JLabel;
    private static javax.swing.JTextArea lang2JTextArea;
    private javax.swing.JLabel sound1JLabel;
    private javax.swing.JLabel sound2JLabel;
    // End of variables declaration//GEN-END:variables
}
