package com.weihua.leetcode;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RectangleArea {
    public static void main(String[] args) {
        RectangleArea tester = new RectangleArea();
        System.out.println(tester.computeArea(-3, -3, 3, 3, -5, -5, 0, -4));
    }

    public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l = min(max(A, E), C);
        int r = min(max(A, G), C);
        int t = min(max(B, H), D);
        int b = min(max(B, F), D);
        return (C-A)*(D-B) + (G-E)*(H-F) - (r-l)*(t-b);
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // compute area 1
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        if (!isOverlapped(A, B, C, D, E, F, G, H)) {
            return area1 + area2;
        }

        int[] xValues = new int[4];
        xValues[0] = A;
        xValues[1] = C;
        xValues[2] = E;
        xValues[3] = G;
        Arrays.sort(xValues);
        int leftX = xValues[1];
        int rightX = xValues[2];

        int[] yValues = new int[4];
        yValues[0] = B;
        yValues[1] = D;
        yValues[2] = F;
        yValues[3] = H;
        Arrays.sort(yValues);
        int lowerY = yValues[1];
        int higherY = yValues[2];

        int crossArea = 0;
        if (rightX - leftX > 0 && higherY - lowerY > 0) {
            crossArea = (rightX - leftX) * (higherY - lowerY);
        }

        return area1 + area2 - crossArea;
    }

    private boolean isOverlapped(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C < E || G < A) {
            return false;
        }

        if (B > H || F > D) {
            return false;
        }

        return true;
    }
}
