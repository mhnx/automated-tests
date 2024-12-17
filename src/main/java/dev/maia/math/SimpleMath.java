package dev.maia.math;

public class SimpleMath {

    public Double sum(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    public Double subtract(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    public Double multiply(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    public Double divide(Double firstNumber, Double secondNumber) {
        if (secondNumber.equals(0.0)) throw new ArithmeticException("Dividing by zero is impossíble!");
        return firstNumber / secondNumber;
    }

    public Double average(Double firstNumber, Double secondNumber) {
        return (firstNumber + secondNumber) / 2;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}
