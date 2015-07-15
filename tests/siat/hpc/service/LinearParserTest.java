package siat.hpc.service;

import org.junit.Before;
import org.junit.Test;
import siat.hpc.domain.GeoSignal;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by ace <arthur4it@gmail.com> on 15, 07, 2015.
 */
public class LinearParserTest {
    LinearParser linearParser;
    SignalAnalyzer signalAnalyzer;
    int distance;


    @Before
    public void setUp() throws Exception {
        GeoSignalParser geoSignalParser = new GeoSignalParser("./resources/RandNum-100lines.txt");
        linearParser = new LinearParser(geoSignalParser);
        distance=1500;
        signalAnalyzer = new SignalAnalyzer(1, 1, 1, distance);
        linearParser.setExpectedPositiveRate(0.80);
    }

    @Test
    public void testLearnDistance() throws Exception {
        distance=linearParser.learnDistance(signalAnalyzer);
        System.out.println(distance);
        if (distance < 0) {
            throw new RuntimeException(" distance small than 0");
        }
        signalAnalyzer.setDistance(distance);
        ArrayList<GeoSignal> signals=new GeoSignalParser("./resources/RandNum-100lines.txt").getSignals();
        int total = signals.size();
        int positiveCount=0;
        for (GeoSignal s : signals) {
            if (signalAnalyzer.recogizeSign(s) > 0) {
                positiveCount += 1;
            }
        }
        System.out.println("true rate: "+1.0 * positiveCount / total);
    }
}