package com.jschool.Day2_Collections.TextSorter;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class TextSorterTest {
    public static final File FILE = new File("src/test/resources/FileForDay2");



    @Test
    public void wordCounterTest() {
        String textHolder = PrepareString.textHolder(FILE);
        assertEquals(4, TextSorter.wordCounter(textHolder));
    }

    @Test
    public void sortedUniqueWords() {
    }

    @Test
    public void uniqueWordCounter() {
    }

    @Test
    public void printReversStrings() {
    }

    @Test
    public void reversIterator() {
    }

    @Test
    public void printRequestString() {
    }
}