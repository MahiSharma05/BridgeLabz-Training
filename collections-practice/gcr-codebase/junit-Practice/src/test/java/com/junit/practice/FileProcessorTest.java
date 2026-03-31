package com.junit.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

class FileProcessorTest {

    FileProcessor processor = new FileProcessor();
    String filename = "junit-test.txt";

    @Test
    void testWriteAndReadFile() throws IOException {
        processor.writeToFile(filename, "Hello World");
        String result = processor.readFromFile(filename);
        assertEquals("Hello World", result);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(filename, "File exists");
        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    void testReadFile_FileNotFound() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("no_file.txt");
        });
    }
}
