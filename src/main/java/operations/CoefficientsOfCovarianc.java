package operations;

import org.apache.commons.math3.stat.correlation.Covariance;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CoefficientsOfCovarianc implements Operation {
    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<ArrayList<Double>> covarianceMatrix = new ArrayList<>();

    public CoefficientsOfCovarianc(ArrayList<ArrayList<Double>> list) {
        this.list = list;
        this.name = "Коэффициент ковариации";
        calculate();
    }
    public void calculate() {
        Covariance covariance = new Covariance();
        for (ArrayList<Double> innerList1 : list) {
            ArrayList<Double> row = new ArrayList<>();
            for (ArrayList<Double> innerList2 : list) {
                System.out.println(innerList1.size() + " " + innerList2.size());
                if (innerList1.size() == innerList2.size()) {
                    row.add(covariance.covariance(innerList1.stream().mapToDouble(Double::doubleValue).toArray(), innerList2.stream().mapToDouble(Double::doubleValue).toArray()));
                } else {
                    JOptionPane.showMessageDialog(null,"Невозможно вывести матрицу коэффициентов ковариации");}
            }
            covarianceMatrix.add(row);
        }
    }

    @Override
    public ArrayList<ArrayList<Double>> getResult() {
        return covarianceMatrix;
    }

    public String getName() {
        return name;
    }
}
