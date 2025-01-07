package dev.maia.service;

import dev.main.business.Order;
import dev.main.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

public class OrderServiceTest {

    Object defaultUuid = UUID.fromString("80b76717-be3d-41eb-aef7-1ba59e5c9d93");
    OrderService service = new OrderService();

    @Test
    void shouldIncludeRandomIdWhenThereIsNoOrderId() {

        // Given / Arrange
        try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            // When / Act
            Order result = service.createOrder("MacBook Pro 2025", 18999L, null);

            // Then / Assert
            assertEquals(defaultUuid.toString(), result.getId());
        }
    }
}
