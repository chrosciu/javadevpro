package com.chrosciu.benchmarking;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinkedListBenchmark {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @Fork(value = 1)
    @Measurement(iterations = 1)
    public void init() {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 1_000_000; ++i) {
            list.add(random.nextInt());
        }
    }
}
