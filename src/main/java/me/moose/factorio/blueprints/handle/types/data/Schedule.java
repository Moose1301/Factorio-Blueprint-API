package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private JsonObject json;
    private int[] locomotives;
    private List<ScheduleRecord> schedule = new ArrayList<>();
    public Schedule(JsonObject json) {
        this.json = json;
        if(json.has("neighbours")) {
            JsonArray array =  json.get("neighbours").getAsJsonArray();
            this.locomotives = new int[array.size()];
            final int[] i = {0};
            array.forEach(num -> {
                this.locomotives[i[0]]= num.getAsInt();
                i[0]++;
            });
        }
        if(json.has("schedule")) {
            json.get("schedule").getAsJsonArray().forEach(scheduled -> {
                schedule.add(new ScheduleRecord(scheduled.getAsJsonObject()));
            });
        }
    }
}
