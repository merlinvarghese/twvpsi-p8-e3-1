package com.tw.vapasi;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static com.tw.vapasi.UnitMeasurement.cms;
import static com.tw.vapasi.UnitMeasurement.ms;
import static com.tw.vapasi.UnitMeasurement.kms;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


class UnitMeasurementTest {

    @Test
    void ExpectTrueForCM_To_M() {
        assertTrue(cms(100.0).equals(ms(1.0)));
    }

    @Test
    void ExpectFalseForM_To_CM() {
        assertFalse(ms(10.0).equals(cms(100)));
    }

    @Test
    void ExpectTrueForKM_To_M() {
        assertFalse(kms(2).equals(ms(1000)));
    }

    @Test
    void ExpectFalseForKM_To_M() {
        assertFalse(ms(100).equals(ms(1000)));
    }

    @Test
    void ExpectTrueForCM_To_CM() {
        assertFalse(ms(10).equals(cms(100)));
    }

    @Test
    void ExpectTrueForKM_To_CM() {
        assertTrue(kms(1).equals(cms(100000)));
    }

    @Test
    void ExpectFalseForKM_To_CM() {
        assertFalse(kms(100).equals(cms(10000)));
    }

}
