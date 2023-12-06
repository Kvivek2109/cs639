package com.example.myfirstapp;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public void writeLogFile(String logMessage) {
        BufferedWriter output = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());
            String logEntry = "" + timestamp + " \t" + logMessage;
            File file = new File("../log_file.txt");
            output = new BufferedWriter(new FileWriter(file)); // true to append data
            output.write(logEntry);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        writeLogFile("Test passed");
    }
}



