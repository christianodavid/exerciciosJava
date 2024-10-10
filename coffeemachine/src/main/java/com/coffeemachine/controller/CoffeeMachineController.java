package com.coffeemachine.controller;

import com.coffeemachine.model.CoffeeMachineModel;
import com.coffeemachine.view.CoffeeMachineView;

public class CoffeeMachineController {
    private CoffeeMachineModel model;
    private CoffeeMachineView view;

    public enum Status {
        CHOOSING, BUYING, FILLING, TAKING, REMAINING, EXITING
    }

    private Status currentStatus;

    public CoffeeMachineController(CoffeeMachineModel model, CoffeeMachineView view) {
        this.model = model;
        this.view = view;
        this.currentStatus = Status.CHOOSING;
    }

    public void run() {
        do {
            view.displayStatus("Escreva a ação (comprar, abastecer, retirar, verificar, sair): ");
            String action = view.getInput();
            processAction(action);
        } while (currentStatus != Status.EXITING);
    }

    private void processAction(String action) {
        switch(action) {
            case "comprar":
                currentStatus = Status.BUYING;
                buy();
                break;
            case "abastecer":
                currentStatus = Status.FILLING;
                fill();
                break;
            case "retirar":
                currentStatus = Status.TAKING;
                take();
                break;
            case "verificar":
                currentStatus = Status.REMAINING;
                remaining();
                break;
            case "sair":
                exit();
                break;
        }
    }

    private void buy() {
        view.displayPrompt("O que tu desejas comprar? 1.Espresso; 2.Latte; 3.Cappuccino; 4.Voltar ao menu principal");
        String choice = view.getInput();
        switch(choice) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "4":
                break;
        }
        currentStatus = Status.CHOOSING;
    }

    private void makeCoffee(int water, int milk, int beans, int cost) {
        if(model.canMakeCoffee(water, milk, beans)) {
            model.makeCoffee(water, milk, beans, cost);
            view.displayMessage("Fazendo teu café...");
            view.displayMessage("Pode retirar!");
        } else {
            view.displayMessage("Desculpe, não há recursos suficientes. ");
        }
    }

    private void fill() {
        view.displayPrompt("Escreva quantos mL de água tu queres adicionar: ");
        int waterAdd = view.getIntInput();
        view.displayPrompt("Escreva quantos mL de leite tu queres adicionar: ");
        int milkAdd = view.getIntInput();
        view.displayPrompt("Escreva quantos g de café tu queres adicionar: ");
        int beansAdd = view.getIntInput();
        view.displayPrompt("Escreva quantos copos descartáveis tu queres adicionar: ");
        int cupsAdd = view.getIntInput();

        model.fill(waterAdd, milkAdd, beansAdd, cupsAdd);
        currentStatus = Status.CHOOSING;
    }

    private void take() {
        int takenMoney = model.takeMoney();
        view.displayMessage("Eu te dei R$" + takenMoney);
        currentStatus = Status.CHOOSING;
    }

    private void remaining() {
        view.displayMachineState(model.getWater(), model.getMilk(), model.getBeans(), model.getCups(), model.getMoney());
        currentStatus = Status.CHOOSING;
    }

    private void exit() {
        currentStatus = Status.EXITING;
    }
}
