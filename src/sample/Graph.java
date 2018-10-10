package sample;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Graph extends JPanel {

    float[] scores;
    int size;
    public Graph() {
        setSize(500, 500);
    }

    @Override
    public void paintComponent(Graphics g) {


        float y1;

        for (int i = 0; i < size - 1; i++) {
            y1 = (scores[i]) * 10;
            int b = (int) y1;
            g.drawLine(i * 10, b);
        }
    }
}