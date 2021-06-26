package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
//https://wiki.factorio.com/Blueprint_string_format#Tile_object
public class Tile {
    private JsonObject json;
    private Position position;
    private String name;


    public Tile(JsonObject json) {
        this.json = json;
        position = new Position(json.get("position").getAsJsonObject());
        name = json.get("name").getAsString();

    }
}
