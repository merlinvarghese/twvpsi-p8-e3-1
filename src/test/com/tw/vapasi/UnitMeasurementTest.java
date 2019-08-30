package com.tw.vapasi;

import jdk.jfr.StackTrace;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class UnitMeasurementTest {

    @Test
    public void ExpectTrueForCM_To_M() {
        UnitMeasurement centiMeter100 = new UnitMeasurement(100, "cm");
        UnitMeasurement meter1 = new UnitMeasurement(1, "m");
        assertTrue(centiMeter100.equals(meter1));
    }

    @Test
    public void ExpectFalseForM_To_CM() {
        UnitMeasurement centiMeter100 = new UnitMeasurement(100, "cm");
        UnitMeasurement meter10 = new UnitMeasurement(10, "m");
        assertFalse(meter10.equals(centiMeter100));
    }

    @Test
    public void ExpectTrueForKM_To_M() {
        UnitMeasurement kiloMeter1 = new UnitMeasurement(1, "cm");
        UnitMeasurement meter1000 = new UnitMeasurement(1000, "m");
        assertFalse(kiloMeter1.equals(meter1000));
    }

    @Test
    public void ExpectFalseForKM_To_M() {
        UnitMeasurement kiloMeter100 = new UnitMeasurement(100, "cm");
        UnitMeasurement meter1000 = new UnitMeasurement(1000, "m");
        assertFalse(meter1000.equals(kiloMeter100));
    }


}
