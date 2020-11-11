package me.cerratolabs.challenge.autocomplete;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
@Slf4j
public class FileTesting {
    private Autocomplete ac;

    @Before
    public void startTester() throws IOException {
        ac = new Autocomplete("src/test/resources/dictionary.txt");
    }

    @Test
    public void testNullPrefix() {
        assertNull("Text dont return null",ac.matches(null));
    }

    @Test
    public void testStartWithyo() {
        List<String> list = Arrays.asList(
            "you",
            "young",
            "your",
            "yourself"
        );
        assertEquals(list, ac.matches("yo"));
    }

    @Test
    public void testStartWithyyo() {
        List<String> list = Collections.emptyList();
        assertEquals(list, ac.matches("yyo"));
    }

    @Test
    public void testStartWithWrite() {
        List<String> list = Arrays.asList(
            "write",
            "writer"
        );
        assertEquals(list, ac.matches("write"));
    }
}