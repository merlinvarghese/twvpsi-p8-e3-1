package com.tw.vapasi;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

class UnitMeasurementTest {

    @Test
     void ExpectTrueForCM_To_M() {
        UnitMeasurement centiMeter100 = new UnitMeasurement(100, "cm");
        UnitMeasurement meter1 = new UnitMeasurement(1, "m");
        assertTrue(centiMeter100.equals(meter1));
    }

    @Test
     void ExpectFalseForM_To_CM() {
        UnitMeasurement centiMeter100 = new UnitMeasurement(100, "cm");
        UnitMeasurement meter10 = new UnitMeasurement(10, "m");
        assertFalse(meter10.equals(centiMeter100));
    }

    @Test
     void ExpectTrueForKM_To_M() {
        UnitMeasurement kiloMeter1 = new UnitMeasurement(1, "cm");
        UnitMeasurement meter1000 = new UnitMeasurement(1000, "m");
        assertFalse(kiloMeter1.equals(meter1000));
    }

    @Test
     void ExpectFalseForKM_To_M() {
        UnitMeasurement kiloMeter100 = new UnitMeasurement(100, "km");
        UnitMeasurement meter1000 = new UnitMeasurement(1000, "m");
        assertFalse(meter1000.equals(kiloMeter100));
    }

    @Test
    void ExpectTrueForCM_To_CM() {
        UnitMeasurement centiMeter100 = new UnitMeasurement(100, "cm");
        UnitMeasurement meter10 = new UnitMeasurement(10, "m");
        assertFalse(meter10.equals(centiMeter100));
    }

    @Test
    void ExpectTrueForKM_To_CM() {
        UnitMeasurement centiMeter10000 = new UnitMeasurement(10000, "cm");
        UnitMeasurement kilometer1 = new UnitMeasurement(1, "km");
        assertTrue(kilometer1.equals(centiMeter10000));
    }

    @Test
    void ExpectFalseForKM_To_CM() {
        UnitMeasurement centiMeter10000 = new UnitMeasurement(10000, "cm");
        UnitMeasurement kilometer100 = new UnitMeasurement(100, "km");
        assertFalse(kilometer100.equals(centiMeter10000));
    }

}
