package me.moose.factorio.blueprints;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
//From https://github.com/Shuriken255/factorio-blueprint-api/blob/master/src/ua/kiev/shuriken/blueprint/BlueprintParser.java
public class BlueprintParser {
    private static int bufferSize = 1024*512; //Changed to support bigger bps (Will still break if big enough)

    /**
     * Returns buffer's size in bytes that is used for converting
     * as blueprint strings into JSON, as JSON into blueprint strings.
     * @return Buffer's size in bytes.
     */
    public static int getBufferSize() {
        return bufferSize;
    }

    /**
     * Changes buffer's size that is used for conversion between blueprint strings and JSON.
     * @param bufferSize Buffer size in bytes
     */
    public static void setBufferSize(int bufferSize) {
        BlueprintParser.bufferSize = bufferSize;
    }

    /**
     * Converts blueprint string to representation of blueprint in JSON.
     * @param blueprint Factorio's blueprint string.
     * @return JSON representation of blueprint.
     */
    public static String fromBlueprintStringToJSON(String blueprint) {
        try {
            blueprint = blueprint.substring(1, blueprint.length());

            Decoder decoder = Base64.getDecoder();
            byte[] decodedByteArray = decoder.decode(blueprint);

            Inflater zDecoder = new Inflater();
            byte[] encodedByteArray = new byte[bufferSize];
            zDecoder.setInput(decodedByteArray, 0, decodedByteArray.length);
            int resultLength = zDecoder.inflate(encodedByteArray);
            zDecoder.end();

            return new String(encodedByteArray, 0, resultLength, "ASCII");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Converts representation of blueprint in JSON to blueprint string.
     * @param json blueprint's representation in JSON.
     * @return Blueprint string.
     */
    public static String fromJSONToBlueprintString(String json) {
        try {
            Deflater zEncoder = new Deflater();
            byte[] stringBytes = json.getBytes(StandardCharsets.US_ASCII);

            zEncoder.setInput(stringBytes);
            zEncoder.finish();
            byte[] encodedBytes = new byte[bufferSize];
            int size = zEncoder.deflate(encodedBytes, 0, bufferSize);
            zEncoder.end();

            Encoder encoder = Base64.getEncoder();

            return "0" + encoder.encodeToString(Arrays.copyOfRange(encodedBytes, 0, size));
        } catch (Exception e) {
            return null;
        }
    }

}
