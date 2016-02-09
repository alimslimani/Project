import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Created by slima_000 on 26/01/2016.
 */
public class SerializerBuffer {
    ByteBuffer buff ;

    public SerializerBuffer(int i) {
        buff = ByteBuffer.allocateDirect(i);
    }

    public void writeInt(int i){
        buff.putInt(i);
    }
    public void writeFloat(float f){
        buff.putFloat(f);
    }
    public int readInt(){
        return buff.getInt();
    }

    public float readFloat(){
        return buff.getFloat();
    }

    public void writeString(String s){
        Charset c = Charset.forName("UTF-8");
        ByteBuffer ce = c.encode(s);
        buff.putInt(ce.remaining());
        buff.put(ce);
    }

    public String readString(){
        int size = buff.getInt();
        int limit = buff.limit();
        Charset c = Charset.forName("UTF-8");
        buff.limit(buff.position()+size);
        String s = c.decode(buff).toString();
        return s;
    }

    public void writeMySerialisable(MySerialisable mySerialisable) {

    }

    public <T extends MySerialisable> T readMySerialisable(Creator<T> tCreator) {
        return null;
    }

}
