package com.calculadorasimples;

import com.calculadorasimples.controller.CalculadoraController;
import com.calculadorasimples.model.Calculadora;
import com.calculadorasimples.view.CalculadoraView;

public class Main {
    public static void main(String[] args) {
        Calculadora model = new Calculadora();
        CalculadoraView view = new CalculadoraView();
        CalculadoraController controller = new CalculadoraController(model, view);

        controller.executar();
    }
}
