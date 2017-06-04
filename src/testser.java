import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by luoyinfeng on 6/3/17.
 */
public class testser implements JsonSerializer<test> {
    @Override
    public JsonElement serialize(test test, Type type, JsonSerializationContext jsonSerializationContext) {
        final JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("id", test.id);
        //System.out.println("\nid:"+test.id);
            final JsonArray jsonAuthorsArray = new JsonArray();
            for (final String author : test.environments) {
                //System.out.print("\n\ndsad:"+author);
                final JsonPrimitive jsonAuthor = new JsonPrimitive(author);
                jsonAuthorsArray.add(jsonAuthor);
            }
            jsonObject.add("environments", jsonAuthorsArray);

        return jsonObject;
    }
}
