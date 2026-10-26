package com.ninthplanet.core.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Простой JSON-конфиг: файл config/ninthplanet.json.
 * При отсутствии файла создаётся с дефолтами.
 */
public class ModConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Path.of("config", "ninthplanet.json");
    private static ModConfig instance;

    public final Map<String, Section> sections = new ConcurrentHashMap<>();

    public static ModConfig get() {
        if (instance == null) load();
        return instance;
    }

    public static void load() {
        try {
            if (Files.exists(PATH)) {
                instance = GSON.fromJson(Files.readString(PATH), ModConfig.class);
            } else {
                instance = new ModConfig();
                instance.sections.put("portal", PortalCycleConfig.defaults());
                instance.sections.put("base", BaseDefenseConfig.defaults());
                instance.sections.put("sky", com.ninthplanet.sky.SkyConfig.defaults());
                save();
            }
        } catch (IOException e) {
            instance = new ModConfig();
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(PATH.getParent());
            Files.writeString(PATH, GSON.toJson(instance));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Section section(String key) {
        return sections.computeIfAbsent(key, k -> new Section());
    }

    public static class Section {
        public double cycleMinutes = 15;
        public double windowSeconds = 180;
        public double warningSeconds = 120;
        public int maxGuards = 12;
        public double vulnerabilityGrowthPerMinute = 5;
        public double thresholdForWave = 100;
        public int moonsCount = 2;
        public int sunsCount = 2;
    }
}
