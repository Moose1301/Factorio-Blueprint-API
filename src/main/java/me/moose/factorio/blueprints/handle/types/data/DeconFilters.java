package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
//Based off of book/decoded.json#L2226
public class DeconFilters {
    private String name;
    private int index;
    public DeconFilters(JsonObject json) {
        if(json.has("name")) {
            name = json.get("name").getAsString();
        }
        if(json.has("index")) {
            index = json.get("index").getAsInt();
        }
    }
}
