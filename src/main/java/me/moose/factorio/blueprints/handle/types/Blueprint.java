package me.moose.factorio.blueprints.handle.types;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.moose.factorio.blueprints.BlueprintHandler;
import me.moose.factorio.blueprints.handle.types.data.Icon;
import me.moose.factorio.blueprints.handle.types.data.Entity;
import me.moose.factorio.blueprints.handle.types.data.Position;
import me.moose.factorio.blueprints.handle.Version;
import me.moose.factorio.blueprints.handle.types.data.Tile;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
//https://wiki.factorio.com/Blueprint_string_format#Blueprint_object
public class Blueprint implements BPType {
    private JsonObject json;
    private String label;
    private String description;
    private List<Icon> icons = new ArrayList<>();
    private List<Entity> items= new ArrayList<>();

    private List<Tile> tiles= new ArrayList<>();

    private Version version;

    private Position gridSnap;
    private boolean absolute_snapping;




    private int index; //For Books

    public Blueprint(JsonObject inputJson) {
        this.json = inputJson.get("blueprint").
                getAsJsonObject();
        if (inputJson.has("index")) {
            this.index = inputJson.get("index").getAsInt();
        }
        if(json.has("label")) {
            label = json.get("label").getAsString();
            debug("Got Label: " + label);
        } else {
            debug("No Label Found");
        }
        if(json.has("absolute-snapping")) {
            absolute_snapping = json.get("absolute-snapping").getAsBoolean();
        }
        if(json.has("description")) {
            description = json.get("description").getAsString();
            debug("Got Description: " + description);
        }
        if(json.has("snap-to-grid")) {
            gridSnap = new Position(json.get("snap-to-grid").getAsJsonObject());

        }
        if(json.has("icons")) {
            json.get("icons").getAsJsonArray().forEach(icon -> {
                icons.add(new Icon(icon.getAsJsonObject()));
            });
            debug("Loaded " + icons.size() + " icon(s)");
        } else {
            debug("No Icon Found");
        }
        if(json.has("entities")) {
            json.get("entities").getAsJsonArray().forEach(item -> items.add(new Entity(item.getAsJsonObject())));
            debug("Loaded " + items.size() + " entities");
        }
        if(json.has("tiles")) {
            json.get("tiles").getAsJsonArray().forEach(tile -> tiles.add(new Tile(tile.getAsJsonObject())));
            debug("Loaded " + tiles.size() + " tiles");
        }
        if(json.has("version")) {
            long versionLong = json.get("version").getAsLong();
            version = new Version(versionLong);
        }

    }
    private void debug(String message) {
        if(BlueprintHandler.debug)
            System.out.println("[BP] " + message);
    }


    @Override
    public String getName() {
        if(label == null) {
            return "Unnammed Blueprint";
        }
        return label;
    }

    @Override
    public String getType() {
        return "Blueprint";
    }
}
