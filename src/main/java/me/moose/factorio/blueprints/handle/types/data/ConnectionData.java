package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ConnectionData {
    private JsonObject json;
    private int entity_id;
    private int circuit_id;
    public ConnectionData(JsonObject json) {
        if(json.has("entity_id")) {
            this.entity_id = json.get("entity_id").getAsInt();
        }
        if(json.has("circuit_id")) {
            this.circuit_id = json.get("circuit_id").getAsInt();
        }
    }
}
