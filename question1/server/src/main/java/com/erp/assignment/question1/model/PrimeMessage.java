package com.erp.assignment.question1.model;

import java.util.List;

public class PrimeMessage {
    Integer upperBound;
    Integer count;
    List<Integer> primeNumbers;

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public PrimeMessage() {
    }
    public PrimeMessage(Integer upperBound,Integer count, List<Integer> primeNumbers) {
        this.upperBound = upperBound;
        this.count = count;
        this.primeNumbers = primeNumbers;
    }
    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }

    public void setPrimeNumbers(List<Integer> primeNumbers) {
        this.primeNumbers = primeNumbers;
    }

    public Integer getUpperBound() {
        return upperBound;
    }
    public void setUpperBound(Integer upperBound) {
        this.upperBound = upperBound;
    }
}
