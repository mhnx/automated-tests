package dev.maia.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Classe de testes")
public class SimpleMathTest {

    SimpleMath simpleMath;

    @BeforeAll
    static void setup() {
        System.out.println("RODANDO O BEFORE ALL");
    }

    @BeforeEach
    void createSimpleMathObject() {
        System.out.println("RODANDO O BEFOREEACH SIMPLE MATH");
        simpleMath = new SimpleMath();
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("RODANDO O AFTEREACH");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("RODANDO O AFTER ALL");
    }

    @Test
    @DisplayName("Testa a soma dois números")
    void testSum() {
        System.out.println("RODANDO TESTE ADIÇÃO");
        // Given

        // When
        Double result = simpleMath.sum(6.2, 2.0);

        // Then
        assertEquals(8.2, result);
    }

    @Test
    @DisplayName("Testa a subtração dois números")
    void testSubtract() {
        System.out.println("RODANDO TESTE SUBTRAÇÃO");

        Double result = simpleMath.subtract(5.0, 3.0);

        assertEquals(2.0, result, "testSubtract() parou de funcionar");
    }

    @Test
    void testMultiply() {
        System.out.println("RODANDO TESTE MULTIPLICAÇÃO");

        Double actual = simpleMath.multiply(4.0, 7.0);
        Double expected = 28.0;

        assertEquals(expected, actual, () -> "MULTIPLYING FAILED");
    }

    @Test
    void testDivide() {
        System.out.println("RODANDO TESTE DIVISÃO");

        Double actual = simpleMath.divide(7.5, 3.75);
        Double expected = 2.0;

        assertEquals(expected, actual);
    }

    @Test
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
        double firstNumber = 1.0;
        double secondNumber = 0.0;

        assertThrows(ArithmeticException.class, () -> {
            simpleMath.divide(firstNumber, secondNumber);
        });
    }

    @Test
    void testDivisionByZeroV2() {
        double firstNumber = 2D;
        double secondNumber = 0D;

        String expectedMessage = "Dividing by zero is impossíble!";

        // assert do lançamento de exceção
        ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
           simpleMath.divide(firstNumber, secondNumber);
        }, () -> "Dividing by zero should throw ArithmeticException");

        // assert da mensagem de erro da exceção
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void testAverage() {
        System.out.println("RODANDO TESTE MÉDIA");

        Double actual = simpleMath.average(4.2, 2.4);
        Double expected = 3.3;

        assertEquals(expected, actual);
    }

    @Disabled
    @Test
    void testSquareRoot() {
        System.out.println("RODANDO TESTE RAIZ QUADRADA");

        Double actual = simpleMath.squareRoot(144.0);
        Double expected = 12.0;

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource()
    void sumAListOfEvenNumbers(double firstNumber, double secondNumber, double expected) {
        double actual = simpleMath.sum(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> sumAListOfEvenNumbers() {
        return Stream.of(
                Arguments.of(2D, 4D, 6D),
                Arguments.of(40D, 60D, 100D),
                Arguments.of(222D, 888D, 1110D)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"Eloim", "Jeovah", "Michael"})
    void testValueSourceValues(String name) {
        assertNotNull(name);
    }

    @RepeatedTest(3)
    @DisplayName("Teste repetido")
    void testMultiplication(RepetitionInfo info) {
        System.out.println("Esta é a repetição " + info.getCurrentRepetition() + " de " + info.getTotalRepetitions() + ".");

        double firstNumber = 8D;
        double secondNumber = 9D;
        double expected = 72D;

        double actual = simpleMath.multiply(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }
}
