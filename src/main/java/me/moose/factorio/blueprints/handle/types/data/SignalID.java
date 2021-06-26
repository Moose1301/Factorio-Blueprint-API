package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
//https://wiki.factorio.com/Blueprint_string_format#SignalID_object
public class SignalID {
    private JsonObject json;
    private String type;
    private String name;
    public SignalID(JsonObject json) {
        this.json = json;
        if(json.has("type")) {
            type = json.get("type").getAsString();
        }
        if(json.has("name")) {
            name = json.get("name").getAsString();
        }
    }

}
