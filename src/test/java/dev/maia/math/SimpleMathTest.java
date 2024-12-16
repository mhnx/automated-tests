package dev.maia.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
