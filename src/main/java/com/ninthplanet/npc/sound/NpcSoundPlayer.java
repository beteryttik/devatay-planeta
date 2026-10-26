package com.ninthplanet.npc.sound;

import com.ninthplanet.NinthPlanetMod;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;

/** Проигрывание голосовых реплик NPC из assets/ninthplanet/sounds/npc/<profile>/<фраза>.ogg. */
public class NpcSoundPlayer {
    public static void playPhrase(MobEntity npc, String profileId, String phraseId) {
        Identifier sound = NinthPlanetMod.id("npc." + profileId + "." + phraseId);
        npc.getWorld().playSound(null, npc.getBlockPos(),
                net.minecraft.sound.SoundEvent.of(sound), SoundCategory.PLAYERS, 1.0f, 1.0f);
        //TODO: профили и фразы — assets/ninthplanet/dialogues/profiles.json
    }
}
