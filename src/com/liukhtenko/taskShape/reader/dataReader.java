package com.liukhtenko.taskShape.reader;

import com.liukhtenko.taskShape.exeption.FileNotReadExeption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dataReader {
    private final static String DEFAULT_PATH = "data/data.txt";
//    private String filePath;

    public dataReader() {
        //this.filePath = DEFAULT_PATH;
    }

//    public dataReader(String filePath) {
//        this.filePath = filePath;
//    }

    public List<String> read() throws FileNotReadExeption {
        List<String> list;
        try (Stream<String> stream = Files.lines(Paths.get(DEFAULT_PATH))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileNotReadExeption("File cannot be read");
        }
        return list;
    }
}
