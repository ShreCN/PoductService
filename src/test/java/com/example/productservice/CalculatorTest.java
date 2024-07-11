package com.example.productservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void test_whenAddTwoNumber_ReturnSum() {
        // Arrange or Create
        int a = 1, b = 2;
        Calculator calculator = new Calculator();

        // Act or Call
        int result = calculator.addition(a, b);

        // Assert or Check
        assertEquals(3, result);
    }

    @Test
    void subtraction() {
    }

    @Test
    void multiplication() {
    }

    @Test
    void test_DivideByZero_ThrowException() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act and Assert
        assertThrows(ArithmeticException.class, ()-> calculator.division(1, 0));
    }
}