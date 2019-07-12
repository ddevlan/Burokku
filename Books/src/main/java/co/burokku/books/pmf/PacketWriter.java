package co.burokku.books.pmf;

import com.google.common.base.Charsets;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

/**
 * Created by iKeirNez on 12/12/13.
 */
public class PacketWriter {

    private final StandardPacket packet;

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

    /**
     * Creates a new instance of this class
     * @param packet The packet that is writing to this instance
     */
    public PacketWriter(StandardPacket packet){
        this.packet = packet;

        if (!(packet instanceof RawPacket)){
            try {
                dataOutputStream.writeUTF(packet.getClass().getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public byte[] toByteArray(){
        return byteArrayOutputStream.toByteArray();
    }

    //  DataOutputStream methods

    public void write(int i) throws IOException {
        dataOutputStream.write(i);
    }

    public void write(byte[] bytes) throws IOException {
        dataOutputStream.write(bytes);
    }

    public void writeShort(short value) throws IOException {
        dataOutputStream.writeShort(value);
    }

    public void writeUTF(String value) throws IOException {
        dataOutputStream.writeUTF(value);
    }

    public byte[] getVarInt(int value) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        while ((value & -128) != 0) {
            out.write(value & 127 | 128);
            value >>>= 7;
        }

        out.write(value);
        out.close();

        return out.toByteArray();
    }

    public byte[] getStringBytes(String value) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] data = value.getBytes(StandardCharsets.UTF_8);
        out.write(getVarInt(data.length));
        out.write(data);
        out.close();

        return out.toByteArray();
    }

    public void writeInt(int value) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(outputStream);

        out.writeInt(value);

        out.close();
        outputStream.close();

        dataOutputStream.write(outputStream.toByteArray());
    }

    public void writeString(String value) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] data = value.getBytes(StandardCharsets.UTF_8);
        out.write(getVarInt(data.length));
        out.write(data);
        out.close();

        dataOutputStream.write(out.toByteArray());
    }

    public void writeBoolean(boolean value) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(outputStream);

        out.writeBoolean(value);

        out.close();
        outputStream.close();

        dataOutputStream.write(outputStream.toByteArray());
    }

    public void writeShort(int v) throws IOException {
        dataOutputStream.writeInt(v);
    }

    public void writeStrings(String[] tags) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        for (String tag : tags) {
            byte[] data = tag.getBytes(StandardCharsets.UTF_8);
            out.write(getVarInt(data.length));
            out.write(data);
        }
        out.close();

        dataOutputStream.write(out.toByteArray());
    }
}
