/*
 * XML Type:  item
 * Namespace: 
 * Java type: noNamespace.Item
 *
 * Automatically generated - do not modify.
 */
package noNamespace;


/**
 * An XML item(@).
 *
 * This is a complex type.
 */
public interface Item extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Item.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAE1A342148EA1C780F146A7F77D558D5").resolveHandle("item28fctype");
    
    /**
     * Gets the "title" element
     */
    java.lang.String getTitle();
    
    /**
     * Gets (as xml) the "title" element
     */
    org.apache.xmlbeans.XmlString xgetTitle();
    
    /**
     * Sets the "title" element
     */
    void setTitle(java.lang.String title);
    
    /**
     * Sets (as xml) the "title" element
     */
    void xsetTitle(org.apache.xmlbeans.XmlString title);
    
    /**
     * Gets the "link" element
     */
    java.lang.String getLink();
    
    /**
     * Gets (as xml) the "link" element
     */
    org.apache.xmlbeans.XmlString xgetLink();
    
    /**
     * Sets the "link" element
     */
    void setLink(java.lang.String link);
    
    /**
     * Sets (as xml) the "link" element
     */
    void xsetLink(org.apache.xmlbeans.XmlString link);
    
    /**
     * Gets the "description" element
     */
    java.lang.String getDescription();
    
    /**
     * Gets (as xml) the "description" element
     */
    org.apache.xmlbeans.XmlString xgetDescription();
    
    /**
     * Sets the "description" element
     */
    void setDescription(java.lang.String description);
    
    /**
     * Sets (as xml) the "description" element
     */
    void xsetDescription(org.apache.xmlbeans.XmlString description);
    
    /**
     * Gets the "pubDate" element
     */
    java.lang.String getPubDate();
    
    /**
     * Gets (as xml) the "pubDate" element
     */
    org.apache.xmlbeans.XmlString xgetPubDate();
    
    /**
     * Sets the "pubDate" element
     */
    void setPubDate(java.lang.String pubDate);
    
    /**
     * Sets (as xml) the "pubDate" element
     */
    void xsetPubDate(org.apache.xmlbeans.XmlString pubDate);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static noNamespace.Item newInstance() {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static noNamespace.Item newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static noNamespace.Item parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static noNamespace.Item parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static noNamespace.Item parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static noNamespace.Item parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static noNamespace.Item parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static noNamespace.Item parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static noNamespace.Item parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static noNamespace.Item parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static noNamespace.Item parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static noNamespace.Item parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static noNamespace.Item parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static noNamespace.Item parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static noNamespace.Item parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static noNamespace.Item parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static noNamespace.Item parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static noNamespace.Item parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (noNamespace.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
