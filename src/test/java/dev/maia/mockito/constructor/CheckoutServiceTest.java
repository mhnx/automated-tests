package dev.maia.mockito.constructor;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

public class CheckoutServiceTest {

    @Test
    void testMockObjectConstruction() {

        // Essa parte é o mock do construtor
        // GIVEN
        try (MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class, (mock, context) -> {
            when(mock.chargeCustomer(anyString(), any(BigDecimal.class))).thenReturn(BigDecimal.TEN);
        })) {

            // Agora é o teste em si
            // WHEN
            CheckoutService service = new CheckoutService();
            BigDecimal result = service.purchaseProduct("Apple Watch Series 9", "42");

            // THEN
            assertEquals(BigDecimal.TEN, result);
            assertEquals(1, mocked.constructed().size());
        }
    }
}
