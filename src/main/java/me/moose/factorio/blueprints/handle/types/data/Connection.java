package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
//https://wiki.factorio.com/Blueprint_string_format#Connection_object
public class Connection {
    private JsonObject json;
    private ConnectionPoint one;
    private ConnectionPoint two;
    public Connection(JsonObject json) {
        int keys= json.getAsJsonArray().size();
        if(keys > 0) {
            one = new ConnectionPoint(json.getAsJsonArray().get(0).getAsJsonObject());
        }
        if(keys > 1) {
            two = new ConnectionPoint(json.getAsJsonArray().get(1).getAsJsonObject());
        }
    }
}
