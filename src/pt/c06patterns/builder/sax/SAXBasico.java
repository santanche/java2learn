package pt.c06patterns.builder.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SAXBasico extends org.xml.sax.helpers.DefaultHandler
{
  private String identa = "";

  public SAXBasico()
  {
  }

  public void inicia(String nomeArquivo)
  {
    try {
      // instancia uma Factory para SAXParser
      // (objeto fábrica produtor de objetos SAXParser)
      SAXParserFactory spf = SAXParserFactory.newInstance();

      // a Factory produz um objeto SAXParser
      SAXParser sp = spf.newSAXParser();

      // captura leitor XML do parser SAX
      XMLReader xr = sp.getXMLReader();

      // determina que este programa respondera os eventos SAX
      xr.setContentHandler(this);

      // cria um objeto de tratamento de erro
      // e determina que ele respondera aos erros SAX
      ErroSAX es = new ErroSAX();
      xr.setErrorHandler(es);

      // inicia processo de rastreamento
      xr.parse("file:" + nomeArquivo);
    } catch (ParserConfigurationException erro) {
      System.out.println("Erro na configuração do Parser.");
    } catch (SAXException erro) {
      System.out.println("Erro leitura do documento XML (SAX)");
    } catch (IOException erro) {
      System.out.println("Erro na leitura do arquivo");
    }
  }

  // acionado quando o documento inicia
  public void startDocument() throws SAXException
  {
    System.out.println("========== Inicio do Documento ==========");
  }

  // acionado cada vez que um elemento inicia
  public void startElement(String namespaceURI, String localName,
                           String qName, Attributes atributos) throws SAXException
  {
    System.out.println(identa + "Inicio de elemento: " + qName);

    if ((atributos != null) && (atributos.getLength() > 0)) {
      System.out.print(identa + "(atributos): ");
      int quantidade = atributos.getLength();
      for (int j = 0; j < quantidade; j++)
        System.out.print(atributos.getQName(j) + "=" +
                         atributos.getValue(j) + "; ");
      System.out.println();
    }

    identa += "  ";
  }

  // acionado cada vez que se encontra um nó texto
  public void characters (char ch[], int inicio, int tamanho) throws SAXException
  {
    String s = new String(ch, inicio, tamanho);
    if (!vazio(s))
      System.out.println(identa + "Texto: "+s);
  }

  // acionado cada vez que um elemento termina
  public void endElement(String namespaceURI, String localName, String qName)
                        throws SAXException
  {
    identa = identa.substring(2);
    System.out.println(identa + "Final de elemento : " + qName);
  }

  // acionado quando o documento inicia
  public void endDocument() throws SAXException
  {
    System.out.println("========== Final do Documento ==========");
  }

  // ===

  // metodo auxiliar
  public static boolean vazio(String conteudo)
  {
    boolean saoEspacos = true;
    int tamanho = conteudo.length();
    for (int i = 0; i < tamanho; i++)
      if (conteudo.charAt(i) != ' ' && conteudo.charAt(i) != '\n')
        saoEspacos = false;
    return saoEspacos;
  }
}

