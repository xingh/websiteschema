/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PageSourcePanel.java
 *
 * Created on Dec 7, 2011, 2:29:18 PM
 */
package websiteschema.analyzer.browser.bottom;

/**
 *
 * @author ray
 */
public class PageSourcePanel extends javax.swing.JPanel {

    /** Creates new form PageSourcePanel */
    public PageSourcePanel() {
        initComponents();
        sourceArea.setLineWrap(this.wrapLineCheckBox.isSelected());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sourceArea = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        nextButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        wrapLineCheckBox = new javax.swing.JCheckBox();

        sourceArea.setColumns(20);
        sourceArea.setRows(5);
        jScrollPane1.setViewportView(sourceArea);

        jToolBar1.setRollover(true);

        jLabel1.setText("搜索: ");
        jToolBar1.add(jLabel1);
        jToolBar1.add(searchField);

        nextButton.setText("下一个");
        nextButton.setFocusable(false);
        nextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nextButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(nextButton);

        lastButton.setText("上一个");
        lastButton.setFocusable(false);
        lastButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lastButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(lastButton);

        jLabel2.setText("折行: ");
        jToolBar1.add(jLabel2);

        wrapLineCheckBox.setSelected(true);
        wrapLineCheckBox.setFocusable(false);
        wrapLineCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        wrapLineCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        wrapLineCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wrapLineCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(wrapLineCheckBox);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        String source = getSource();
        String target = this.searchField.getText();
        int pos = sourceArea.getCaretPosition();
        if (null != source) {
            int at = source.indexOf(target, pos + 1);
            if (at >= 0) {
                sourceArea.setCaretPosition(at);
            } else {
                at = source.indexOf(target, 0);
                if (at >= 0) {
                    sourceArea.setCaretPosition(at);
                }
            }
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        // TODO add your handling code here:
        String source = getSource();
        String target = this.searchField.getText();
        int pos = sourceArea.getCaretPosition();
        if (null != source) {
            int at = source.lastIndexOf(target, pos > 0 ? pos - 1 : source.length() - 1);
            if (at >= 0) {
                sourceArea.setCaretPosition(at);

            } else {
                at = source.lastIndexOf(target, source.length() - 1);
                if (at >= 0) {
                    sourceArea.setCaretPosition(at);
                }
            }
        }
    }//GEN-LAST:event_lastButtonActionPerformed

    private void wrapLineCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wrapLineCheckBoxActionPerformed
        // TODO add your handling code here:
        sourceArea.setLineWrap(this.wrapLineCheckBox.isSelected());
        sourceArea.updateUI();
    }//GEN-LAST:event_wrapLineCheckBoxActionPerformed

    public void setSource(String source) {
        this.sourceArea.setText(source);
        sourceArea.setCaretPosition(0);
    }

    public String getSource() {
        return this.sourceArea.getText();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton lastButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextArea sourceArea;
    private javax.swing.JCheckBox wrapLineCheckBox;
    // End of variables declaration//GEN-END:variables
}
