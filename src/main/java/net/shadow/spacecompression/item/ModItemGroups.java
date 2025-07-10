package net.shadow.spacecompression.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.shadow.spacecompression.SpaceCompression;




public class ModItemGroups {

    public static final ItemGroup SPACE_COMPRESSION = Registry.register(Registries.ITEM_GROUP, new Identifier(SpaceCompression.MOD_ID, "space_compression"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.space_compression"))
                    .icon(() -> new ItemStack(Items.FARMLAND)).entries((displayContext, entries) -> {
                        entries.add(ModItems.HEXSPADE);

                    }).build());


    public static void registerItemGroups() {
        SpaceCompression.LOGGER.info("registering Item Groups for " + SpaceCompression.MOD_ID);
    }
}
