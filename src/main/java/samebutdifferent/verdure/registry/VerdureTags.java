package samebutdifferent.verdure.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import samebutdifferent.verdure.Verdure;

public class VerdureTags {

    public static class Biomes {

        public static final TagKey<Biome> HAS_PEBBLES = create("has_pebbles");

        private static TagKey<Biome> create(String path) {
            return TagKey.create(Registries.BIOME, Verdure.res(path));
        }

    }

}