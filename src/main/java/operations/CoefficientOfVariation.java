package operations;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;
import java.util.List;

public class CoefficientOfVariation implements Operation{
    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<Double> result = new ArrayList<>();

    public CoefficientOfVariation(ArrayList<ArrayList<Double>> list) {
        this.list = list;
        this.name = "Коэффициент вариации";
        calculate();
    }

    public void calculate() {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).forEach(stats::addValue);
            result.add(stats.getStandardDeviation() / stats.getMean());
        }
    }

    @Override
    public ArrayList<Double> getResult() {
        return result;
    }

    public String getName() {
        return name;
    }
}
