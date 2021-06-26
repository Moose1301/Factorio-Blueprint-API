package me.moose.factorio.blueprints.handle.types;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.moose.factorio.blueprints.handle.types.data.DeconFilters;
import me.moose.factorio.blueprints.handle.Version;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//Based off of book/decoded.json#L2224
public class DeconstructionPlanner implements BPType {
    private JsonObject json;
    private String label;
    private List<DeconFilters> filtersList = new ArrayList<>();
    private int tile_selection_mode;
    private Version version;

    public DeconstructionPlanner(JsonObject inputJson) {
        this.json = inputJson;
        if (json.has("settings")) {
            JsonObject settings = json.get("settings").getAsJsonObject();
            if (settings.has("entity_filters")) {
                settings.get("entity_filters").getAsJsonArray().forEach(filter -> {
                    filtersList.add(new DeconFilters(filter.getAsJsonObject()));
                });
            }
            if (settings.has("tile_selection_mode")) {
                tile_selection_mode = settings.get("tile_selection_mode").getAsInt();
            }
        }
        if (json.has("version")) {
            long versionLong = json.get("version").getAsLong();
            version = new Version(versionLong);
        }

    }

    @Override
    public String getName() {
        if(label == null) {
            return "UnNammed Deconstruction Planner";
        }
        return label;
    }

    @Override
    public String getType() {
        return "Deconstruction Planner";
    }

    @Override
    public String getDescription() {
        return "";
    }
}