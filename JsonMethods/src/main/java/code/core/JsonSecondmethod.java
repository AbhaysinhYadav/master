package code.core;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonSecondmethod {

// Method 2 : return multiple path List<String>

	public static List<String> extractMediaUrlPaths(String jsonString) {
		List<String> mediaUrlPaths = new ArrayList<>();
		Gson gson = new Gson();
		JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);
		if (jsonArray != null && jsonArray.size() > 0) {
			for (JsonElement element : jsonArray) {
				if (element.isJsonObject()) {
					JsonObject jsonObject = element.getAsJsonObject();
					if (jsonObject.has("mediaUrl")) {
						String mediaUrl = jsonObject.get("mediaUrl").getAsString();
						mediaUrlPaths.add(mediaUrl.substring("https://storage.googleapis.com/".length()));
					}
				}
			}
		}
		return mediaUrlPaths;
	}

}
