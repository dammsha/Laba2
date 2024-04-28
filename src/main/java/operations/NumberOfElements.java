package operations;

import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;
import java.util.List;

public class NumberOfElements implements Operation{

    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<Integer> result = new ArrayList<>();

    public NumberOfElements(ArrayList<ArrayList<Double>> list) {
        this.list = list;
        this.name = "Количество элементов";
        calculate();
    }

    public void calculate() {
        for (int i = 0; i < list.size(); i++) {
            Integer size = list.get(i).size();
            result.add(size);
        }
    }

    @Override
    public ArrayList<Integer> getResult() {
        return result;
    }

    public String getName() {
        return name;
    }
}
