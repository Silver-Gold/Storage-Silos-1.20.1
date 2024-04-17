package net.silvergold.storagesilos.item;

import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.silvergold.storagesilos.StorageSilos;
import net.silvergold.storagesilos.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StorageSilos.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STORAGE_SILOS_TAB = CREATIVE_MODE_TABS.register("storagesilos_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHEESE.get()))
                    .title(Component.translatable("creativetab.storagesilos_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CHEESE.get());
                        pOutput.accept(ModBlocks.CHEESE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
