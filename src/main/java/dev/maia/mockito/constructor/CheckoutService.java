package dev.maia.mockito.constructor;

import java.math.BigDecimal;

public class CheckoutService {

    public BigDecimal purchaseProduct(String productName, String customerId) {

        /* Implementações como na linha abaixo são frequentes em códigos legados
         * É importante evitar essa abordagem, o ideal é usar a injeção de dependências
         */
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        return paymentProcessor.chargeCustomer(customerId, BigDecimal.TEN);
    }
}
