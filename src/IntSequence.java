public interface IntSequence {
  static IntSequence of(int... args) {
    return new IntSequence() {
      int[] arr;
      int i = 0;

      @Override
      public boolean hasNext() {
        return i != args.length;
      }

      @Override
      public int next() {
        if (!hasNext()) {
          return 0;
        }
        return args[i++];
      }
    };
  }

  boolean hasNext();

  int next();
}
