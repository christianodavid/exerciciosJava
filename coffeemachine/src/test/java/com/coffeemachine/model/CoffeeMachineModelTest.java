package com.coffeemachine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoffeeMachineModelTest {
    private CoffeeMachineModel model;

    @BeforeEach
    void setUp() {
        model = new CoffeeMachineModel();
    }

    @Test
    void testInitialState() {
        assertEquals(400, model.getWater());
        assertEquals(540, model.getMilk());
        assertEquals(120, model.getBeans());
        assertEquals(9, model.getCups());
        assertEquals(550, model.getMoney());
    }

    @Test
    void testCanMakeCoffee() {
        assertTrue(model.canMakeCoffee(250, 0, 16));
        assertTrue(model.canMakeCoffee(350, 75, 20));
        assertTrue(model.canMakeCoffee(200, 100, 12));
        assertFalse(model.canMakeCoffee(500, 0, 16));
    }

    @Test
    void testMakeCoffee() {
        model.makeCoffee(250, 0, 16, 4);
        assertEquals(150, model.getWater());
        assertEquals(540, model.getMilk());
        assertEquals(104, model.getBeans());
        assertEquals(8, model.getCups());
        assertEquals(554, model.getMoney());
    }

    @Test
    void testFill() {
        model.fill(500, 100, 50, 5);
        assertEquals(900, model.getWater());
        assertEquals(640, model.getMilk());
        assertEquals(170, model.getBeans());
        assertEquals(14, model.getCups());
    }

    @Test
    void testTakeMoney() {
        int takenMoney = model.takeMoney();
        assertEquals(550, takenMoney);
        assertEquals(0, model.getMoney());
    }
}
