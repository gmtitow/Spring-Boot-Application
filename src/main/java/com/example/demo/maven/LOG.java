package com.example.demo.maven;

public class LOG {
    public static void info(String format, Object... args) {
        System.out.printf(format + "%n",args);
    }
}
