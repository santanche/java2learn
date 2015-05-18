package lib.casa.anima.util;

public class ArrayUtil
{
  public static int sequencialSearch(String searchArray[], String key)
  {
    int p = -1;
    if (searchArray != null && key != null) {
      for (int i = 0; i < searchArray.length && p == -1; i++)
        if (key.equals(searchArray[i]))
          p = i;
    }
    return p;
  }

  public static int sequencialSearchIgnoreCase(String searchArray[], String key)
  {
    int p = -1;
    if (searchArray != null && key != null) {
      for (int i = 0; i < searchArray.length && p == -1; i++)
        if (key.equalsIgnoreCase(searchArray[i]))
          p = i;
    }
    return p;
  }
}