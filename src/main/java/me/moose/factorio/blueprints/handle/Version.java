package me.moose.factorio.blueprints.handle;

import lombok.Getter;

import java.nio.ByteBuffer;
//https://wiki.factorio.com/Version_string_format
/*
Each version number is 2 bytes so we get the second byte of that number.

Major: [1]
Minor: [3]
Patch: [5]
Developer Version Number: [7]
EG:

Version Long: 281479273971713
Would Be
Major: 1
Minor: 3
Patch: 35
Developer Version Number: 1

 */
@Getter
public class Version {
    private long version;
    private String major;
    private String minor;
    private String patch;
    private String devVer;
    public Version(long version) {
        this.version = version;
        byte[] bytes = longToBytes(version);
        major = ""+  bytes[1];
        minor = ""+ bytes[3];
        patch = ""+ bytes[5];
        devVer = ""+ bytes[7];
    }
    public byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }
    @Override
    public String toString() {
        return major + "." + minor + "." + patch;
    }

}
