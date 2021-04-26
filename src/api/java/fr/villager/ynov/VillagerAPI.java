package fr.villager.ynov;

import java.lang.reflect.Field;

public enum VillagerAPI {

    ;


    private static final String API_CLASS_PATH = "fr.ynov.villager.api";

    private static final String INSTANCE_FIELD = "INSTANCE";

    private static IVillagerAPI API;

    static {
        try {
            final Class<?> apiClass = Class.forName(API_CLASS_PATH);
            final Field instanceField = apiClass.getDeclaredField(INSTANCE_FIELD);
            API = (IVillagerAPI) (instanceField.get(apiClass));
        } catch (final ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static IVillagerAPI instance() {
        return API;
    }
}
