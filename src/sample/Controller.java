package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    private double sol[];

    @FXML
    public TextField x0;

    @FXML
    public TextField y0;

    @FXML
    public TextField dx;

    @FXML
    public TextField xmax;

    @FXML
    public TextArea result;

    @FXML
    public Button resultButton;

    private int numberOfPoint;

    //defining the axes
    @FXML
    public NumberAxis xAxis;
    @FXML
    public NumberAxis yAxis;

    //creating the chart
    @FXML
    public LineChart<Number,Number> lineChart;


    public Controller() {
    }

    public void calcResult(ActionEvent e) {
        this.numberOfPoint = (int)(Float.parseFloat(xmax.getText())/Float.parseFloat(dx.getText()));
        this.sol = new double[numberOfPoint];
        StringBuilder stringBuilder = new StringBuilder();

        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < numberOfPoint - 1; i++ ) {
            sol[i+1] = sol[i] + fun(i)* Double.parseDouble(dx.getText());
            series.getData().add(new XYChart.Data(i, sol[i+1]));
            stringBuilder.append("sol[i+1]: ").append(sol[i+1]).append("\n");
        }

        lineChart.getData().add(series);

        this.result.setText(stringBuilder.toString());
    }

    double fun(int x){
        return 0.5 *x;
    }

}
