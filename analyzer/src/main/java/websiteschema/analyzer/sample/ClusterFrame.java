/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClusterFrame.java
 *
 * Created on Oct 28, 2011, 3:29:02 PM
 */
package websiteschema.analyzer.sample;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import websiteschema.context.BrowserContext;
import websiteschema.model.domain.cluster.Cluster;
import websiteschema.model.domain.cluster.ClusterModel;
import websiteschema.model.domain.cluster.Dimension;
import websiteschema.model.domain.cluster.DocVector;
import websiteschema.persistence.hbase.ClusterModelMapper;
import websiteschema.persistence.hbase.SampleMapper;

/**
 *
 * @author ray
 */
public class ClusterFrame extends javax.swing.JFrame {

    String siteId;
    SampleMapper sampleMapper = null;
    ClusterModelMapper cmMapper = null;
    ClusterModel cm = null;

    /** Creates new form ClusterFrame */
    public ClusterFrame(String siteId) {
        initComponents();
        this.siteId = siteId;
        this.setTitle("浏览 " + siteId + " 的聚类结果");

        int screenWidth = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        int screenHeight = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        int sizeWidth = this.getWidth();
        int sizeHeight = this.getHeight();
        this.setLocation((screenWidth - sizeWidth) / 2, (screenHeight - sizeHeight) / 2);
        sizeWidth = this.viewSimDialog.getWidth();
        sizeHeight = this.viewSimDialog.getHeight();
        this.viewSimDialog.setLocation((screenWidth - sizeWidth) / 2, (screenHeight - sizeHeight) / 2);

        sampleMapper = BrowserContext.getSpringContext().getBean("sampleMapper", SampleMapper.class);
        cmMapper = BrowserContext.getSpringContext().getBean("clusterModelMapper", ClusterModelMapper.class);

        loadData();
    }

    private void loadData() {
        new DataLoader().start();
    }

    private void load() {
        cm = cmMapper.get(siteId);
        showClusterModel();
    }

    private void showClusterModel() {
        if (null != cm) {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            int rows = table.getRowCount();
            for (int i = 0; i < rows; i++) {
                tableModel.removeRow(0);
            }

            Cluster[] clusters = cm.getClusters();
            if (null != clusters) {
                int i = 0;
                for (Cluster cluster : clusters) {
                    tableModel.addRow(convert(++i, cluster));
                }
            }
        }
    }

    private Vector convert(int id, Cluster cluster) {
        Vector vect = new Vector();
        vect.add(id);
        vect.add(cluster.getCentralPoint().getName());
        vect.add(null != cluster.getSamples() ? cluster.getSamples().size() : 0);
        vect.add(cluster.getThreshold());
        return vect;
    }

    class DataLoader extends Thread {

        @Override
        public void run() {
            load();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewSimDialog = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        simLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sampleViewDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        sampleTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        viewClusterButton = new javax.swing.JButton();
        checkButton = new javax.swing.JButton();
        mergeClusterButton = new javax.swing.JButton();
        deleteClusterButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        viewSimDialog.setMinimumSize(new java.awt.Dimension(217, 120));
        viewSimDialog.setResizable(false);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        simLabel.setText("0.0");

        jLabel2.setText("相似度：");

        javax.swing.GroupLayout viewSimDialogLayout = new javax.swing.GroupLayout(viewSimDialog.getContentPane());
        viewSimDialog.getContentPane().setLayout(viewSimDialogLayout);
        viewSimDialogLayout.setHorizontalGroup(
            viewSimDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSimDialogLayout.createSequentialGroup()
                .addGroup(viewSimDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewSimDialogLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simLabel))
                    .addGroup(viewSimDialogLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButton1)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        viewSimDialogLayout.setVerticalGroup(
            viewSimDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewSimDialogLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(viewSimDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simLabel)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addContainerGap())
        );

        sampleViewDialog.setMinimumSize(new java.awt.Dimension(600, 300));

        sampleTextArea.setColumns(20);
        sampleTextArea.setRows(5);
        jScrollPane2.setViewportView(sampleTextArea);

