package com.example.mymod;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import com.mojang.blaze3d.vertex.PoseStack;

public class MyGuiScreen extends Screen {

    private boolean showCategoryA = false;

    protected MyGuiScreen() {
        super(Component.literal("作弊功能"));
    }

    @Override
    protected void init() {
        // 功能分類
        this.addRenderableWidget(new Button(this.width / 2 - 50, this.height / 2 - 20, 100, 20, Component.literal("分類 A"), button -> {
            showCategoryA = !showCategoryA;
            this.init(); // 重新初始化按鈕
        }));

        // 功能 kill aura按鈕，只有在分類 展開時才顯示
        if (showCategoryA) {
            this.addRenderableWidget(new Button(this.width / 2 - 50, this.height / 2 + 10, 100, 20, Component.literal("kill aura++"), button -> {
                // 點擊功能 C 執行 killaura.java 裡的邏輯
                H.execute();
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
