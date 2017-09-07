package com.theriehldeal.object;

public class WordList {

    private double totalWords;
    private int minLength;
    private int maxLength;

    public WordList() {
        this.totalWords = 0;
        this.minLength = 0;
        this.maxLength = 0;
    }

    public WordList(int minLength, int maxLength) {
        this.totalWords = sigma(minLength, maxLength);
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public double getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(double totalWords) {
        this.totalWords = totalWords;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public double sigma(int minLength, int maxLength){
        double sum = 0;
        if (minLength == 1 && maxLength == 1){
            sum = 94;
        } else if (minLength != maxLength){
            for (int i = minLength; i <= maxLength; i++){
                if (i == 1){
                    sum = 94;
                }
                if (i == 2){
                    sum = 94 + Math.pow(94,2);
                }
                if(i > 2){
                    sum += Math.pow(94,2)*Math.pow(94, i-2);
                }

            }
        } else if(minLength == maxLength){
            sum = Math.pow(94,2)*Math.pow(94, minLength-2);
        }
        return sum;
    }
}
