package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LogisticFilter {
    private JsonObject json;
    private int index;
    private String name;
    private int count;
    public LogisticFilter(JsonObject json) {
        this.json = json;
        if(json.has("index")){
            this.index = json.get("index").getAsInt();
        }
        if(json.has("name")){
            this.name = json.get("name").getAsString();
        }
        if(json.has("count")){
            this.count = json.get("count").getAsInt();
        }
    }
}
