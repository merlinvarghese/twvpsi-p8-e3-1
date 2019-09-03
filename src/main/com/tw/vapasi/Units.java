package com.tw.vapasi;

public enum Units {
    CM(1),
    M(100),
    KM(100000);
    private double conversionFactor;

    Units(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    double convertToBase(double value) {
        return value * this.conversionFactor;
    }
}

