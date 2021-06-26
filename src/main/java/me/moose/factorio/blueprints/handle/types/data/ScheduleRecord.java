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
public class ScheduleRecord {
    private JsonObject json;
    private String station;
    private List<WaitConditions> wait_conditions = new ArrayList<>();
    public ScheduleRecord(JsonObject json) {
        this.json = json;
        if (json.has("station")) {
            station= json.get("station").getAsString();
        }
        if (json.has("wait_conditions")) {
           json.get("wait_conditions").getAsJsonArray().forEach(condition -> {
               wait_conditions.add(new WaitConditions(condition.getAsJsonObject()));
           });
        }
    }
}
