package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
//Based off of blueprints in the examples folder
public class CircuitCondition {
    private JsonObject json;
    private List<Signal> signals = new ArrayList<>();
    private int constant;
    private String comparator;
    private String type;
    public CircuitCondition(JsonObject json) {
        this.json = json;
        if(json.has("constant")) {
            constant = json.get("constant").getAsInt();
        }
        if(json.has("comparator")) {
            comparator = json.get("comparator").getAsString();
        }
        if(json.has("type")) {
            type = json.get("type").getAsString();
        }
        json.getAsJsonArray().forEach(array -> {
            if(array.getAsJsonObject().has("name")) {
                signals.add(new Signal(array.getAsJsonObject()));
            }
        });


    }
}
