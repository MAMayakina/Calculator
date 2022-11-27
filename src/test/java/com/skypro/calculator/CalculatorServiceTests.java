package com.skypro.calculator;

import com.skypro.calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiceTests {
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("plusTestValues")
    public void plusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("minusTestValues")
    public void minusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("multiplyTestValues")
    public void multiplyTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("divideTestValues")
    public void divideTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.divide(num1, num2));
    }

    @Test
    public void divideZeroTest() {
        Assertions.assertThrows(ArithmeticException.class, () ->{
            calculatorService.divide(1, 0);
        });
    }

    public static List<Arguments> plusTestValues() {
        return List.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 0, 2),
                Arguments.of(0, 4, 4)
        );
    }

    public static List<Arguments> minusTestValues() {
        return List.of(
                Arguments.of(1, 2, -1),
                Arguments.of(2, 0, 2),
                Arguments.of(0, 4, -4)
        );
    }

    public static List<Arguments> multiplyTestValues() {
        return List.of(
                Arguments.of(1, 2, 2),
                Arguments.of(2, 0, 0),
                Arguments.of(0, 4, 0)
        );
    }

    public static List<Arguments> divideTestValues() {
        return List.of(
                Arguments.of(1, 2, 1 / 2),
                Arguments.of(8, 2, 4),
                Arguments.of(0, 4, 0)
        );
    }

}
