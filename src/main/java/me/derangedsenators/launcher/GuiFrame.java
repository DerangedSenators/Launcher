/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.derangedsenators.launcher;



/**
 *
 * @author Elliot Willis
 */
public class GuiFrame extends javax.swing.JFrame {

    /**
     * Creates new form GuiFrame
     */
    public GuiFrame() {
        setUndecorated(true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightPanel = new javax.swing.JPanel();
        sidebar = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        titleField = new javax.swing.JTextField();
        subtitleField = new javax.swing.JTextField();
        devOptionsButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        progressBarText = new javax.swing.JTextField();
        versionNumber = new javax.swing.JTextField();
        progressBar = new javax.swing.JSeparator();
        playButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        sidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sidebar.gif"))); // NOI18N

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        leftPanel.setBackground(new java.awt.Color(50, 50, 50));
        leftPanel.setPreferredSize(new java.awt.Dimension(500, 300));

        titleField.setEditable(false);
        titleField.setBackground(new java.awt.Color(50, 50, 50));
        titleField.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        titleField.setForeground(new java.awt.Color(255, 255, 255));
        titleField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titleField.setText("Cops and Robbers");
        titleField.setBorder(null);
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        subtitleField.setEditable(false);
        subtitleField.setBackground(new java.awt.Color(50, 50, 50));
        subtitleField.setFont(new java.awt.Font("Roboto Condensed Light", 0, 14)); // NOI18N
        subtitleField.setForeground(new java.awt.Color(100, 100, 100));
        subtitleField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        subtitleField.setText("a DerangedSenators game");
        subtitleField.setBorder(null);
        subtitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtitleFieldActionPerformed(evt);
            }
        });

        devOptionsButton.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        devOptionsButton.setForeground(new java.awt.Color(255, 255, 255));
        devOptionsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoSmall.png"))); // NOI18N
        devOptionsButton.setBorder(null);
        devOptionsButton.setContentAreaFilled(false);
        devOptionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devOptionsButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Roboto Condensed Light", 0, 24)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("EXIT");
        exitButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 100, 100), 3, true));
        exitButton.setContentAreaFilled(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        progressBarText.setEditable(false);
        progressBarText.setBackground(new java.awt.Color(50, 50, 50));
        progressBarText.setFont(new java.awt.Font("Roboto Condensed Light", 2, 12)); // NOI18N
        progressBarText.setForeground(new java.awt.Color(100, 100, 100));
        progressBarText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        progressBarText.setText("Checking for Updates...");
        progressBarText.setBorder(null);
        progressBarText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarTextActionPerformed(evt);
            }
        });

        versionNumber.setEditable(false);
        versionNumber.setBackground(new java.awt.Color(50, 50, 50));
        versionNumber.setForeground(new java.awt.Color(100, 100, 100));
        versionNumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        versionNumber.setText("version 0.6");
        versionNumber.setBorder(null);
        versionNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                versionNumberActionPerformed(evt);
            }
        });

        progressBar.setForeground(new java.awt.Color(255, 255, 255));
        progressBar.setOpaque(true);

        playButton.setFont(new java.awt.Font("Roboto Condensed Light", 0, 24)); // NOI18N
        playButton.setForeground(new java.awt.Color(255, 255, 255));
        playButton.setText("LAUNCH");
        playButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 100, 100), 3, true));
        playButton.setContentAreaFilled(false);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleField)
            .addComponent(subtitleField)
            .addComponent(progressBarText)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressBar)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(versionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(devOptionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(devOptionsButton)
                .addGap(23, 23, 23)
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(subtitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(playButton))
                .addGap(18, 18, 18)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(versionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void devOptionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devOptionsButtonActionPerformed
        setVisible(false);
        //new DevOptions();
    }//GEN-LAST:event_devOptionsButtonActionPerformed

    private void progressBarTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_progressBarTextActionPerformed

    private void subtitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtitleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtitleFieldActionPerformed

    private void versionNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_versionNumberActionPerformed
        //does not seem to be detecting event
    }//GEN-LAST:event_versionNumberActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        LauncherMain.play();
    }//GEN-LAST:event_playButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public void loadGui() {
                new LogoIntro();
                new GuiFrame().setVisible(true);

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton devOptionsButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton playButton;
    public static javax.swing.JSeparator progressBar;
    public static javax.swing.JTextField progressBarText;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel sidebar;
    private javax.swing.JTextField subtitleField;
    private javax.swing.JTextField titleField;
    private javax.swing.JTextField versionNumber;
    // End of variables declaration//GEN-END:variables
}
