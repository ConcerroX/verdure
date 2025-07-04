package samebutdifferent.verdure.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.Tags;
import samebutdifferent.verdure.Verdure;

public class VerdureTags {

    public static class Biomes {

        public static final TagKey<Biome> HAS_PEBBLES = create("has_pebbles");
        public static final TagKey<Biome> HAS_PATCH_CLOVER = create("has_patch_clover");
        public static final TagKey<Biome> HAS_PATCH_DAISIES = create("has_patch_daisies");
        public static final TagKey<Biome> HAS_PATCH_WILDFLOWERS = create("has_patch_wildflowers");

        public static final TagKey<Biome> HAS_BOULDER_STONE = create("has_boulder_stone");
        public static final TagKey<Biome> HAS_BOULDER_DIORITE = create("has_boulder_diorite");
        public static final TagKey<Biome> HAS_BOULDER_GRANITE = create("has_boulder_granite");
        public static final TagKey<Biome> HAS_BOULDER_ANDESITE = create("has_boulder_andesite");
        public static final TagKey<Biome> HAS_BOULDER_SLATE = create("has_boulder_slate");

        private static TagKey<Biome> create(String path) {
            return TagKey.create(Registries.BIOME, Verdure.res(path));
        }

    }

}