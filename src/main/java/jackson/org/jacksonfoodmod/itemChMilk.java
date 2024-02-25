package jackson.org.jacksonfoodmod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class itemChMilk extends Item {
    public itemChMilk() {
        super(new Item.Properties()
                .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build())
                .stacksTo(16));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level world, @NotNull LivingEntity entityLiving) {
        super.finishUsingItem(stack, world, entityLiving);
        if (!world.isClientSide && entityLiving instanceof Player) {
            Player player = (Player) entityLiving;
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 255)); // 30 seconds of Speed I
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (entityLiving instanceof Player) {
                Player player = (Player) entityLiving;
                if (!player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE))) {
                    player.drop(new ItemStack(Items.GLASS_BOTTLE), false);
                }
            }
        }

        return stack;
    }
}
