package com.coffeemachine.controller;

import com.coffeemachine.model.CoffeeMachineModel;
import com.coffeemachine.view.CoffeeMachineView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CoffeeMachineControllerTest {
    private CoffeeMachineModel model;
    private CoffeeMachineView view;
    private CoffeeMachineController controller;

    @BeforeEach
    void setUp() {
        model = Mockito.mock(CoffeeMachineModel.class);
        view = Mockito.mock(CoffeeMachineView.class);
        controller = new CoffeeMachineController(model, view);
    }

    @Test
    void testBuyEspresso() {
        when(view.getInput()).thenReturn("comprar", "1", "sair");
        when(model.canMakeCoffee(250, 0, 16)).thenReturn(true);

        controller.run();

        verify(model).makeCoffee(250, 0, 16, 4);
        verify(view).displayMessage("Fazendo teu café...");
        verify(view).displayMessage("Pode retirar!");
    }

    @Test
    void testFill() {
        when(view.getInput()).thenReturn("abastecer", "sair");
        when(view.getIntInput()).thenReturn(500, 100, 50, 5);

        controller.run();

        verify(model).fill(500, 100, 50, 5);
    }

    @Test
    void testTake() {
        when(view.getInput()).thenReturn("retirar", "sair");
        when(model.takeMoney()).thenReturn(550);

        controller.run();

        verify(model).takeMoney();
        verify(view).displayMessage("Eu te dei R$550");
    }

    @Test
    void testRemaining() {
        when(view.getInput()).thenReturn("verificar", "sair");
        when(model.getWater()).thenReturn(400);
        when(model.getMilk()).thenReturn(540);
        when(model.getBeans()).thenReturn(120);
        when(model.getCups()).thenReturn(9);
        when(model.getMoney()).thenReturn(550);

        controller.run();

        verify(view).displayMachineState(400, 540, 120, 9, 550);
    }
}
