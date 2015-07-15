package siat.hpc.service;

import siat.hpc.domain.GeoSignal;

import java.util.ArrayList;

/**
 * Created by ace <arthur4it@gmail.com> on 15, 07, 2015.
 */
public class LinearParser {
    double expectedErrorRate = 0.10;
    double expectedPositiveRate = 0.60;
    ArrayList<GeoSignal> signals;

    public LinearParser(GeoSignalParser signalParser) {
        super();
        this.signals = signalParser.getSignals();
    }

    public int learnDistance(SignalAnalyzer signalAnalyzer) {
        int totalCount = signals.size();
        int positiveCount = 0;
        Boolean isPositive;
        for (GeoSignal s : signals) {
            isPositive = signalAnalyzer.recogizeSign(s) > 0;
            if (isPositive) {
                positiveCount++;
            }
        }
        double errorRate = positiveCount * 1.0 / totalCount - expectedPositiveRate;
        if (Math.abs(errorRate) < expectedErrorRate) {
            return signalAnalyzer.getDistance();
        } else {
            int d = signalAnalyzer.getDistance();
            d = (int) (d + errorRate * 0.5 * d);
            if (d > 3000 || d < 1) {
                return -1;
            }
            signalAnalyzer.setDistance(d);
            return learnDistance(signalAnalyzer);
        }
    }
    public double getExpectedPositiveRate() {
        return expectedPositiveRate;
    }

    public void setExpectedPositiveRate(double expectedPositiveRate) {
        this.expectedPositiveRate = expectedPositiveRate;
    }

    public ArrayList<GeoSignal> getSignals() {
        return signals;
    }

    public void setSignals(ArrayList<GeoSignal> signals) {
        this.signals = signals;
    }

}
