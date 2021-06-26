package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
//https://wiki.factorio.com/Blueprint_string_format#Speaker_alert_parameter_object
public class SpeakerAlert {
    private JsonObject json;
    private boolean show_alert;
    private boolean show_on_map;
    private SignalID icon_signal_id;
    private String alert_message;
    public SpeakerAlert(JsonObject json) {
        this.json = json;
        if(json.has("show_alert")){
            this.show_alert = json.get("show_alert").getAsBoolean();
        }
        if(json.has("show_on_map")){
            this.show_on_map = json.get("show_on_map").getAsBoolean();
        }
        if(json.has("icon_signal_id")){
            icon_signal_id = new SignalID(json.get("icon_signal_id").getAsJsonObject());
        }
        if(json.has("alert_message")){
            this.alert_message = json.get("alert_message").getAsString();
        }
    }
}
