package com.botsimples.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BotTest {
    private Bot model;

    @BeforeEach
    void setUp() {
        model = new Bot("CadIA", "2021");
    }

    @Test
    void testConstructor() {
        assertEquals("CadIA", model.getBotName());
        assertEquals("2021", model.getBotYear());
    }

    @Test
    void testSetGetUserName() {
        model.setUserName("Christiano");
        assertEquals("Christiano", model.getUserName());
    }

    @Test
    void testSetGetUserAge() {
        model.setUserAge(26);
        assertEquals(26, model.getUserAge());
    }

    @Test
    void testCalculateAge() {
        assertEquals(23, model.calculateAge(2, 3, 2));
        assertEquals(24, model.calculateAge(0, 4, 3));
    }
}
