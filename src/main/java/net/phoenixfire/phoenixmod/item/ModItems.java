package net.phoenixfire.phoenixmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phoenixfire.phoenixmod.PhoenixMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PhoenixMod.MOD_ID);

    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.registerSimpleItem("silver_ingot");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
