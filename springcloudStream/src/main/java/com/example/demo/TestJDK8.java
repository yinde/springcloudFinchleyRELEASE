package com.example.demo;

import java.util.stream.LongStream;

public class TestJDK8 {

	public static void main(String[] args) {
		Long x = 0L;
        Long y = 10000000000L;
        long l = System.currentTimeMillis();
        for (Long i = 0L; i <= y; i++) {
            x+=i;
        }
        long l1 = System.currentTimeMillis();
        System.out.println("invoke = " + x+"  time: " + (l1-l));
	}
}
