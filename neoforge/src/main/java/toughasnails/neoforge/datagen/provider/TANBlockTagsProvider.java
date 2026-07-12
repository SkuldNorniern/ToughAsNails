/*******************************************************************************
 * Copyright 2022, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package toughasnails.neoforge.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import toughasnails.api.block.TANBlocks;
import toughasnails.core.ToughAsNails;
import toughasnails.init.ModTags;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class TANBlockTagsProvider extends BlockTagsProvider
{
    public TANBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider, ToughAsNails.MOD_ID);
    }

    private static ResourceKey<Block> key(Block block)
    {
        return block.builtInRegistryHolder().key();
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        // Vanilla tags
        this.tag(BlockTags.MINEABLE_WITH_AXE).addAll(Stream.of(TANBlocks.RAIN_COLLECTOR, TANBlocks.WATER_PURIFIER).map(TANBlockTagsProvider::key));
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addAll(Stream.of(TANBlocks.THERMOREGULATOR, TANBlocks.TEMPERATURE_GAUGE).map(TANBlockTagsProvider::key));

        // TAN tags
        this.tag(ModTags.Blocks.COOLING_BLOCKS).addAll(Stream.of(Blocks.SOUL_FIRE, Blocks.SOUL_CAMPFIRE, Blocks.SOUL_LANTERN, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.POWDER_SNOW_CAULDRON).map(TANBlockTagsProvider::key));
        this.tag(ModTags.Blocks.HEATING_BLOCKS).addAll(Stream.of(Blocks.FIRE, Blocks.CAMPFIRE, Blocks.LANTERN, Blocks.LAVA, Blocks.MAGMA_BLOCK, Blocks.LAVA_CAULDRON).map(TANBlockTagsProvider::key));
        this.tag(ModTags.Blocks.PASSABLE_BLOCKS).addTags(BlockTags.DOORS, BlockTags.TRAPDOORS).add(key(Blocks.SCAFFOLDING));
    }
}
