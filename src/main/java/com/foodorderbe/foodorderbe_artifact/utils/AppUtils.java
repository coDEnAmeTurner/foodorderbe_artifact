package com.foodorderbe.foodorderbe_artifact.utils;

public class AppUtils {
    public static boolean floatEqual(float f1, float f2) {
        float epsilon = 0.000001f;
        if (Math.abs(f1 - f2) < epsilon) {
            return true;
        }
        return false;
    }
}
