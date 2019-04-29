package person.hong.json.gson.serialization;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

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
