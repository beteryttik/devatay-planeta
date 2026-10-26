package com.ninthplanet.ui.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

/**
 * Панель оператора (правый Shift): вкладки
 * Статус / Карта заражения / Память / Панацея.
 */
public class OperatorPanelScreen extends Screen {
    private int selectedTab = 0;
    private static final String[] TABS = {"Статус", "Карта", "Память", "Панацея"};

    public OperatorPanelScreen() {
        super(Text.literal("Панель оператора — Девятая планета"));
    }

    @Override
    protected void init() {
        int y = 40;
        for (int i = 0; i < TABS.length; i++) {
            final int tabIndex = i;
            addDrawableChild(ButtonWidget.builder(Text.literal(TABS[i]), b -> selectedTab = tabIndex)
                    .dimensions(20 + i * 90, y, 80, 20).build());
        }
    }

    @Override
    public void render(net.minecraft.client.gui.DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        //TODO: рисовать содержимое выбранной вкладки
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
