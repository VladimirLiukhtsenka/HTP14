package com.liukhtenko.taskShape.test;

import com.liukhtenko.taskShape.exeption.FileNotReadExeption;
import com.liukhtenko.taskShape.reader.dataReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class dataReaderTest {
    private dataReader dataReader;

    @BeforeClass
    public void setup() {
        dataReader = new dataReader();
    }

    @AfterClass
    public void tearDown() {
        dataReader = null;
    }

    @Test
    public void ReaderTestTrue() throws FileNotReadExeption {
        List<String> expected = new ArrayList<>();
        expected.add("175325 3.0 6.0 -2.0 5.0");
        expected.add("635.487 -1.0 8.0 4.0 3.0");
        expected.add("1g1232 5.0 7.0 6.0 10.0");
        expected.add("524151 5.0 8.0 6.0");
        expected.add("514565 4.0 2.0 7.0 -1.0");
        expected.add("514565 2.0 2.0 7.0 -1.0 6.3");
        expected.add("514565 4,0 2.0 7.0 -1.0");
        expected.add("232657 7.0 5.0 -20.0 53.0");
        expected.add("345253 3.0 2.0 -1.0 5.0");
        expected.add("879656 2.0 4.0 9.0 2.0");
        expected.add("675645 7.0 -3.0 1.0 6.0");
        expected.add("996524 1.0 5.0 3.0 12.0");
        expected.add("999999 -5.0 -3.0 10.0 4.0");

        List<String> actual = dataReader.read();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ReaderTestNotNull() throws FileNotReadExeption {
        List<String> actual = dataReader.read();
        Assert.assertNotNull(actual);
    }

}
