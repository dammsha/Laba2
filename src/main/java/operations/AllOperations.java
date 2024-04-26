package operations;

import java.util.ArrayList;
import java.util.Objects;

public class AllOperations {
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

    public AllOperations() {
//        this.names = fillNames();
//        this.results = fillResults();
    }

    public void start(ArrayList<ArrayList<Double>> d) {

        geometricMean = new GeometricMean(d);
        arithmeticMean = new ArithmeticMean(d);
        estimateOfStandardDeviation = new EstimateOfStandardDeviation(d);
        spread = new Spread(d);
        numberOfElements = new NumberOfElements(d);
        coefficientOfVariation = new CoefficientOfVariation(d);
        confidenceInterval = new ConfidenceInterval(d);
        estimateOfTheVariance = new EstimateOfTheVariance(d);
        maximum = new Maximum(d);
        minimum = new Minimum(d);
        coefficientsOfCovarianc = new CoefficientsOfCovarianc(d);

        System.out.println(geometricMean.getResult());
        System.out.println(arithmeticMean.getResult());
        System.out.println(estimateOfStandardDeviation.getResult());
        System.out.println(spread.getResult());
        System.out.println(numberOfElements.getResult());
        System.out.println(coefficientOfVariation.getResult());
        System.out.println(confidenceInterval.getResult());
        System.out.println(estimateOfTheVariance.getResult());
        System.out.println(maximum.getResult());
        System.out.println(minimum.getResult());
        System.out.println(coefficientsOfCovarianc.getResult());
        System.out.println("\n");
    }

    public ArrayList<String> fillNames() {
        names.add(geometricMean.getName());
        names.add(arithmeticMean.getName());
        names.add(estimateOfStandardDeviation.getName());
        names.add(spread.getName());
        names.add(numberOfElements.getName());
        names.add(coefficientOfVariation.getName());
        names.add(confidenceInterval.getName());
        names.add(estimateOfTheVariance.getName());
        names.add(maximum.getName());
        names.add(minimum.getName());

        return names;
    }

    public ArrayList<ArrayList<?>> fillResults() {
        results.add(geometricMean.getResult());
        results.add(arithmeticMean.getResult());
        results.add(estimateOfStandardDeviation.getResult());
        results.add(spread.getResult());
        results.add(numberOfElements.getResult());
        results.add(coefficientOfVariation.getResult());
        results.add(confidenceInterval.getResult());
        results.add(estimateOfTheVariance.getResult());
        results.add(maximum.getResult());
        results.add(minimum.getResult());
        return results;
    }

    public ArrayList<ArrayList<Double>> getCovariation() {
        return coefficientsOfCovarianc.covarianceMatrix;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<ArrayList<?>> getResults() {
        return results;
    }
}
