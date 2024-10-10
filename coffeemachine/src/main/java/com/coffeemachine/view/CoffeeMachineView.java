package com.coffeemachine.view;

import java.util.Scanner;

public class CoffeeMachineView {
    private final Scanner scanner;

    public CoffeeMachineView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public int getIntInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayStatus(String status) {
        System.out.println(status);
    }

    public void displayPrompt(String prompt) {
        System.out.println(prompt);
    }

    public void displayMachineState(int water, int milk, int beans, int cups, int money) {
        System.out.println("\nA máquina de café tem:");
        System.out.println(water + "mL de água");
        System.out.println(milk + "mL de leite");
        System.out.println(beans + "g grãos de café");
        System.out.println(cups + " copos descartáveis");
        System.out.println("R$" + money);
    }
}
