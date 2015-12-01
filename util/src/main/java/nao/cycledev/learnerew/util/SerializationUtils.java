package nao.cycledev.learnerew.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.util.Date;

public final class SerializationUtils {

    public static Gson getGson() {
        // Registers an adapter to manage the date types as long values
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) ->
                        new Date(json.getAsJsonPrimitive().getAsLong()))
                .create();
    }
}

