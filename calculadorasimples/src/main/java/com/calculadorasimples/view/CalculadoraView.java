package com.calculadorasimples.view;

import java.util.Scanner;

public class CalculadoraView {
    private final Scanner scanner;

    public CalculadoraView() {
        scanner = new Scanner(System.in);
    }

    public double lerNumero(String mensagem) {
        System.out.print(mensagem);
        double numero = scanner.nextDouble();
        limparScanner();
        return numero;
    }

    public void limparScanner() {
        scanner.nextLine();
    }

    public String lerOperacao(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public void mostrarResultado(double num1, String operacao, double num2, double resultado) {
        System.out.println(num1 + " " + operacao + " " + num2 + " = " + resultado);
    }

    public void mostrarErro(String mensagem) {
        System.out.println("Erro: " + mensagem);
    }
}
