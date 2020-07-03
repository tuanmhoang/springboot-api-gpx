package com.tuanhm.gpxapp.customconfig;

import java.lang.reflect.Type;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GsonUtcDateAdapter implements JsonDeserializer<ZonedDateTime> {

	@Override
	public ZonedDateTime deserialize(JsonElement jsonElement, Type type,
			JsonDeserializationContext jsonDeserializationContext) {
		JsonObject jsonObj = jsonElement.getAsJsonObject();

		JsonObject dateTime = jsonObj.getAsJsonObject("dateTime");
		JsonObject date = dateTime.getAsJsonObject("date");
		int year = date.get("year").getAsInt();
		int month = date.get("month").getAsInt();
		int day = date.get("day").getAsInt();

		JsonObject time = dateTime.getAsJsonObject("time");
		int hour = time.get("hour").getAsInt();
		int minute = time.get("minute").getAsInt();
		int second = time.get("second").getAsInt();
		int nano = time.get("nano").getAsInt();

		JsonObject zone = jsonObj.getAsJsonObject("zone");
		if (zone.get("id") == null) {
			return ZonedDateTime.of(year, month, day, hour, minute, second, nano, ZoneId.of("UTC"));
		} else {
			String id = zone.get("id").getAsString();
			return ZonedDateTime.of(year, month, day, hour, minute, second, nano, ZoneId.of(id));
		}
	}

}
