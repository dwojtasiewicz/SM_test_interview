package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Stream stream = new Stream();
        stream.listen();
    }
}

