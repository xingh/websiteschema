/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestingFrame.java
 *
 * Created on Jan 8, 2012, 2:00:03 PM
 */
package websiteschema.analyzer.browser.tools;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import websiteschema.analyzer.context.BrowserContext;
import websiteschema.cluster.analyzer.Link;
import websiteschema.crawler.Crawler;
import websiteschema.crawler.WebPage;
import websiteschema.crawler.browser.BrowserWebCrawler;
import websiteschema.crawler.fb.FBLinksExtractor;
import websiteschema.crawler.fb.bbs.FBForumList;
import websiteschema.crawler.htmlunit.HtmlUnitWebCrawler;
import websiteschema.persistence.rdbms.ChannelMapper;
import websiteschema.utils.StringUtil;

/**
 *
 * @author ray
 */
public class LinkTestFrame extends javax.swing.JFrame {

    BrowserContext context;
    String siteId;
    // 抽取的链接列表
    private List<Link> retLinks;

    /**
     * Creates new form TestingFrame
     */
    public LinkTestFrame() {
        initComponents();

        pagingNumberField.setEditable(pagingCheckBox.isSelected());

        int screenWidth = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        int screenHeight = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        int sizeWidth = this.getWidth();
        int sizeHeight = this.getHeight();
        this.setLocation((screenWidth - sizeWidth) / 2, (screenHeight - sizeHeight) / 2);

        this.resultArea.setLineWrap(this.wrapLineCheckBox.isSelected());
        this.setTitle("测试链接抽取");
        this.btnSaveToChannel.setEnabled(false);
    }

    public LinkTestFrame(BrowserContext context) {
        this.context = context;
        this.siteId = context.getSimpleBrowser().getAnalysisPanel().getSiteId();

        initComponents();
        int screenWidth = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        int screenHeight = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        int sizeWidth = this.getWidth();
        int sizeHeight = this.getHeight();
        this.setLocation((screenWidth - sizeWidth) / 2, (screenHeight - sizeHeight) / 2);

        this.resultArea.setLineWrap(this.wrapLineCheckBox.isSelected());
        this.setTitle("测试链接抽取");

        this.fidURl.setText(context.getBrowser().getURL());
        this.btnSaveToChannel.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        xpathField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        crawlerCombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        jToolBar2 = new javax.swing.JToolBar();
        btnSaveToChannel = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        jLabel4 = new javax.swing.JLabel();
        fidURl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        wrapLineCheckBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        pagingCheckBox = new javax.swing.JCheckBox();
        pagingNumberField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        jLabel3.setText("XPath: ");
        jToolBar1.add(jLabel3);
        jToolBar1.add(xpathField);

        jLabel1.setText("采集器:");
        jToolBar1.add(jLabel1);

        crawlerCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SimpleHTTPCrawler", "HtmlUnitWebCrawler", "BrowserWebCrawler" }));
        jToolBar1.add(crawlerCombo);

        resultArea.setColumns(20);
        resultArea.setRows(5);
        jScrollPane1.setViewportView(resultArea);

        jToolBar2.setRollover(true);

        btnSaveToChannel.setText("保存成为栏目");
        btnSaveToChannel.setFocusable(false);
        btnSaveToChannel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveToChannel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSaveToChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveToChannelActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSaveToChannel);

        jToolBar3.setRollover(true);

        jLabel4.setText("http://");
        jToolBar3.add(jLabel4);
        jToolBar3.add(fidURl);

        jLabel2.setText("换行:");
        jToolBar3.add(jLabel2);

