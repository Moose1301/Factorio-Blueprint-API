package me.moose.factorio.blueprints.handle.types.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter @Setter @NoArgsConstructor
//https://wiki.factorio.com/Blueprint_string_format#Entity_object
public class Entity {
    private JsonObject json;
    private Position position;
    private String name;
    private int entity_number;
    private int[] neightbours;
    private int direction;
    private float orientation;
    private Connection connections;
    private List<ItemRequest> items;
    private String recipe;
    private int bar;
    private Inventory inventory;
    private InfinitySettings infinitySettings;
    private String type;
    private String input_priority;
    private String output_priority;
    private String filter;
    private List<ItemFilter> filters;
    private String filter_mode;
    private int override_stack_size;
    private Position drop_position;
    private Position pickup_position;
    private LogisticFilter request_filters;
    private boolean request_from_buffers;
    private Speaker parameters;
    private SpeakerAlert alert_parameters;
    private boolean auto_launch;
    private Object variation;//What tf is this please help
    private Color color;
    private String station;


    public Entity(JsonObject json) {
        this.json = json;
        entity_number = json.get("entity_number").getAsInt();
        position = new Position(json.get("position").getAsJsonObject());
        name = json.get("name").getAsString();
        if(json.has("neighbours")) {
           JsonArray array =  json.get("neighbours").getAsJsonArray();
           neightbours = new int[array.size()];
            final int[] i = {0};
           array.forEach(num -> {
               neightbours[i[0]]= num.getAsInt();
               i[0]++;
           });
        }
        if(json.has("direction")) {
            direction = json.get("direction").getAsInt();
        }
        if(json.has("orientation")) {
            orientation = json.get("orientation").getAsFloat();
        }
        if (json.has("items")) {
            items = new ArrayList<>();
            json.get("items").getAsJsonArray().forEach(item -> {
                items.add(new ItemRequest(item.getAsJsonObject()));
            });
        }
        if(json.has("recipe")) {
            recipe = json.get("recipe").getAsString();
        }
        if(json.has("bar")) {
            bar = json.get("bar").getAsInt();
        }
        if(json.has("inventory")) {
            inventory = new Inventory(json.get("inventory").getAsJsonObject());
        }
        if (json.has("infinity_settings")) {
            infinitySettings = new InfinitySettings(json.get("infinity_settings").getAsJsonObject());
        }
        if(json.has("type")) {
            type = json.get("type").getAsString();
        }
        if(json.has("input_priority")) {
            input_priority = json.get("input_priority").getAsString();
        }
        if(json.has("output_priority")) {
            output_priority = json.get("output_priority").getAsString();
        }
        if(json.has("filter")) {
            filter = json.get("filter").getAsString();
        }
        if(json.has("filters")) {
            filters = new ArrayList<>();
            json.get("filters").getAsJsonArray().forEach(filter -> {
                filters.add(new ItemFilter(filter.getAsJsonObject()));
            });
        }
        if(json.has("filter_mode")) {
            filter_mode = json.get("filter_mode").getAsString();
        }
        if (json.has("override_stack_size")) {
            override_stack_size = json.get("override_stack_size").getAsInt();
        }
        if (json.has("drop_position")) {
            drop_position = new Position(json.get("drop_position").getAsJsonObject());
        }
        if (json.has("pickup_position")) {
            pickup_position  = new Position(json.get("pickup_position").getAsJsonObject());
        }
        if (json.has("request_filters")) {
            request_filters  = new LogisticFilter(json.get("request_filters").getAsJsonObject());
        }
        if(json.has("request_from_buffers")) {
            request_from_buffers = json.get("request_from_buffers").getAsBoolean();
        }
        if(json.has("parameters")) {
            parameters = new Speaker(json.get("parameters").getAsJsonObject());
        }
        if(json.has("alert_parameters")) {
            alert_parameters = new SpeakerAlert(json.get("alert_parameters").getAsJsonObject());
        }
        if(json.has("auto_launch")) {
            auto_launch = json.get("auto_launch").getAsBoolean();
        }
        if(json.has("color")) {
            color = new Color(json.get("color").getAsJsonObject());
        }
        if(json.has("station")) {
            station = json.get("station").getAsString();
        }

    }
}
