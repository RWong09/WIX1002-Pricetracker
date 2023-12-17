
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Tsrdd extends javax.swing.JFrame {

    private JTextField dateTextField;
    private JTextField itemCodeTextField;
    private JPanel chartPanel;

    public Tsrdd() {
        initComponents();
        init();
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {

        JPanel jPanel = new JPanel();
        JLabel dateLabel = new JLabel("Date:");
        dateTextField = new JTextField(10);
        JLabel itemCodeLabel = new JLabel("Item Code:");
        itemCodeTextField = new JTextField(5);
        JButton showChartButton = new JButton("Show Chart");
        chartPanel = new JPanel();

        showChartButton.addActionListener(this::showChartButtonActionPerformed);

        jPanel.add(dateLabel);
        jPanel.add(dateTextField);
        jPanel.add(itemCodeLabel);
        jPanel.add(itemCodeTextField);
        jPanel.add(showChartButton);

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));
        getContentPane().add(jPanel);
        getContentPane().add(chartPanel);

        pack();
    }

    private void showChartButtonActionPerformed(ActionEvent e) {
        String url = "jdbc:mysql://127.0.0.1:3306/csv";
        String user = "root";
        String password = "";
        try (Connection sqlconnection = DriverManager.getConnection(url, user, password)){
            String dateInput = dateTextField.getText();
            int itemCode = Integer.parseInt(itemCodeTextField.getText());
            

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dateInput, dateFormatter);
            DefaultCategoryDataset ded = new DefaultCategoryDataset();
            for (int i = 0; i < 3; i++) {
                String currentdate_price = "SELECT price FROM pricecatcher WHERE date=? AND item_code=?";
                PreparedStatement currentprice = sqlconnection.prepareStatement(currentdate_price);
                currentprice.setDate(1, java.sql.Date.valueOf(localDate));
                currentprice.setInt(2, itemCode);
                ResultSet currentPrice = currentprice.executeQuery();
                
                String countItem = "SELECT COUNT(item_code) FROM pricecatcher WHERE date=? AND item_code=? ";
                PreparedStatement count_Item = sqlconnection.prepareStatement(countItem);
                count_Item.setDate(1, java.sql.Date.valueOf(localDate));
                count_Item.setInt(2, itemCode);
                ResultSet CountItem =count_Item.executeQuery();
                 int countitem=0;
                if (CountItem.next()) {
                     countitem = CountItem.getInt(1);}
                double totalprice=0;
                while (currentPrice.next()) {
                    double price = currentPrice.getDouble("price");
                    totalprice+=price;

                }
                double avg=totalprice/countitem*1.0;
                ded.setValue(avg, localDate.toString(), "price for" + localDate);
                localDate = localDate.plusDays(1);
            }

            JFreeChart jchart = ChartFactory.createBarChart("Price trend", "Item", "Price", ded,
                    PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.black);

            ChartFrame chartFrame = new ChartFrame("Price trend", jchart, true);
            chartFrame.setVisible(true);
            chartFrame.setSize(1500, 800);

            ChartPanel TsrddPanel = new ChartPanel(jchart);
            this.chartPanel.removeAll();
            this.chartPanel.add(TsrddPanel);
            

}       catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Tsrdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tsrdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tsrdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tsrdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Tsrdd tsrdd = new Tsrdd();
            tsrdd.initComponents();
            tsrdd.setVisible(true);
        });
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

