package operations;

import org.apache.commons.math3.stat.correlation.Covariance;

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
                row.add(covariance.covariance(innerList1.stream().mapToDouble(Double::doubleValue).toArray(), innerList2.stream().mapToDouble(Double::doubleValue).toArray()));
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
