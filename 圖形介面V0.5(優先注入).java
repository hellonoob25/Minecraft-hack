package com.example.mymod;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import com.mojang.blaze3d.vertex.PoseStack;

public class MyGuiScreen extends Screen {

    private boolean showCategoryA = false;

    public MyGuiScreen() {
        super(Component.literal("作弊功能"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        int buttonWidth = 100;
        int buttonHeight = 20;
        int spacing = 5;

        int currentY = centerY - 20; // 按鈕起始 Y 座標

        // 分類(戰鬥類型)按鈕
        this.addRenderableWidget(new Button(centerX - buttonWidth / 2, currentY, buttonWidth, buttonHeight, Component.literal("戰鬥類"), button -> {
            showCategoryA = !showCategoryA;
        }));

        currentY += buttonHeight + spacing;

        // kill aura 按鈕（僅在分類 A 展開時顯示）
        if (showCategoryA) {
            this.addRenderableWidget(new Button(centerX - buttonWidth / 2, currentY, buttonWidth, buttonHeight, Component.literal("kill aura++"), button -> {
                kill_aura_pro.execute(); // 呼叫同資料夾 kill_aura_pro 的靜態方法
            }));
        }
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
