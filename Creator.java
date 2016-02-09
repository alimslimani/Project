/**
 * Created by slima_000 on 09/02/2016.
 */
public interface Creator <T extends MySerialisable> {
    public abstract T init();
}
