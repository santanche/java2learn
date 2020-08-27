package pt.c06patterns.builder.sax;

// Interfaces SAX
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

class ErroSAX implements ErrorHandler
{
  public void error(SAXParseException error) throws SAXParseException
  {
    System.out.println ("** Erro"
              + ", linha " + error.getLineNumber ()
              + ", URI " + error.getSystemId ());
    System.out.println("   " + error.getMessage ());
    throw error;
  }

  public void fatalError(SAXParseException error) throws SAXParseException
  {
    System.out.println ("** Erro Fatal"
              + ", linha " + error.getLineNumber ()
              + ", URI " + error.getSystemId ());
    System.out.println("   " + error.getMessage ());
    throw error;
  }

  public void warning(SAXParseException error) throws SAXParseException
  {
    System.out.println ("** Advertencia"
              + ", linha " + error.getLineNumber ()
              + ", URI " + error.getSystemId ());
    System.out.println("   " + error.getMessage ());
  }
}

