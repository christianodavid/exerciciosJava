package com.calculadorasimples.controller;

import com.calculadorasimples.model.Calculadora;
import com.calculadorasimples.view.CalculadoraView;

public class CalculadoraController {
    private final Calculadora model;
    private final CalculadoraView view;

    public CalculadoraController(Calculadora model, CalculadoraView view) {
        this.model = model;
        this.view = view;
    }

    public void executar() {
        try {
            double num1 = view.lerNumero("Digite o primeiro número: ");
            String operacao = view.lerOperacao("Digite a operação (+, -, *, /): ");
            double num2 = view.lerNumero("Digite o segundo número: ");
            double resultado = realizarOperacao(num1, operacao, num2);
            view.mostrarResultado(num1, operacao, num2, resultado);
        } catch (Exception e) {
            view.mostrarErro(e.getMessage());
        }
    }

    public double realizarOperacao(double num1, String operacao, double num2) {
        return switch (operacao) {
            case "+" -> model.somar(num1, num2);
            case "-" -> model.subtrair(num1, num2);
            case "*" -> model.multiplicar(num1, num2);
            case "/" -> model.dividir(num1, num2);
            default -> throw new IllegalArgumentException("Operação inválida.");
        };
    }
}
