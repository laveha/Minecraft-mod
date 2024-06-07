package net.bityutsky.mptmod.item;

import net.bityutsky.mptmod.MptMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MptMod.MOD_ID);



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> CAR = ITEMS.register("car",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CAR_TAB)));

    public static final RegistryObject<Item> PISTON = ITEMS.register("piston",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CAR_TAB)));

    public static final RegistryObject<Item> ENGINE = ITEMS.register("engine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CAR_TAB)));

    public static final RegistryObject<Item> SHAFT = ITEMS.register("shaft",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CAR_TAB)));

}
