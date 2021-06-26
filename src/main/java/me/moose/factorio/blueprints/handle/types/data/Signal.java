package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
