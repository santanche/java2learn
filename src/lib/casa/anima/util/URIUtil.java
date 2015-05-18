package lib.casa.anima.util;

/**
 * A collection of URI related utils.
 *
 * @author Andre Santanche
 */
public class URIUtil
{
    /**
     * Verifies if a Resource URI is a prefix of a URI Identifier. If yes, removes
     * the Resource URI prefix from the URI Identifier.
     * 
     * @param idURI URI Identifier
     * @param resourceURI Resource URI
     * @return identifier extracted from the URI Identifier without the Resource URI or
     *         the entire URI Indentifier, if it fails in Resource URI extraction
     */
    public static String extractId(String idURI, String resourceURI)
    {
        String s = idURI;
        if (idURI != null && resourceURI != null)
        {
            int separator =
                (resourceURI.endsWith("#") || resourceURI.endsWith("/")) ? 0 : 1;
            if (idURI.startsWith(resourceURI))
                s = idURI.substring(resourceURI.length() + separator);
        }
        return s;
    }
    
    /**
     * Returns an identifier inside an URI Identifier, trying to distinguish the identifier inside
     * a URI using some heuristics, like find # or / characters separating the identifier from the
     * rest of the URI.
     * 
     * @param idURI URI Identifier
     * @return identifier extracted from the URI Identifier or the entire URI Indentifier,
     *         if it fails in the extraction
     */
    public static String extractId(String idURI)
    {
        String s = idURI;
        
        if (idURI != null)
        {
            int idStart = idURI.lastIndexOf('#');
            idStart = (idStart == -1) ? idURI.lastIndexOf('/') : idStart;
            if (idStart != -1)
                s = idURI.substring(idStart + 1);
        }
        
        return s;
    }

    /**
     * Returns an Resource URI inside an URI Identifier, trying to distinguish the identifier inside
     * a URI using some heuristics, like find # or / characters separating the identifier from the
     * rest of the URI.
     * 
     * @param idURI URI Identifier
     * @return resource URI extracted from the URI Identifier or the entire URI Indentifier,
     *         if it fails in the extraction
     */
    public static String extractResourceURI(String idURI)
    {
        String s = idURI;
        
        if (idURI != null)
        {
            int idStart = idURI.lastIndexOf('#');
            idStart = (idStart == -1) ? idURI.lastIndexOf('/') : idStart;
            if (idStart != -1)
                s = idURI.substring(0, idStart);
        }
        
        return s;
    }
}
