package com.coffeemachine;

import com.coffeemachine.controller.CoffeeMachineController;
import com.coffeemachine.model.CoffeeMachineModel;
import com.coffeemachine.view.CoffeeMachineView;

public class CoffeeMachine {
    public static void main(String[] args) {
        CoffeeMachineModel model = new CoffeeMachineModel();
        CoffeeMachineView view = new CoffeeMachineView();
        CoffeeMachineController controller = new CoffeeMachineController(model, view);

        controller.run();
    }
}
