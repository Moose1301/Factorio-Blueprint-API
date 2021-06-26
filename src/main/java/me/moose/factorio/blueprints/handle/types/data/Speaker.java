package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Speaker {
    private JsonObject json;
    private float playback_volume;
    private boolean playback_globally;
    private boolean allow_polyphony;
    public Speaker(JsonObject json) {
        this.json = json;
        if(json.has("playback_volume")){
            this.playback_volume = json.get("playback_volume").getAsFloat();
        }
        if(json.has("playback_globally")){
            this.playback_globally = json.get("playback_globally").getAsBoolean();
        }
        if(json.has("allow_polyphony")){
            this.allow_polyphony = json.get("allow_polyphony").getAsBoolean();
        }
    }
}
