package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @Getter @Setter
//https://wiki.factorio.com/Blueprint_string_format#Connection_point_object
public class ConnectionPoint {
    private JsonObject json;
    private List<ConnectionData> red = new ArrayList<>();
    private List<ConnectionData> green = new ArrayList<>();
    public ConnectionPoint(JsonObject json) {
        this.json = json;
        if(json.has("red")) {
            json.get("red").getAsJsonArray().forEach(data -> {
                red.add(new ConnectionData(data.getAsJsonObject()));
            });
        }
        if(json.has("green")) {
            json.get("green").getAsJsonArray().forEach(data -> {
                green.add(new ConnectionData(data.getAsJsonObject()));
            });
        }
    }
}