        wrapLineCheckBox.setSelected(true);
        wrapLineCheckBox.setFocusable(false);
        wrapLineCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        wrapLineCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        wrapLineCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wrapLineCheckBoxActionPerformed(evt);
            }
        });
        jToolBar3.add(wrapLineCheckBox);

        jLabel5.setText("  分页:");
        jToolBar3.add(jLabel5);

        pagingCheckBox.setFocusable(false);
        pagingCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pagingCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pagingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagingCheckBoxActionPerformed(evt);
            }
        });
        jToolBar3.add(pagingCheckBox);

        pagingNumberField.setEditable(false);
        pagingNumberField.setText("10");
        pagingNumberField.setToolTipText("最多翻多少页");
        pagingNumberField.setMaximumSize(new java.awt.Dimension(80, 2147483647));
        pagingNumberField.setMinimumSize(new java.awt.Dimension(50, 19));
        jToolBar3.add(pagingNumberField);

        jLabel6.setText("页");
        jToolBar3.add(jLabel6);

        startButton.setText("开始");
        startButton.setFocusable(false);
        startButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        startButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(startButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        new Thread(new FooThread()).start();
    }//GEN-LAST:event_startButtonActionPerformed

    private void wrapLineCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wrapLineCheckBoxActionPerformed
        // TODO add your handling code here:
        this.resultArea.setLineWrap(this.wrapLineCheckBox.isSelected());
        this.resultArea.updateUI();
    }//GEN-LAST:event_wrapLineCheckBoxActionPerformed

    private void btnSaveToChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveToChannelActionPerformed
        // TODO add your handling code here:
        ChannelMapper channelMapper = BrowserContext.getSpringContext().getBean("channelMapper", ChannelMapper.class);
        if (StringUtil.isNotEmpty(siteId)) {
            FBForumList.saveLinks(retLinks, siteId, channelMapper);
            JOptionPane.showMessageDialog(this, "保存完成");
            this.btnSaveToChannel.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "没有输入 Site ID");
        }
    }//GEN-LAST:event_btnSaveToChannelActionPerformed

    private void pagingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagingCheckBoxActionPerformed
        // TODO add your handling code here:
        pagingNumberField.setEditable(pagingCheckBox.isSelected());
    }//GEN-LAST:event_pagingCheckBoxActionPerformed

    private String getCrawler() {
        return this.crawlerCombo.getSelectedItem().toString();
    }

    public BrowserContext getContext() {
        return context;
    }

    public void setContext(BrowserContext context) {
        this.context = context;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    private String getXPath() {
        String xpath = this.xpathField.getText();
        return null != xpath && !"".equals(xpath) ? xpath : null;
    }

    class FooThread implements Runnable {

        @Override
        public void run() {
            start();
        }
    };

    private WebPage crawl(String url) {
        if (null != url) {
            this.setTitle("测试抽取: " + url);
            context.getConsole().log("开始采集：" + url);
            this.resultArea.setText("开始采集：" + url + "\n");
            Crawler crawler = null;
            // SimpleHTTPCrawler HtmlUnitWebCrawler BrowserWebCrawler
            if ("HtmlUnitWebCrawler".equals(getCrawler())) {
                HtmlUnitWebCrawler huwc = new HtmlUnitWebCrawler();
                huwc.setJavaScriptEnabled(true);
                crawler = huwc;
            } else if ("BrowserWebCrawler".equals(getCrawler())) {
                BrowserWebCrawler bwc = new BrowserWebCrawler();
                bwc.setAllowPopupWindow(false);
                crawler = bwc;
            } else {
                crawler = new websiteschema.crawler.SimpleHttpCrawler();
            }
            String userAgent = BrowserContext.getConfigure().getProperty("Browser", "User-Agent");
            if (null != userAgent) {
                crawler.addHeader("User-Agent", userAgent);
            }
            long t1 = System.currentTimeMillis();
            WebPage page = crawler.crawlWebPage(url);
            long t2 = System.currentTimeMillis();
            context.getConsole().log("采集结束，耗时：" + (t2 - t1));
            this.resultArea.append("采集结束，耗时：" + (t2 - t1) + "\n");
            return page;
        } else {
            return null;
        }
    }

    private void start() {
        this.startButton.setEnabled(false);
        this.btnSaveToChannel.setEnabled(false);
        try {
            //获取要采集的URL
            String url = fidURl.getText().trim();
            WebPage page = crawl(url);
            if (null != page) {
                retLinks = getLinks(page);
                //对结果进行输出
                if (null != retLinks && !retLinks.isEmpty()) {
                    resultArea.setText("");
                    for (Link lnk : retLinks) {
                        resultArea.append(lnk.getText() + " -> " + lnk.getHref());
                        resultArea.append("\n");
                    }
                    this.btnSaveToChannel.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "无法抽取出链接！");
                }
            } else {
                JOptionPane.showMessageDialog(this, "抽取页面异常");
            }
        } finally {
            this.startButton.setEnabled(true);
        }
    }

    private List<Link> getLinks(WebPage page) {
        FBLinksExtractor ext = new FBLinksExtractor();
        ext.page = page;
        if (pagingCheckBox.isSelected()) {
            ext.maxPagingNumber = this.getMaxPagingNumber();
        }
        ext.xpath = getXPath();
        ext.url = page.getUrl();
        ext.extract();
        return ext.links;
    }

    private int getMaxPagingNumber() {
        String str = pagingNumberField.getText();
        return Integer.parseInt(str);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveToChannel;
    private javax.swing.JComboBox crawlerCombo;
    private javax.swing.JTextField fidURl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JCheckBox pagingCheckBox;
    private javax.swing.JTextField pagingNumberField;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JButton startButton;
    private javax.swing.JCheckBox wrapLineCheckBox;
    private javax.swing.JTextField xpathField;
    // End of variables declaration//GEN-END:variables
}
