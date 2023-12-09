package com.chrosciu.patterns.behavioral.chain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SupportCenterTest {
    private final SupportCenter supportCenter = new SupportCenter();

    @ParameterizedTest
    @MethodSource
    void shouldSolveBugsWithGivenSeverity(Severity severity, String expectedResolution) {
        //given
        var bug = new Bug(severity);

        //when
        var resolution = supportCenter.solve(bug);

        //then
        assertThat(resolution).isEqualTo(expectedResolution);
    }

    static Stream<Arguments> shouldSolveBugsWithGivenSeverity() {
        return Stream.of(
                Arguments.of(Severity.ENHANCEMENT, "Solved by junior developer"),
                Arguments.of(Severity.TRIVIAL, "Solved by junior developer"),
                Arguments.of(Severity.MINOR, "Solved by junior developer"),
                Arguments.of(Severity.NORMAL, "Solved by regular developer"),
                Arguments.of(Severity.MAJOR, "Solved by regular developer"),
                Arguments.of(Severity.CRITICAL, "Solved by senior developer"),
                Arguments.of(Severity.BLOCKER, "Solved by senior developer")
        );
    }

}
