package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
//https://wiki.factorio.com/Blueprint_string_format#Position_object
public class Position {
    private int x;
    private int y;
    public Position(JsonObject json) {
        if(json.has("x")) {
            x=  json.get("x").getAsInt();
        }
        if(json.has("y")) {
            y=  json.get("y").getAsInt();
        }

    }
}
