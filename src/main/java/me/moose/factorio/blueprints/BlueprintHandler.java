package me.moose.factorio.blueprints;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import me.moose.factorio.blueprints.handle.types.BPType;
import me.moose.factorio.blueprints.handle.types.Blueprint;
import me.moose.factorio.blueprints.handle.types.BlueprintBook;


public class BlueprintHandler {
    private JsonParser parser;
    public static boolean debug = false;
    public void start() {
        parser = new JsonParser();
        BPType blueprint= null;
        try{
            System.out.println("Loading Blueprint");
            blueprint = getBlueprint("0eNqFkNFugzAMRf/Fz6FqoCxtfqVCFVC3swQOJWEbQvn3ObBWfdtTYis+5zoLNN2Ew0gcwC5ArWMP9ryApzvXXeqFeUCwQAF7UMB1n6rO3ckHarP2E33IRnxMcuIIUQHxFX/A6lgpQA4UCDfmWswXnvpGXlr9P03B4LwAHKckAs2OhdmVCma5fhx2peiaWlj5XsHf2OVGncxuymeWl+rbuSvyJhJ866a0ebmPVYq7Lmnf/kTBl6BWf37UB3PKTXEy2ugixl/rP2kG");
            System.out.println(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(
                "Loaded: " + blueprint.getName() +
                "\nDescription: " + (blueprint.getDescription() == null ? "None" : "\n" + blueprint.getDescription()) +
                "\nType: " + blueprint.getType() +
                "\nVersion: " + blueprint.getVersion().toString());
    }




    public BPType getBlueprint(String input) throws Exception {
      System.out.println(BlueprintParser.fromBlueprintStringToJSON(input));
       JsonElement bp = parser.parse(BlueprintParser.fromBlueprintStringToJSON(input));
        if(bp.getAsJsonObject().has("blueprint_book")) {
            return new BlueprintBook(bp.getAsJsonObject());
        } else {
            return new Blueprint(bp.getAsJsonObject());
        }



    }


}
