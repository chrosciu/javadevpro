package com.chrosciu.patterns.behavioral.chain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
enum Severity {
    ENHANCEMENT(0),
    TRIVIAL(1),
    MINOR(2),
    NORMAL(3),
    MAJOR(4),
    CRITICAL(5),
    BLOCKER(6);

    private final int rank;
}
