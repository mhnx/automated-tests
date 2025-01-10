package dev.maia.service;

import dev.maia.business.Order;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

public class OrderServiceTest {

    OrderService service = new OrderService();
    Object defaultUuid = UUID.fromString("80b76717-be3d-41eb-aef7-1ba59e5c9d93");
    LocalDateTime defaultLocalDateTime = LocalDateTime.of(2025, 1, 9, 15, 39);

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

    @Test
    void shouldIncludeCurrentTimeWhenCreatingANewOrder() {

        // Given / Arrange
        try(MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
            mockedLocalDateTime.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            // When / Act
            Order result = service.createOrder("MacBook Pro 2025", 18999L, null);

            // Then / Assert
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
    }
}
