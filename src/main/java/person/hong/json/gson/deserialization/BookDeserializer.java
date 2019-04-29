package person.hong.json.gson.deserialization;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class BookDeserializer implements JsonDeserializer<Book> {

	public Book deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject jsonObj = json.getAsJsonObject();
		
		Book book = new Book();
		book.setTitle(jsonObj.get("title").getAsString());
		book.setIsbn10(jsonObj.get("isbn-10").getAsString());
		book.setIsbn13(jsonObj.get("isbn-13").getAsString());
		JsonArray jsonArr = jsonObj.get("authors").getAsJsonArray();
		int size = jsonArr.size();
		String[] authors = new String[size];
		for (int i=0; i<size; i++) {
			authors[i] = jsonArr.get(i).getAsString();
		}
		book.setAuthors(authors);
		return book;
	}

}
