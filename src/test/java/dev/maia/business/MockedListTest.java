package dev.maia.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockedListTest {

    @Test
    void testMockedListWhenSizeIsCalled() {

        // Given / Arrange
        List<?> list = mock(List.class);

        // When / Act
        when(list.size()).thenReturn(10);

        // Then / Assert
        assertEquals(10, list.size());
    }

    @Test
    void testMockedListWhenSizeIsCalledMultipleTimes() {

        // Given / Arrange
        List<?> list = mock(List.class);

        // When / Act
        when(list.size()).thenReturn(10).thenReturn(20).thenReturn(30);

        // Then / Assert
        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(30, list.size());
    }

    @Test
    void testMockedListWhenSizeIsCalledWithArgumentMatcher() {

        var list = mock(List.class);

        when(list.get(anyInt())).thenReturn("Marco");

        assertEquals("Marco", list.get(anyInt()));
    }
}
