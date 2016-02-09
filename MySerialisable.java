public interface MySerialisable {
    public void writeToBuff(SerializerBuffer ms);

    public void readFromBuff(SerializerBuffer ms );

    public interface Creator <T extends MySerialisable> {

    }
}
