package com.botsimples.view;

import java.util.Scanner;

public class BotView {
    private final Scanner scanner;

    public BotView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayGreeting(String botName, String botYear) {
        System.out.println("Olá, meu nome é " + botName + "!");
        System.out.println("Fui criado em " + botYear + ".");
        System.out.println("Por favor, me lembre teu nome!");
    }

    public String getUserName() {
        return scanner.nextLine();
    }

    public void displayNameConfirmation(String name) {
        System.out.println("Que nome lindo, " + name + "!");
    }

    public void displayGuessAgePrompt() {
        System.out.println("Deixe-me adivinhar tua idade!!!");
        System.out.println("Digite o resto da divisão da tua idade por 3, 5 e 7.");
    }

    public int[] getAgeRemainders() {
        int[] remainders = new int[3];
        for(int i = 0; i < 3; i++) {
            remainders[i] = scanner.nextInt();
        }
        return remainders;
    }

    public void displayAgeGuess(int age) {
        System.out.println("Tua idade é " + age + " anos.");
    }

    public void displayCountPrompt() {
        System.out.println("Agora vou te provar que consigo contar até qualquer número que tu pedires!");
    }

    public int getCountLimit() {
        return scanner.nextInt();
    }

    public void displayCount(int number) {
        System.out.println(number);
    }

    public void displayTest() {
        System.out.println("Vamos testar teu conhecimento de programação.");
        System.out.println("Qual afirmação é a mais completa sobre break e continue?");
        System.out.println("1. A palavra-chave break pode ser escrita no corpo de loops while e do-while.");
        System.out.println("2. A palavra-chave continue não pode ser escrita no corpo de loops while e do-while.");
        System.out.println("3. Ambas as palavras-chave podem ser escritas no corpo de loops for, while e do-while.");
        System.out.println("4. As palavras-chave break e continue podem ser escritas na declaração condicional if-else.");
    }

    public int getTestAnswer() {
        return scanner.nextInt();
    }

    public void displayTestResult(boolean correct) {
        if(!correct) {
            System.out.println("Por favor, tente novamente.");
        }
    }

    public void displayEnd() {
        System.out.println("Parabéns! Tenha um ótimo dia!");
    }

    public void closeScanner() {
        scanner.close();
    }
}
