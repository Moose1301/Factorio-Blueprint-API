package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Pattern;

@Getter @Setter @NoArgsConstructor
//https://wiki.factorio.com/Blueprint_string_format#Icon_object
public class Icon {
    private JsonObject json;
    private int index;
    private SignalID signal;
    public Icon(JsonObject json) {
        this.json = json;
        if(json.has("index")){
            this.index = json.get("index").getAsInt();
        }
        if(json.has("signal")){
            signal = new SignalID(json.get("signal").getAsJsonObject());
        }
    }
}
