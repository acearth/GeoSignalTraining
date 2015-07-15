package siat.hpc.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ace <arthur4it@gmail.com> on 03, 07, 2015.
 */
public class GeoSignalTest {
    GeoSignal geoSignal ;
    @Before
    public void setUp() {
       geoSignal = new GeoSignal(1, 2, 3);

    }

    @Test
    public void testGeoSignal() {
        //assertEquals(new int[]{1,2,3},geoSignal.getSignal());
        assertEquals(1,geoSignal.getSignX());
        assertEquals(2,geoSignal.getSignY());
        assertEquals(3,geoSignal.getSignZ());

    }

}