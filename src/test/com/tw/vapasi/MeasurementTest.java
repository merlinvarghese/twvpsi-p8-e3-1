package com.tw.vapasi;

import org.junit.jupiter.api.*;

import static com.tw.vapasi.AddableMeasurement.*;
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

    @Nested
    class WeightTest {
        @Test
        void expectKG_To_CMAreNotEqual() {
            assertFalse(kg(1).equals(cms(1)));
        }

        @Test
        void expectKG_To_1000GMAreEqual() {
            assertTrue(kg(1).equals(gm(1000)));
        }
    }

    @Nested
    class LengthMeasurementOperations {
        @Test
        void expect300CMAsSumOf100CM_2M() throws Exception {
            AddableMeasurement obj = new AddableMeasurement(100,Unit.CM);
            assertEquals(cms(300), obj.add(ms(2)));
        }

        @Test
        void expect2pt2KGAsSumOf2KG_200GM() throws CannotAddException {
            AddableMeasurement obj = new AddableMeasurement(2.0,Unit.KG);
            assertEquals(kg(2.2), obj.add(gm(200.0)));
        }

        @Test
        void expectAnExceptionWhenAddingDifferentUnitType() {
            AddableMeasurement obj = new AddableMeasurement(100,Unit.CM);
            AddableMeasurement operand1 = AddableMeasurement.cms(100);
            AddableMeasurement operand2 = AddableMeasurement.gm(100);
            try {
                operand1.add(operand2);
                Assertions.fail("It has thrown an Exception");
            } catch (CannotAddException e) {
                e.printStackTrace();
            }
        }
    }

    @Nested
    class TemperatureMeasurementOperations {
        @Test
        void expect0DegCEquals32F() throws Exception {
            assertTrue(c(0).equals(f(32)));
        }

        @Test
        void expect0DegCEqualsMinus273K() throws CannotAddException {
            assertTrue(c(0).equals(k(273)));
        }
    }
}

