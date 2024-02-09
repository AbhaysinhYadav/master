package code.core;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonFirstmethod {

//Method 1 : reply only one url from the given string

	public static String extractMediaUrlPath(String jsonString) {
		Gson gson = new Gson();
		JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);
		if (jsonArray != null && jsonArray.size() > 0) {
			JsonElement element = jsonArray.get(0);
			if (element.isJsonObject()) {
				JsonObject jsonObject = element.getAsJsonObject();
				if (jsonObject.has("mediaUrl")) {
					String mediaUrl = jsonObject.get("mediaUrl").getAsString();
					return mediaUrl.substring("https://storage.googleapis.com/".length());
				} else {
					return "No 'mediaUrl' found in the JSON.";
				}
			} else {
				return "Invalid JSON format.";
			}
		} else {
			return "Empty or invalid JSON array.";
		}
	}
}
