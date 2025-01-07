package dev.maia.mockito;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    void test() {

        // Given / Arrange
        List<String> list = mock(ArrayList.class);

        // When / Act && Then / Assert
        assertEquals(0, list.size());
    }

    @Test
    void testWithSpy() {

        // Given / Arrange
        List<String> list = spy(ArrayList.class);

        // When / Act && Then / Assert
        assertEquals(0, list.size());

        when(list.size()).thenReturn(5);
        list.add("Foo-Bar");

        assertEquals(5, list.size());
    }

    @Test
    void testSpyWithVerify() {
            List<String> list = spy(ArrayList.class);

            list.add("Foo bar");

            verify(list).add("Foo bar");
            verify(list, never()).remove(anyString());
    }
}
