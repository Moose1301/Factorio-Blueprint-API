package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemFilter {
    private JsonObject json;
    private int index;
    private String name;
    public ItemFilter(JsonObject json) {
        this.json = json;
        if(json.has("index")){
            this.index = json.get("index").getAsInt();
        }
        if(json.has("name")){
            this.name = json.get("name").getAsString();
        }
    }
}
