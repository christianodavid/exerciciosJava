package com.botsimples;

import com.botsimples.controller.BotController;
import com.botsimples.model.Bot;
import com.botsimples.view.BotView;

public class Main {
    public static void main(String[] args) {
        Bot model = new Bot("CadIA", "2021");
        BotView view = new BotView();
        BotController controller = new BotController(model, view);

        controller.runBot();
    }
}
