package jackson.org.jacksonfoodmod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class itemLasagna extends Item {
    public itemLasagna() {
        super(new Item.Properties()
                .food(new FoodProperties.Builder().nutrition(11).saturationMod(0.6f).build())
                .stacksTo(16));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level world, @NotNull LivingEntity entityLiving) {
        super.finishUsingItem(stack, world, entityLiving);
        if (!world.isClientSide && entityLiving instanceof Player) {
            Player player = (Player) entityLiving;
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 600, 1)); // 30 seconds of Jump Boost I
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 2)); // 30 seconds of Jump Boost I
        }
        return stack;
    }
}
