package siat.hpc.service;

import siat.hpc.domain.GeoSignal;

/**
 * Created by ace <arthur4it@gmail.com> on 03, 07, 2015.
 */
public class SignalAnalyzer {
    /**
     * plate model.  lx+my+nz=distance
     *
     */
   private int l,m,n, distance;

    public SignalAnalyzer(int k1, int k2, int k3, int distance) {
        l=k1;
        m=k2;
        n=k3;
        this.distance = distance;
    }

    public void setDistance(int d) {
        this.distance = d;
    }
    public int getDistance() {
        return distance;
    }

    public int recogizeSign(GeoSignal signal) {
        int sum=signal.getSignX()*l+
                signal.getSignY()*m+
                signal.getSignZ()*n;
        return sum - distance;
    }

}
