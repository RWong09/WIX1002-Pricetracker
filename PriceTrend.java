
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;                    
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.CategoryDataset;


public class PriceTrend extends javax.swing.JFrame {

    private CategoryDataset pricedata;

    /**
     * Creates new form PriceTrend
     */
    public PriceTrend() {
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

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Pricechart = new javax.swing.JPanel();
        dateTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(0, 255, 102));

        jButton1.setBackground(new java.awt.Color(204, 255, 153));
        jButton1.setText("Show Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Pricechart.setBackground(new java.awt.Color(51, 255, 255));
        Pricechart.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Price Trend", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Pricechart.setLayout(new javax.swing.BoxLayout(Pricechart, javax.swing.BoxLayout.LINE_AXIS));

        dateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Pricechart, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Pricechart, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       showChart();

    }//GEN-LAST:event_jButton1ActionPerformed
public void showChart() {
    String url = "jdbc:mysql://127.0.0.1:3306/csv";
    String user = "root";
    String password = "";

    DefaultCategoryDataset pricedata = new DefaultCategoryDataset();
    double min=9999,max=0,buffer=0.02;
    

    try (Connection sqlconnection = DriverManager.getConnection(url, user, password)) {
        int itemCode = 2;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateTextField.getText(), dateFormatter);

        String currentdate_price = "SELECT price FROM pricecatcher WHERE date=? AND item_code=?";
        String countItem = "SELECT COUNT(item_code) FROM pricecatcher WHERE date=? AND item_code=? ";

        try (PreparedStatement currentprice = sqlconnection.prepareStatement(currentdate_price);
             PreparedStatement count_Item = sqlconnection.prepareStatement(countItem)) {

            int loopCounter = 0;
            while (loopCounter < 29) {
                currentprice.setDate(1, java.sql.Date.valueOf(localDate));
                currentprice.setInt(2, itemCode);
                ResultSet currentPrice = currentprice.executeQuery();

                count_Item.setDate(1, java.sql.Date.valueOf(localDate));
                count_Item.setInt(2, itemCode);
                ResultSet CountItem = count_Item.executeQuery();

                int countitem = 0;
                if (CountItem.next()) {
                    countitem = CountItem.getInt(1);
                }
                System.out.println("countitem: " + countitem);

                double totalprice = 0;
                while (currentPrice.next()) {
                    double price = currentPrice.getDouble("price");
                    totalprice += price;
                }

                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                double avg = totalprice / countitem * 1.0;
                String AVG = decimalFormat.format(avg);
                double Avg = Double.parseDouble(AVG);
                if(Avg<min){
                min=Avg;
                }
                if(Avg>max){
                    max=Avg;
                }
                System.out.println(loopCounter+"round " + Avg);
                System.out.println("min"+min);
                System.out.println("max"+max);

                pricedata.addValue(Avg, "price for " + localDate, localDate.toString());
                localDate = localDate.plusDays(1);
                loopCounter++;
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    }

        JFreeChart jchart = ChartFactory.createBarChart("Price trend", "Date", "Price",  pricedata,
                PlotOrientation.HORIZONTAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setLowerBound(min-buffer);
        yAxis.setUpperBound(max+buffer);
        
        ChartPanel chartPanel = new ChartPanel(jchart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1170, 500));
        
//        ChartFrame chartFrm = new ChartFrame("pt", jchart, true);
//        chartFrm.setVisible(true);
//        chartFrm.setSize(500, 400);
//        JFrame frame = new JFrame("Price Trend Chart");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(chartPanel);
//        frame.pack();
//        frame.setVisible(true);
        
        
      Pricechart.removeAll();
      Pricechart.add(chartPanel);
      Pricechart.updateUI();
      Pricechart.revalidate();
      Pricechart.repaint();
}
    private void dateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTextFieldActionPerformed
        
    }//GEN-LAST:event_dateTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(PriceTrend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PriceTrend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PriceTrend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PriceTrend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PriceTrend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pricechart;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}