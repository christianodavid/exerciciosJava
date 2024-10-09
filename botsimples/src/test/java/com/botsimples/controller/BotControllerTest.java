package com.botsimples.controller;

import com.botsimples.model.Bot;
import com.botsimples.view.BotView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class BotControllerTest {
    private Bot model;
    private BotView view;
    private BotController controller;

    @BeforeEach
    void setUp() {
        model = Mockito.mock(Bot.class);
        view = Mockito.mock(BotView.class);
        controller = new BotController(model, view);
    }

    @Test
    void testRunBot() {
        when(model.getBotName()).thenReturn("CadIA");
        when(model.getBotYear()).thenReturn("2021");
        when(view.getUserName()).thenReturn("Christiano");
        when(view.getAgeRemainders()).thenReturn(new int[]{2, 1, 5});
        when(model.calculateAge(2, 1, 5)).thenReturn(26);
        when(view.getCountLimit()).thenReturn(100);
        when(view.getTestAnswer()).thenReturn(3);

        controller.runBot();

        verify(view).displayGreeting("CadIA", "2021");
        verify(view).displayNameConfirmation("Christiano");
        verify(view).displayAgeGuess(26);
        verify(view, times(100)).displayCount(anyInt());
        verify(view).displayTest();
        verify(view).displayTestResult(true);
        verify(view).displayEnd();
        verify(view).closeScanner();
    }
}
