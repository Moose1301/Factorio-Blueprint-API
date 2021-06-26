package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
//https://wiki.factorio.com/Blueprint_string_format#Inventory_object
public class Inventory {
    private JsonObject json;
    private int bar;
    private List<ItemFilter> filters;
    public Inventory(JsonObject json) {
        this.json = json;
        if(json.has("bar")){
            this.bar = json.get("bar").getAsInt();
        }
        if(json.has("filters")){
           json.get("filters").getAsJsonArray().forEach(filter -> {
               filters.add(new ItemFilter(filter.getAsJsonObject()));
           });

        }
    }
}
