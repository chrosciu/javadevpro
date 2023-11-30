package com.chrosciu.patterns.structural.facade;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import static org.mockito.Answers.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.withSettings;

class DatabaseFacadeTest {
    @Test
    void shouldCreateDatabaseConnectionWithPassedParameters() {
        //given
        var databaseFacade = new DatabaseFacade();

        try(MockedConstruction<ConnectionPool> connectionPoolMockedConstruction =
                    mockConstruction(ConnectionPool.class, withSettings().defaultAnswer(CALLS_REAL_METHODS));
            MockedConstruction<Connection> connectionMockedConstruction =
                    mockConstruction(Connection.class, withSettings().defaultAnswer(CALLS_REAL_METHODS))) {
            //when
            databaseFacade.connectToDatabase("localhost", 5432, "example");

            //then
            var connectionPool = connectionPoolMockedConstruction.constructed().get(0);
            var connection = connectionMockedConstruction.constructed().get(0);
            verify(connectionPool).connect("jdbc://localhost:5432");
            verify(connection).send("USE example");
        }

    }
}
