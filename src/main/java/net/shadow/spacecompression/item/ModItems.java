package net.shadow.spacecompression.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shadow.spacecompression.SpaceCompression;

public class ModItems {
    public static final Item HEXSPADE = registerItem("hexspade",
            new Item(new FabricItemSettings().fireproof()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SpaceCompression.MOD_ID, name), item);
    }


    public static void registerModItems() {
        SpaceCompression.LOGGER.info("Registering Mod Items for " + SpaceCompression.MOD_ID);

    }
}
