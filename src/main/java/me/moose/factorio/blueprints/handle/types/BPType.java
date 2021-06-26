package me.moose.factorio.blueprints.handle.types;

import com.google.gson.JsonObject;
import me.moose.factorio.blueprints.handle.Version;

public interface BPType {
    String getName();
    String getType();
    String getDescription();
    JsonObject getJson();
    Version getVersion();
}
