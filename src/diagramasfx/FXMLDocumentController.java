/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagramasfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author felipegadeallopis
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private NumberAxis ejeY;
    @FXML
    private CategoryAxis ejeX;
    final int NBRACKETS = 10;
    int hist[] = new int[NBRACKETS];
    @FXML
    private LineChart<String, Number> gráficoLinea;
    @FXML
    private BarChart<String, Number> gráficoBarras;
    @FXML
    private PieChart gráficoTarta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Gráfico 1
        for (int i = 0; i < hist.length; i++) {
          hist[i] = 0;
        }
        for (int j = 0; j < 1000; j++) {
          double value = Math.random() * NBRACKETS;
          hist[(int) value]++;
        }
        XYChart.Series<String,Number> series = new XYChart.Series(); for (int i = 0; i < hist.length; i++)
        series.getData().add(new XYChart.Data<>(i + "-" + (i+1), hist[i]));
        series.setName("Histogram");
        gráficoLinea.getData().add(series);
        //Gráfico 3
        ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList( 
                    new PieChart.Data("Limones", 13), 
                    new PieChart.Data("Limones 4k", 25), 
                    new PieChart.Data("Naranjas 8k", 10),
                    new PieChart.Data("Rubiuses", 22),
                    new PieChart.Data("Manzanas 2k", 30));
        gráficoTarta.setData(pieChartData);
        gráficoTarta.setTitle("Importaciones de Fruta");
        //Gráfico 2
        XYChart.Series series1 = new XYChart.Series(); series1.setName("2003");
        series1.getData().add(new XYChart.Data("España", 25601.34));
        XYChart.Series series2 = new XYChart.Series(); series2.setName("2004");
        series2.getData().add(new XYChart.Data("España", 57401.85));
        XYChart.Series series3 = new XYChart.Series(); series3.setName("2005");
        series3.getData().add(new XYChart.Data("España", 45000.65));
        XYChart.Series series4 = new XYChart.Series(); series4.setName("2006");
        series4.getData().add(new XYChart.Data("España", 40000.65));
        XYChart.Series series5 = new XYChart.Series(); series5.setName("2007");
        series5.getData().add(new XYChart.Data("España", 60000.70));
        XYChart.Series series6 = new XYChart.Series(); series6.setName("2008");
        series6.getData().add(new XYChart.Data("España", 10345.67));
        XYChart.Series series7 = new XYChart.Series(); series7.setName("2009");
        series7.getData().add(new XYChart.Data("España", 30450.78));
        XYChart.Series series8 = new XYChart.Series(); series8.setName("2010");
        series8.getData().add(new XYChart.Data("España", 49765.65));
        gráficoBarras.getData().addAll(series1, series2, series3, series4, series5,series6,series7, series8);
    }    

    
    
}
