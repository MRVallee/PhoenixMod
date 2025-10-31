package net.phoenixfire.phoenixmod.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phoenixfire.phoenixmod.PhoenixMod;
import net.phoenixfire.phoenixmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PhoenixMod.MOD_ID);

    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock(
            "silver_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("phoenixmod:silver_block")))
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));
    public static final DeferredBlock<Block> SILVER_ORE = registerBlock(
            "silver_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("phoenixmod:silver_block")))
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PhoenixMod.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
