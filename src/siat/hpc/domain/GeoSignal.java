package siat.hpc.domain;

/**
 * Created by ace <arthur4it@gmail.com> on 03, 07, 2015.
 */
public class GeoSignal {
    private int signX;

    public void setLabel(int label) {
        this.label = label;
    }

    public int getSignX() {
        return signX;
    }

    public void setSignX(int signX) {
        this.signX = signX;
    }

    public int getSignY() {
        return signY;
    }

    public void setSignY(int signY) {
        this.signY = signY;
    }

    public int getSignZ() {
        return signZ;
    }

    public void setSignZ(int signZ) {
        this.signZ = signZ;
    }

    private int signY;
    private int signZ;
    private int label;

    public GeoSignal(int[] geoSignal) {
        this.signX = geoSignal[0];
        this.signY = geoSignal[1];
        this.signZ = geoSignal[2];

    }

    public GeoSignal(int signX, int signY, int signZ) {
        this.signX = signX;
        this.signY = signY;
        this.signZ = signZ;
    }

    public String toString() {
        String t = "\t";
        return signX + t +
                signY + t +
                signZ;
    }

    public int getLabel() {
        return label;
    }

    public int[] getSignal() {
        return new int[]{signX, signY, signZ};
    }


}

