package siat.hpc.service;

import org.junit.Before;
import org.junit.Test;
import siat.hpc.domain.GeoSignal;
import siat.hpc.service.GeoSignalParser;
import siat.hpc.service.SignalAnalyzer;

import java.util.ArrayList;

/**
 * Created by ace <arthur4it@gmail.com> on 03, 07, 2015.
 */
public class SignalAnalyzerTest {
    SignalAnalyzer signalAnalyzer;
    ArrayList<GeoSignal> geoSignals;
    GeoSignalParser parser;



    @Before
    public void setUp() {
        signalAnalyzer = new SignalAnalyzer(1, 1, 1, 1300);
        parser = new GeoSignalParser("./resources/RandNum-100lines.txt");
        GeoSignal geoSignal;
        geoSignals = new ArrayList<>();
        while ((geoSignal = parser.produceGeoSignal()) != null) {
            geoSignals.add(geoSignal);
        }


    }

    @Test
    public void testSignalAnalyzerCanWork() {
        int totalCount=0;
        int positiveCount=0;
        double errorRate=0.1;

        for (GeoSignal signal : geoSignals) {
            totalCount++;
            System.out.print(signal + "\t");
            int result= signalAnalyzer.recogizeSign(signal);
            System.out.println(result>0);
            if (result > 0) {
                positiveCount++;
            }

        }
        double ratio = positiveCount*1.0 / totalCount;

        String t = "\t";
        System.out.println(positiveCount+t+totalCount+t+ratio);

    }


}