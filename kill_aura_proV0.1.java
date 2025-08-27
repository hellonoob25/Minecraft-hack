private boolean jumpCritEnabled = false;

// 監聽鍵盤按鍵
@SubscribeEvent
public void onKeyInput(InputEvent.KeyInputEvent event) {
    if (KeyBindings.JUMP_CRIT_KEY.isDown()) { // 自定義 R熱鍵
        jumpCritEnabled = !jumpCritEnabled; // 切換開關
        if (jumpCritEnabled) {
            System.out.println("kill aura開啟");
        } else {
            System.out.println("kill aura 關閉 ");
        }
    }
}

@SubscribeEvent
public void onAttack(LivingAttackEvent event) {
    if (!jumpCritEnabled) return;

    if (event.getSource().getEntity() instanceof Player player) {
        ItemStack stack = player.getMainHandItem();

        //無冷卻
        player.getCooldowns().addCooldown(stack.getItem(), 0);

        // 跳砍
        if (!player.isOnGround() && player.getDeltaMovement().y < 0) {
            event.getEntity().hurt(DamageSource.playerAttack(player),
                (float)(player.getAttackStrengthScale(1.0F) * 1.5F)); 
        }
    }
}
