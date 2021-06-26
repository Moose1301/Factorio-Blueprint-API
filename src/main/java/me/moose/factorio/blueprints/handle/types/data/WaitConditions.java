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
public class WaitConditions {
    private JsonObject json;
    private String type;
    private String compare_type;
    private int ticks;
    private List<Condition> conditions = new ArrayList<>();
    public WaitConditions(JsonObject json) {
        if(json.has("compare_type")) {
            compare_type = json.get("compare_type").getAsString();
        }
        if(json.has("type")) {
            type = json.get("type").getAsString();
        }
        if(json.has("ticks")) {
            ticks = json.get("ticks").getAsInt();
        }
        if(json.has("condition")) {
            json.get("condition").getAsJsonArray().forEach(condition -> {
                conditions.add(new Condition(condition.getAsJsonObject()));
            });
        }
    }

}
