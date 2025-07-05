package samebutdifferent.verdure.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.feature.*;

public class VerdureFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE,
        Verdure.MOD_ID);

    public static final DeferredHolder<Feature<?>, DitheredDiskFeature> DITHERED_DISK = FEATURES.register(
        "dithered_disk", () -> new DitheredDiskFeature(DiskConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, FallenLogFeature> FALLEN_LOG = FEATURES.register("fallen_log",
        () -> new FallenLogFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, MushroomShelfFeature> MUSHROOM_SHELF = FEATURES.register(
        "mushroom_shelf", () -> new MushroomShelfFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, UndergroundMushroomShelfFeature> UNDERGROUND_MUSHROOM_SHELF = FEATURES.register(
        "underground_mushroom_shelf", () -> new UndergroundMushroomShelfFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, HangingMossFeature> HANGING_MOSS = FEATURES.register("hanging_moss",
        () -> new HangingMossFeature(SimpleBlockConfiguration.CODEC));

}
