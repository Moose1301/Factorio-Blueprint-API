package me.moose.factorio.blueprints.handle.types;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.moose.factorio.blueprints.BlueprintHandler;
import me.moose.factorio.blueprints.handle.types.data.Icon;
import me.moose.factorio.blueprints.handle.Version;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BlueprintBook  implements BPType {
    private JsonObject json;
    private String label;
    private String description;
    private List<Icon> icons = new ArrayList<>();
    private List<Blueprint> blueprints= new ArrayList<>();
    private List<BlueprintBook> blueprintBooks= new ArrayList<>();
    private List<DeconstructionPlanner> deconstructionPlanners = new ArrayList<>();
    private int active_index;
    private Version version;

    public BlueprintBook(JsonObject inputJson) {
        this.json = inputJson.get("blueprint_book").getAsJsonObject();
        if(json.has("icons")) {
            json.get("icons").getAsJsonArray().forEach(icon -> {
                icons.add(new Icon(icon.getAsJsonObject()));
            });
           debug("Loaded " + icons.size() + " icon(s)");
        } else {
           debug("No Icon Found");
        }
        if(json.has("active_index")) {
            active_index = json.get("active_index").getAsInt();
        }
        if(json.has("label")) {
            label = json.get("label").getAsString();
           debug("Got Label: " + label);
        } else {
           debug("No Label Found");
        }
        if(json.has("description")) {
            description = json.get("description").getAsString();
            debug("Got Description: " + description);
        }
        if(json.has("version")) {
            long versionLong = json.get("version").getAsLong();
            version = new Version(versionLong);
        }
        if(json.has("blueprints")) {
            json.get("blueprints").getAsJsonArray().forEach(blueprint -> {
                if(blueprint.getAsJsonObject().has("blueprint_book")) {
                    blueprintBooks.add(new BlueprintBook(blueprint.getAsJsonObject()));
                    System.out.println(" ");

                    debug("Loaded Book " + blueprints.size());

                } else if(blueprint.getAsJsonObject().has("deconstruction_planner")) {
                    System.out.println(" ");
                    deconstructionPlanners.add(new DeconstructionPlanner(blueprint.getAsJsonObject()));
                   debug("Loaded Deconstruction Planner " + deconstructionPlanners.size());
                } else{
                    blueprints.add(new Blueprint(blueprint.getAsJsonObject()));
                   debug("Loaded Blueprint " + blueprints.size());
                }

            });
            System.out.println("[BP Book] Loaded " + blueprints.size() + " blueprint(s)");
            if(blueprintBooks.size() != 0)
                System.out.println("[BP Book] Loaded " + blueprintBooks.size() + " book(s)");
            if(deconstructionPlanners.size() != 0)
                System.out.println("[BP Book] Loaded " + deconstructionPlanners.size() + " Deconstruction Planner(s)");
        }
    }
    private void debug(String message) {
        if(BlueprintHandler.debug)
            System.out.println("[BP Book] " + message);
    }

    @Override
    public String getName() {
        if(label == null) {
            return "Unnammed Book";
        }
        return label;
    }

    @Override
    public String getType() {
        return "Blueprint Book";
    }
}
