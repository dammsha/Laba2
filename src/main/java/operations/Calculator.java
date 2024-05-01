package operations;

import javax.swing.*;
import java.util.ArrayList;

public class Calculator {
    GeometricMean geometricMean;
    ArithmeticMean arithmeticMean;
    EstimateOfStandardDeviation estimateOfStandardDeviation;
    Spread spread;
    CoefficientsOfCovarianc coefficientsOfCovarianc;
    NumberOfElements numberOfElements;
    CoefficientOfVariation coefficientOfVariation;
    ConfidenceInterval confidenceInterval;
    EstimateOfTheVariance estimateOfTheVariance;
    Maximum maximum;
    Minimum minimum;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<ArrayList<?>> results = new ArrayList<>();
    ArrayList<Operation> operations = new ArrayList<>();

    public Calculator() {
    }

    public void start(ArrayList<ArrayList<Double>> d) {

        operations.add(geometricMean = new GeometricMean(d));
        operations.add(arithmeticMean = new ArithmeticMean(d));
        operations.add(estimateOfStandardDeviation = new EstimateOfStandardDeviation(d));
        operations.add(spread = new Spread(d));
        operations.add(numberOfElements = new NumberOfElements(d));
        operations.add(coefficientOfVariation = new CoefficientOfVariation(d));
        operations.add(confidenceInterval = new ConfidenceInterval(d));
        operations.add(estimateOfTheVariance = new EstimateOfTheVariance(d));
        operations.add(maximum = new Maximum(d));
        operations.add(minimum = new Minimum(d));
        coefficientsOfCovarianc = new CoefficientsOfCovarianc(d);

        for (Operation operation : operations) {
            System.out.println(operation.getResult());
        }
    }

    public ArrayList<String> fillNames() {
        try {
            for (Operation operation : operations) {
                names.add(operation.getName());
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "не были произведены рассчеты");
            throw new RuntimeException(e);
        }
        return names;
    }

    public ArrayList<ArrayList<?>> fillResults() {
        for (Operation operation : operations) {
            results.add(operation.getResult());
        }
        return results;
    }

    public ArrayList<ArrayList<Double>> getCovariation() {
        return coefficientsOfCovarianc.getResult();
    }

    public String getCovName() {return coefficientsOfCovarianc.getName();}

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<ArrayList<?>> getResults() {
        return results;
    }
}
