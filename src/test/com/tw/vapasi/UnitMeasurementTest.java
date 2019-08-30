package com.tw.vapasi;

import jdk.jfr.StackTrace;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class UnitMeasurementTest {

    @Test

    public void ExpectTrueForConverterCM_To_M() {
        UnitMeasurement centiMeter100 = new UnitMeasurement(100,"cm");
        UnitMeasurement meter1= new UnitMeasurement(1,"m");
        assertTrue(centiMeter100.equals(meter1));
    }

    @Test
    public void ExpectTrueForConverterM_To_CM() {
        UnitMeasurement centiMeter100 = new UnitMeasurement(100,"cm");
        UnitMeasurement meter10= new UnitMeasurement(10,"m");
        assertFalse(meter10.equals(centiMeter100));
    }



}
