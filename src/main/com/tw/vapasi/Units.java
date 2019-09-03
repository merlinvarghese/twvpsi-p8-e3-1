package com.tw.vapasi;

public enum Units {
    CM(1),
    M(100),
    KM(100000),
    GM(1),
    KG(1000);

    enum UnitType {
        LENGTH,
        WEIGHT;
    }

    private double conversionFactor;
    private UnitType type;

    Units(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    Units(double conversionFactor, UnitType type) {
        this.conversionFactor = conversionFactor;
        this.type = type;
    }

    double convertToBase(double value) {
        return value * this.conversionFactor;
    }

    boolean isUnitTypeSame(UnitType type) {
        return type == this.type;
    }
}

