package loginregister;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.CategoryDataset;
import com.raven.datechooser.DateChooser;
//import com.formdev.flatlaf.FlatIntelliJLaf;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.text.SimpleDateFormat;

public class PriceTrend extends javax.swing.JFrame {

    private CategoryDataset pricedata;
    private DateChooser Pricedays = new DateChooser();
    public String item;
    public String unit;
    public int itemcode;
    public String Username;

    PriceTrend(int itemcode, String item, String unit, String Username) {
        initComponents();
        this.item = item;
        this.unit = unit;
        this.itemcode = itemcode;
        this.Username = Username;
        Pricedays.setTextField(Startingdate);
        Pricedays.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        Pricedays.setSelectedDateBetween(1, 8, 2023, 29, 8, 2023);
        Pricedays.setLabelCurrentDayVisible(false);
        Pricedays.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween date, DateChooserAction action) {
                SimpleDateFormat FormatY = new SimpleDateFormat("yyyy-MM-dd");
                String Firstday = FormatY.format(date.getFromDate());
                String Lastday = FormatY.format(date.getToDate());
                showChart(Firstday, Lastday, itemcode);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Pricechart = new javax.swing.JPanel();
        Startingdate = new javax.swing.JTextField();
        DATE = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        Pricechart.setBackground(new java.awt.Color(255, 255, 255));
        Pricechart.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Price Trend", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Pricechart.setLayout(new javax.swing.BoxLayout(Pricechart, javax.swing.BoxLayout.LINE_AXIS));

        Startingdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 153), new java.awt.Color(153, 255, 51), null, null));

        DATE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DATE.setForeground(new java.awt.Color(255, 255, 255));
        DATE.setText("Date:");

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(DATE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Startingdate, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Pricechart, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Startingdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DATE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(Pricechart, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(Back)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void showChart(String Firstday, String Lastday, int itemcode) {
        String url = "jdbc:mysql://127.0.0.1:3306/pricetracker";
        String user = "root";
        String password = "";

        DefaultCategoryDataset pricedata = new DefaultCategoryDataset();
        double min = 9999, max = 0, buffer = 0.02;

        try (Connection sqlconnection = DriverManager.getConnection(url, user, password)) {

            String avgquery = "SELECT date, ROUND(AVG(price), 2) AS avg "
                    + "FROM pricecatcher "
                    + "WHERE date BETWEEN ? AND ? "
                    + "AND item_code = ? "
                    + "GROUP BY date;";

            try (PreparedStatement AVG = sqlconnection.prepareStatement(avgquery)) {
                AVG.setInt(3, itemcode); // Set item code once outside the loop
                AVG.setString(1, Firstday);
                AVG.setString(2, Lastday);

                try (ResultSet Avg = AVG.executeQuery()) {
                    while (Avg.next()) {
                        double avg = Avg.getDouble("avg");
                        String date = Avg.getString("date");

                        System.out.println(date + " avg:" + avg);

                        if (avg < min) {
                            min = avg;
                            System.out.println("min:" + min);
                        }
                        if (avg > max) {
                            max = avg;
                            System.out.println("max:" + max);
                        }
                        pricedata.addValue(avg, "price for " + date, date);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart jchart = ChartFactory.createBarChart("Price trend", "Date", "Price", pricedata,
                PlotOrientation.HORIZONTAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setLowerBound(min - buffer);
        yAxis.setUpperBound(max + buffer);

        ChartPanel chartPanel = new ChartPanel(jchart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1170, 500));

        Pricechart.removeAll();
        Pricechart.add(chartPanel);
        Pricechart.updateUI();
        Pricechart.revalidate();
        Pricechart.repaint();
    }
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        UserItem Use = new UserItem(this.item,this.unit,this.Username);
        Use.setVisible(true);
        Use.pack();
        Use.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel DATE;
    private javax.swing.JPanel Pricechart;
    private javax.swing.JTextField Startingdate;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
