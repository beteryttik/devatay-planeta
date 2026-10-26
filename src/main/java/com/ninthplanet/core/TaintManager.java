package com.ninthplanet.core;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Заражение (taint) хранится на уровне чанка, а не каждого блока — так быстрее.
 * Уровень 0..N: влияет на спавн химер, визуальные частицы и уязвимость базы.
 */
public class TaintManager {
    public static void init() {
        //TODO: регистрация attachment/chunk-компоненты для taint-уровня
    }

    /** Уровень заражения чанка (0 = чисто, 2+ = химеры, 4+ = критично). */
    public static int getTaintLevel(World world, BlockPos pos) {
        //TODO: читать из PersistentState чанка
        return 0;
    }

    public static void addTaint(World world, BlockPos pos, int amount) {
        //TODO: повысить taint_level чанка, пометить блоки тегом ninthplanet:chimaera_taint
    }

    /** Очистка «нейтрализующим порошком». */
    public static void clearTaint(World world, BlockPos pos) {
        //TODO: сброс taint_level, эффект частиц очищения
    }
}
