package com.tw.vapasi;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.tw.vapasi.Measurement.cms;
import static com.tw.vapasi.Measurement.ms;
import static com.tw.vapasi.Measurement.kms;
import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
    @Nested
    class BaseEqualsTest {
        @Test
        void expect100CmsAnd100CmsAreEqual() {
            assertEquals(cms(100), cms(100));
        }

        @Test
        void expect100CmsAndNullNotEqual() {
            assertNotEquals(cms(100), null);
        }

        @Test
        void expect100CmsAndAnotherObjectOfDifferentTypeAreNotEqual() {
            assertNotEquals(cms(100), new String());
        }
    }

    @Nested
    class LengthTest {
        @Test
        void expectTrueForCM_To_M() {
            assertTrue(cms(100.0).equals(ms(1.0)));
        }

        @Test
        void expectFalseForM_To_CM() {
            assertFalse(ms(10.0).equals(cms(100)));
        }

        @Test
        void expectTrueForKM_To_M() {
            assertFalse(kms(2).equals(ms(1000)));
        }

        @Test
        void expectFalseForKM_To_M() {
            assertFalse(ms(100).equals(ms(1000)));
        }

        @Test
        void expectTrueForCM_To_CM() {
            assertFalse(ms(10).equals(cms(100)));
        }

        @Test
        void expectTrueForKM_To_CM() {
            assertTrue(kms(1).equals(cms(100000)));
        }

        @Test
        void expectFalseForKM_To_CM() {
            assertFalse(kms(100).equals(cms(10000)));
        }
    }
}
