package samebutdifferent.verdure.data;

import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.apache.commons.lang3.text.WordUtils;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureItems;

import java.util.function.Supplier;

public class LangGenerator extends LanguageProvider {

    public LangGenerator(PackOutput gen, String locale) {
        super(gen, Verdure.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + Verdure.MOD_ID, "Verdure");
        for (DeferredHolder<Item, ? extends Item> item : VerdureItems.ITEMS.getEntries()) {
            addItem(item, formatId(item));
        }
    }

    private String formatId(DeferredHolder<Item, ? extends Item> object) {
        return WordUtils.capitalize(object.getId().getPath().replace("_", " "));
    }

    public void addEntitySoundEvents(String key, String name, String ambientSoundWord) {
        add(Verdure.MOD_ID + ".subtitles." + key + ".ambient", name + " " + ambientSoundWord);
        add(Verdure.MOD_ID + ".subtitles." + key + ".death", name + " dies");
        add(Verdure.MOD_ID + ".subtitles." + key + ".hurt", name + " hurts");
    }

    public void addSoundEvent(Supplier<? extends SoundEvent> key, String subtitle) {
        add(Verdure.MOD_ID + ".subtitles." + key.get().getLocation().getPath(), subtitle);
    }

}
