package dev.maia.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class MockedListBDDTest {

    @Test
    void testMockedListWhenSizeIsCalled() {

        // Given / Arrange
        List<?> list = mock(List.class);

        // When / Act
        given(list.size()).willReturn(10);

        // Then / Assert
        assertThat(list.size(), is(10));
    }

    @Test
    void testMockedListWhenSizeIsCalledMultipleTimes() {

        // Given / Arrange
        List<?> list = mock(List.class);

        // When / Act
        given(list.size()).willReturn(10).willReturn(20).willReturn(30);

        // Then / Assert
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(equalTo(20)));
        assertThat(list.size(), equalTo(30));
    }

    @Test
    void testMockedListWhenSizeIsCalledWithArgumentMatcher() {

        var list = mock(List.class);

        given(list.get(anyInt())).willReturn("Marco");

        assertThat(list.get(anyInt()), equalTo("Marco"));
    }

    @Test
    void testMockedListThrowingARuntimeException() {

        var list = mock(List.class);

        given(list.get(anyInt())).willThrow(new RuntimeException("error getting item list"));

        assertThrows(RuntimeException.class, () -> list.get(anyInt()), "Should have thrown a RuntimeException");
    }
}
