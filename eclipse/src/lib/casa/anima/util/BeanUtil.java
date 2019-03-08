package lib.casa.anima.util;

import java.beans.Beans;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class BeanUtil
{
  public static Object instantiateBean(String filePath)
                       throws ClassNotFoundException, IOException
  {
    // separate name of path
    /*
    int div = Math.max(fileClass.lastIndexOf('\\'), fileClass.lastIndexOf('/'));
    String path = fileClass.substring(0, div + 1),
           fileName = fileClass.substring(div + 1);
    */

    return instantiateBean(IOUtil.extractPath(filePath),
                           IOUtil.extractFileName(filePath));
  }

  public static Object instantiateBean(String path, String fileName)
                       throws ClassNotFoundException, IOException
  {
    String fileClass = fileName;
    if (fileClass.endsWith(".class"))
      fileClass = fileClass.substring(0, fileClass.length() - 6);

    Object theBean = null;

    URL source = null;
    URLClassLoader loader = null;
    if (path != null)
    {
      try {
        source = new URL(path);
      } catch (Exception e1) {
        try {
          source = new URL ("file", null, path);
        } catch (Exception e2) {
          source = null;
        }
      }
      if (source != null) {
        URL vp[] = {source};
        try {
          loader = new URLClassLoader(vp, ClassLoader.getSystemClassLoader());
        } catch (Exception e3) {
          loader = null;
        }
      }
    }

    try {
      theBean = Beans.instantiate(loader, fileClass);
    } catch (Exception e4) {
      if (loader != null)
        theBean = Beans.instantiate(null, fileClass);
    }

    return theBean;
  }
}