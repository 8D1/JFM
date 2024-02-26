package jackson.org.jacksonfoodmod;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod("jacksonfoodmod")
public class JacksonFoodMod {
    public static final String MODID = "jacksonfoodmod";
    private static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> ITEM_CH_MILK;
    public static final RegistryObject<Item> ITEM_MC_CH;
    public static final RegistryObject<Item> ITEM_LASAGNA;
    public static final RegistryObject<Item> ITEM_EDIBLE;
    public JacksonFoodMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        this.registerItems();
    }

    private void registerItems() {
    }



    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jacksonfoodmod");
        ITEM_CH_MILK = ITEMS.register("itemchmilk", itemChMilk::new);
        ITEM_MC_CH = ITEMS.register("itemmcch", itemMcCh::new);
        ITEM_LASAGNA = ITEMS.register("itemlasagna", itemLasagna::new);
        ITEM_EDIBLE = ITEMS.register("itemedible", itemEdible::new);
    }
}
