package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
//https://wiki.factorio.com/Blueprint_string_format#Color_object
public class Color {
    private float r;
    private float g;
    private float b;
    private float a;
    public Color(JsonObject json) {
        if(json.has("r")) {
            r = json.get("r").getAsFloat();
        }
        if(json.has("g")) {
            g = json.get("g").getAsFloat();
        }
        if(json.has("b")) {
            b = json.get("b").getAsFloat();
        }
        if(json.has("a")) {
            a = json.get("a").getAsFloat();
        }
    }
}
