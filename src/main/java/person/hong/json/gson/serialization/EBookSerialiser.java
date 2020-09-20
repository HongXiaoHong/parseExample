package person.hong.json.gson.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class EBookSerialiser implements JsonSerializer<EBook> {

    public JsonElement serialize(EBook book, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty("title", book.getTitle());
        jsonObj.addProperty("isbn", book.getIsbn());
        final JsonElement authors = context.serialize(book.getAuthors());
        jsonObj.add("authors", authors);

        return jsonObj;
    }

}
