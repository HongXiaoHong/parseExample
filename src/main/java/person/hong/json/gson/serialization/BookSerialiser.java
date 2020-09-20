package person.hong.json.gson.serialization;

import com.google.gson.*;

import java.lang.reflect.Type;

public class BookSerialiser implements JsonSerializer<Book> {

    public JsonElement serialize(Book book, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty("title", book.getTitle());
        jsonObj.addProperty("isbn-10", book.getIsbn10());
        jsonObj.addProperty("isbn-13", book.getIsbn13());
        final JsonArray authors = new JsonArray();
        String[] arr = book.getAuthors();
        for (String author : arr) {
            authors.add(author);
        }
        jsonObj.add("authors", authors);

        return jsonObj;
    }

}
