package com.erp.assignment.question1.primeUtils;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieveUtil {
    public static Integer MAX_INT_REQUEST = 10000000; // 10M
    // given an upperBound, returns the list of all prime numbers
    // up to that given upperBound
    public static List<Integer> runEratosthenesSieve(int upperBound) {
        List<Integer> results = new ArrayList<>();
        if (upperBound<2) return results;
        int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
        boolean[] isComposite = new boolean[upperBound + 1];
        for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (!isComposite[m]) {
                results.add(m);
                for (int k = m * m; k <= upperBound; k += m)
                    isComposite[k] = true;
            }
        }
        int start = upperBoundSquareRoot <= 2 ? upperBoundSquareRoot + 1 : upperBoundSquareRoot;
        for (int m = start; m <= upperBound; m++)
            if (!isComposite[m]) {
                results.add(m);
            }
        return results;
    }
}
