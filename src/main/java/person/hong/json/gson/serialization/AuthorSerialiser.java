package person.hong.json.gson.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class AuthorSerialiser implements JsonSerializer<Author> {

    public JsonElement serialize(Author author, Type typeOfSrc, JsonSerializationContext context) {
        System.err.println("调用了author的序列化器");

        final JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty("id", author.getId());
        jsonObj.addProperty("name", author.getName());

        return jsonObj;
    }

}
