package dev.maia.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
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

    @Test
    void testMockedListThrowingARuntimeException() {

        var list = mock(List.class);

        when(list.get(anyInt())).thenThrow(new RuntimeException("error getting item list"));

        assertThrows(RuntimeException.class, () -> list.get(anyInt()), "Should have thrown a RuntimeException");
    }

    @Test
    void testMockedListWithBDD() {

        var list = mock(List.class);

        given(list.size()).willReturn(1);

        assertThat(list.size(), is(1));
    }
}
