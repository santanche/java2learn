package lib.casa.anima.util;

import java.net.MalformedURLException;
import java.net.URL;

public class IOUtil
{
  public static URL findURL(String sourceName) throws MalformedURLException
  {
    URL result = null;
    try {
      result = new URL(sourceName);
    } catch (MalformedURLException error) {
      result = new URL ("file", null, sourceName);
    }
    return result;
  }

  public static URL findURLWithoutException(String sourceName)
  {
    URL result = null;
    try {
      result = findURL(sourceName);
    } catch (MalformedURLException error) {
      /* nothing */
    }
    return result;
  }

  public static String extractPath(String filePath)
  {
    int div = Math.max(filePath.lastIndexOf('\\'), filePath.lastIndexOf('/'));
    return (div == -1) ? null : filePath.substring(0, div + 1);
  }

  public static String extractFileName(String filePath)
  {
    int div = Math.max(filePath.lastIndexOf('\\'), filePath.lastIndexOf('/'));
    return (div == -1) ? filePath : filePath.substring(div + 1);
  }
}