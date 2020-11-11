package me.cerratolabs.challenge.autocomplete;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileTesting {
    private Autocomplete ac;

    @Before
    public void startTester() throws IOException {
        ac = new Autocomplete("src/test/resources/dictionary.txt");
    }

    @Test
    public void testNullPrefix() {
        assertEquals(null, ac.matches(null));
    }

    @Test
    public void test_startWithyo() {
        List<String> list = Arrays.asList(
            "you",
            "young",
            "your",
            "yourself"
        );
        assertEquals(list, ac.matches("yo"));
    }
}