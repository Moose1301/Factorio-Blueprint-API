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
public class InfinitySettings {
    private JsonObject json;
    private boolean remove_unfiltered_items;
    private List<InfinityFilter> filters = new ArrayList<>();
    public InfinitySettings(JsonObject json) {
        this.json = json;
        if(json.has("remove_unfiltered_items")){
            this.remove_unfiltered_items = json.get("remove_unfiltered_items").getAsBoolean();
        }
        if(json.has("filters")) {
            json.get("filters").getAsJsonArray().forEach(filter -> {
                filters.add(new InfinityFilter(filter.getAsJsonObject()));
            });
        }

    }
}
