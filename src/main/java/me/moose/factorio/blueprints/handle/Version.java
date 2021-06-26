package me.moose.factorio.blueprints.handle;

import lombok.Getter;

import java.nio.ByteBuffer;
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
