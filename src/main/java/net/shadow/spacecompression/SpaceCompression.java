package net.shadow.spacecompression;

import net.fabricmc.api.ModInitializer;

import net.shadow.spacecompression.Block.ModBlocks;
import net.shadow.spacecompression.item.ModItemGroups;
import net.shadow.spacecompression.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpaceCompression implements ModInitializer {
	public static final String MOD_ID = "space-compression";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		LOGGER.info("Hello Fabric world!");
	}
}