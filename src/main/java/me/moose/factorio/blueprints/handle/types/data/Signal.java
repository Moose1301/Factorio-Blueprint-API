package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
//Used for Condition
////https://wiki.factorio.com/Blueprint_string_format#Wait_Condition_object (condition key)
public class Signal {
    private JsonObject json;
    private String type;
    private String name;
    public Signal(JsonObject json) {
        this.json = json;
        type = json.get("type").getAsString();
        name = json.get("name").getAsString();

    }
}
