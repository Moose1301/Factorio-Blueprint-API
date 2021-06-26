package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class InfinityFilter {
    private JsonObject json;
    private String name;
    private int count;
    private String mode;
    private int index;
    public InfinityFilter(JsonObject json) {
        this.json = json;
        if(json.has("name")){
            this.name = json.get("name").getAsString();
        }
        if(json.has("count")) {
            this.count = json.get("count").getAsInt();
        }
        if(json.has("mode")) {
            this.mode = json.get("mode").getAsString();
        }
        if(json.has("index")) {
            this.index = json.get("index").getAsInt();
        }
    }
}