        javax.swing.GroupLayout sampleViewDialogLayout = new javax.swing.GroupLayout(sampleViewDialog.getContentPane());
        sampleViewDialog.getContentPane().setLayout(sampleViewDialogLayout);
        sampleViewDialogLayout.setHorizontalGroup(
            sampleViewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        sampleViewDialogLayout.setVerticalGroup(
            sampleViewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "序号", "中心点", "样本数", "阈值"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getColumn(0).setMaxWidth(30);
        table.getColumnModel().getColumn(2).setMaxWidth(100);
        table.getColumnModel().getColumn(3).setMaxWidth(100);

        jToolBar1.setRollover(true);

        viewClusterButton.setText("查看所选类的样本");
        viewClusterButton.setFocusable(false);
        viewClusterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewClusterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewClusterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewClusterButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(viewClusterButton);

        checkButton.setText("检查所选类之间的相似性");
        checkButton.setFocusable(false);
        checkButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(checkButton);

        mergeClusterButton.setText("合并所选类");
        mergeClusterButton.setFocusable(false);
        mergeClusterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mergeClusterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(mergeClusterButton);

        deleteClusterButton.setText("删除所选类");
        deleteClusterButton.setFocusable(false);
        deleteClusterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteClusterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteClusterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteClusterButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(deleteClusterButton);

        saveButton.setText("保存");
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(saveButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        cmMapper.put(cm);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteClusterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteClusterButtonActionPerformed
        // TODO add your handling code here:
        int selectRows = table.getSelectedRows().length;// 取得用户所选行的行数
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        if (selectRows > 0) {
            int[] selRowIndexs = table.getSelectedRows();// 用户所选行的序列

            for (int i = 0; i < selRowIndexs.length; i++) {
                // 用tableModel.getValueAt(row, column)取单元格数据
                String cp = (String) tableModel.getValueAt(selRowIndexs[i], 1);
                System.out.println(cp);
                cm.delete(cp);
            }
            for (int i = 0; i < selRowIndexs.length; i++) {
                tableModel.removeRow(selRowIndexs[0]);
            }
        }
    }//GEN-LAST:event_deleteClusterButtonActionPerformed

    private double cosine(DocVector v1, DocVector v2) {
        double d = 0.0;

        d = dot(v1, v2) / (abs(v1) * abs(v2));

        return d;
    }

    private double abs(DocVector v) {
        double d = 0.0;
        for (Dimension dim : v.getDims()) {
            d += dim.getValue() * dim.getValue();
        }
        d = Math.sqrt(d);
        return d;
    }

    private double dot(DocVector v1, DocVector v2) {
        Dimension[] dims1 = v1.getDims();
        Dimension[] dims2 = v2.getDims();
        if (dims2.length > dims1.length) {
            Dimension[] dims = dims1;
            dims1 = dims2;
            dims2 = dims;
        }
        Map<Integer, Integer> mapV1 = new HashMap<Integer, Integer>();
        for (int i = 0; i < dims1.length; i++) {
            Dimension dim = dims1[i];
            mapV1.put(dim.getId(), dim.getValue());
        }
        double d = 0.0;
        for (int i = 0; i < dims2.length; i++) {
            Dimension dim2 = dims2[i];
            int value2 = dim2.getValue();
            int value1 = mapV1.containsKey(dim2.getId()) ? mapV1.get(dim2.getId()) : 0;
            d += value1 * value2;
        }
        return d;
    }

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        // TODO add your handling code here:
        int selectRows = table.getSelectedRows().length;// 取得用户所选行的行数
        if (selectRows == 2) {
            int[] selRowIndexs = table.getSelectedRows();// 用户所选行的序列
            int index1 = selRowIndexs[0];
            int index2 = selRowIndexs[1];

            Cluster c1 = cm.getCluster(index1);
            Cluster c2 = cm.getCluster(index2);
            double sim = cosine(c1.getCentralPoint(), c2.getCentralPoint());
            DecimalFormat df = new DecimalFormat("######0.0000");
            this.simLabel.setText(df.format(sim));
            this.viewSimDialog.setVisible(true);
            this.viewSimDialog.setTitle("相似度计算结果");
        }
    }//GEN-LAST:event_checkButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.viewSimDialog.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void viewClusterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewClusterButtonActionPerformed
        // TODO add your handling code here:
        int selectRows = table.getSelectedRows().length;// 取得用户所选行的行数

        if (selectRows == 1) {
            int selRowIndex = table.getSelectedRows()[0];// 用户所选行的序列

            Cluster c = cm.getCluster(selRowIndex);
            List<String> samples = c.getSamples();
            this.sampleTextArea.setText("");
            for(String sample : samples) {
                this.sampleTextArea.append(sample + "\n");
            }
            this.sampleViewDialog.setTitle(c.getCentralPoint().getName());
        }

        int screenWidth = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        int screenHeight = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        int sizeWidth = this.sampleViewDialog.getWidth();
        int sizeHeight = this.sampleViewDialog.getHeight();
        this.setLocation((screenWidth - sizeWidth) / 2, (screenHeight - sizeHeight) / 2);
        this.sampleViewDialog.setVisible(true);
    }//GEN-LAST:event_viewClusterButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkButton;
    private javax.swing.JButton deleteClusterButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton mergeClusterButton;
    private javax.swing.JTextArea sampleTextArea;
    private javax.swing.JDialog sampleViewDialog;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel simLabel;
    private javax.swing.JTable table;
    private javax.swing.JButton viewClusterButton;
    private javax.swing.JDialog viewSimDialog;
    // End of variables declaration//GEN-END:variables
}
