package com.chrosciu.patterns.behavioral.strategy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.chrosciu.patterns.behavioral.strategy.VehicleType.CAR;
import static com.chrosciu.patterns.behavioral.strategy.VehicleType.DRONE;
import static com.chrosciu.patterns.behavioral.strategy.VehicleType.TRAIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

public class JourneyPlannerTest {
    //given
    private final JourneyPlanner journeyPlanner = new JourneyPlanner();

    @ParameterizedTest
    @MethodSource
    void shouldCalculateJourneyDistance(VehicleType vehicleType, Point start, Point end, double expected) {
        //when
        var distance = journeyPlanner.calculateJourneyDistance(vehicleType, start, end);

        //then
        assertThat(distance).isCloseTo(expected, offset(0.001));
    }

    static Stream<Arguments> shouldCalculateJourneyDistance() {
        return Stream.of(
                Arguments.of(CAR, Point.of(3, 4), Point.of(7, 7), 7.0),
                Arguments.of(TRAIN, Point.of(3, 4), Point.of(6, 8), 5.0),
                Arguments.of(TRAIN, Point.of(3, 4), Point.of(4, 3), 10.0),
                Arguments.of(DRONE, Point.of(3, 4), Point.of(7, 7), 5.0)
        );
    }
}
