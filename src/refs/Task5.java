package refs;

import java.util.List;
import java.util.function.Function;

public class Task5 {
  public <T, R> Object[] map(List list, Function<T, R> function) {
    Object[] res = new Object[list.size()];
    int i = 0;
    for (Object el : list) {
      res[i++] = function.apply((T) el);
    }
    return res;
  }
}
