package me.moose.factorio.blueprints;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import me.moose.factorio.blueprints.handle.types.BPType;
import me.moose.factorio.blueprints.handle.types.Blueprint;
import me.moose.factorio.blueprints.handle.types.BlueprintBook;

//https://wiki.factorio.com/Blueprint_string_format

public class BlueprintHandler {
    private JsonParser parser;
    public static boolean debug = false;
    public void start() {
        parser = new JsonParser();
        BPType blueprint= null;
        try{
            System.out.println("Loading Blueprint");
            blueprint = getBlueprint("0eNqV219q60YUBvCtCD3bqWZG88/Qp9JCoZf7cAOFJqHIicgVyJKR5EtDMHQHfe1Sup5uoFuobKdtoOeT53sIIWD/Io/P+aSZkV7zbXuo90PTTfnmNX+qx8eh2U9N3+Wb/D53Nzr78ON9nq2z26atq21bZ5/6thruu9uP2e33P3y7yT5+qYe22mfT5zrrD1M97PpxyqrHx8Pu0FZTP4w39919981QPzXTJvtQPf10GJp8lY9dtV9P/fp5aJ5O//yXfGPcKn85/Tqu8mo79u3srU+v2zfdc76ZhkO9ypvHvhvzzd1rPjbPXdWe3ju97Ov5iJup3s1yV+1Of42nI13vq65u8xlsuqd6/h/q+LDK625qpqa+MOc/Xn7uDrttPcwvEIFVvu/H5jIy52NVN/Z8sPPv43H1P0WnKeWyYtIUv6yUiZ+oWGZsImOWGfcv865IBOZSC4VE+EQiYCKkEbrAREwbD62Xx0MViY694iQWrg5XnMTSNVc6QCUWr7nSA6qkCkaLhqUqRjYcVTKy4blwKcGQBC5dEBO5eAGMLsh8QY4iAwY5iQWs3BUnsYBVvOKUZFAgx5JBgRxHBgVyPBkUyAlkUCAncs3lwTm34JoLMSotLvwFEQmdRsQFwiQGn1owSrIv0YhYsi+R48i+RI4n+xI5qdcSdmGMY6KxUC5lkWgs1EupyJ4GY1JqsqeRY5guiiLxrnwP23Gqzm8DTRTniUJXN8+ft/1hOE0PSr9SVj1IrqVaSz42R5WObPikz6c9+IDl/AFL8QMGqp7kgyMz+XSNIM49yFCGDpXKSokGFcvA4HIZIGwww1FhkxlCbDRDiM1mCHHhDAaaS2cZcVw8A4TNZzQujg1oCBmyww1wSrLDkWPJNRPkOHbVBEGpqxXmjRGRxDJWdglJLGPlFxCfWMYqLiGJMazVEpKYw3ppYL1hV1/A1+xLdvkFQZZtcQQ5tsURRFawjJAVLCNkBYtIICtYRsgKlhGygmUk8VLisiylnGgkrrHpJcOSAe7kaguODHDkeDbAERS48hcnViFy5S8i8b/KHfptv++HCa5hqiAKZNnKh0GWrYzQwQu+nkgHL4Lo4EVQ4qzutLAC2ykmhu7bnhlAApUNcslEKhuCvMfBzt8i2ixRZDpASLPxACXD5UOUlZILCKBYrr+B4rgGB4pnOxyOcGBbHEqR7XEkqYJrcrkvlOK6HCiaaXNdyIhh+hwhJdULWsmKpXoBKY66WESKp64WkRKovkRKpPoSKJqrXPBNa65ykaK51YPTeo8MGe4Eg6GSO8FgyJInGCw5rqmMrHiuqYASuKYCSuSaSlZMwTUVUBTXVEDR5MkOftvGkCc7LJXkyQ5LllxKwJIjG94iyJMND6HAbAlogERmTwAgqRt4b5sCSGFvo4AjU7I3UmCJvZUCS+zNFFiy1M4AGm1HbQ0gxVN7A0gJbL/DsYlsvyPJFlR3eRlRxBbubCRvcarUvbx/Wg4cn+FKCSgls5ErfEy4Va2s5eoLHCCb3QEVBZvdEOKyW56nWi67ZcSR2Q0UOrvRyDg6u6FEZzeU6OyGEpndYLTJ7AYKmd1AobMbjg2d3UjyBdfvBt3B6xXX7xjS3OQMQ4acnGGJvQkDS+xdGFhib8PAEnsfBpYCOUHCUiQnSFAKBdl0WFJk02GJXBEx8B5xckUEQ+SKCIbYFREsObbpoOSppwtMKSuBer4AKZF6wgAosWBbFj4eoNiWhZJmWxZKhm1ZKJVsy0LJcjXkZMVxNQQUz9XQrDysLg/Obd49DLjK22o7j8Ymv3vs2374Ws9TiNOPKvTDn7//+tcfv2WfdlXbZuvs8pTg5cHA7Ltq2GXzC+6+Or/vYZa+1MN4/sc6zBPdqL2Jfr4kMMfj36CDSyw=");
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
