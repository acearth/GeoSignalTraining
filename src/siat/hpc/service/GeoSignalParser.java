package siat.hpc.service;

import siat.hpc.domain.GeoSignal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by ace <arthur4it@gmail.com> on 03, 07, 2015.
 */
public class GeoSignalParser {
    private BufferedReader reader;
    private ArrayList<GeoSignal> signals;

    public GeoSignalParser(String fileName) {
        signals = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public ArrayList getSignals() {
        if (signals.size() < 1) {
            GeoSignal signal;
            while ((signal = produceGeoSignal()) != null) {
                signals.add(signal);
            }
        }
        return signals;
    }

    public GeoSignal produceGeoSignal() {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                return createGeoSignal(line);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GeoSignal createGeoSignal(String line) {
        String words[] = line.split("\\s");
        int[] data = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            data[i] = Integer.parseInt(words[i]);
        }
        return new GeoSignal(data);


    }
}
