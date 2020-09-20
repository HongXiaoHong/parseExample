package person.hong.json.gson.deserialization;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class EBookDeserializer implements JsonDeserializer<EBook> {

	public EBook deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject jsonObj = json.getAsJsonObject();
		
		EBook book = new EBook();
		book.setTitle(jsonObj.get("title").getAsString());
		book.setIsbn(jsonObj.get("isbn").getAsString());
		book.setAuthors(context.<Author[]>deserialize(jsonObj.get("authors"), Author[].class));
		return book;
	}

}
