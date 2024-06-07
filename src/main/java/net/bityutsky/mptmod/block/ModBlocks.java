package net.bityutsky.mptmod.block;

import net.bityutsky.mptmod.MptMod;
import net.bityutsky.mptmod.item.ModCreativeModeTab;
import net.bityutsky.mptmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MptMod.MOD_ID);

    public static final RegistryObject<Block> TILE_BLOCK = registryBlock( "tile_block",
            () -> new FallingBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength( 3f).requiresCorrectToolForDrops()), ModCreativeModeTab.CAR_TAB);

    public static final RegistryObject<Block> BOX_BLOCK = registryBlock( "box_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength( 1F, 8.0F).requiresCorrectToolForDrops()), ModCreativeModeTab.CAR_TAB);

    public static final RegistryObject<Block> RUBER_BLOCK = registryBlock("ruber_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).sound(SoundType.SLIME_BLOCK)
                    .strength(0.4F, 8.0F).requiresCorrectToolForDrops().jumpFactor(2)), ModCreativeModeTab.CAR_TAB);

    public static final RegistryObject<Block> TONER_BLOCK = registryBlock("toner_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.BONE_BLOCK)
                    .strength(1.5F, 50.0F).requiresCorrectToolForDrops()), ModCreativeModeTab.CAR_TAB);

    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }

    private static <T extends Block> RegistryObject<BlockItem> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
