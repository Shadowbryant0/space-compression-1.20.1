package net.shadow.spacecompression.Block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.shadow.spacecompression.Block.Custom.CompressedStorageBlock;
import net.shadow.spacecompression.SpaceCompression;

public class ModBlocks {

    public static final Block THREAD_WEAVER = registerBlock(
            "thread_weaver",
            new Block(FabricBlockSettings.create().collidable(true).pistonBehavior(PistonBehavior.IGNORE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.ANVIL)));
    public static final Block TEST = registerBlock(
            "test",
            new CompressedStorageBlock(FabricBlockSettings.create().collidable(true).pistonBehavior(PistonBehavior.IGNORE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.ANVIL)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SpaceCompression.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(SpaceCompression.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        SpaceCompression.LOGGER.info("registering mod blocks for " + SpaceCompression.MOD_ID);
    }
}
