package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

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
