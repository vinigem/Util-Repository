/*
 * An XML document type.
 * Localname: rss
 * Namespace: 
 * Java type: noNamespace.RssDocument
 *
 * Automatically generated - do not modify.
 */
package noNamespace;


/**
 * A document containing one rss(@) element.
 *
 * This is a complex type.
 */
public interface RssDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RssDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAE1A342148EA1C780F146A7F77D558D5").resolveHandle("rssb339doctype");
    
    /**
     * Gets the "rss" element
     */
    noNamespace.RssDocument.Rss getRss();
    
    /**
     * Sets the "rss" element
     */
    void setRss(noNamespace.RssDocument.Rss rss);
    
    /**
     * Appends and returns a new empty "rss" element
     */
    noNamespace.RssDocument.Rss addNewRss();
    
    /**
     * An XML rss(@).
     *
     * This is a complex type.
     */
    public interface Rss extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Rss.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAE1A342148EA1C780F146A7F77D558D5").resolveHandle("rss2387elemtype");
        
        /**
         * Gets the "channel" element
         */
        noNamespace.RssDocument.Rss.Channel getChannel();
        
        /**
         * Sets the "channel" element
         */
        void setChannel(noNamespace.RssDocument.Rss.Channel channel);
        
        /**
         * Appends and returns a new empty "channel" element
         */
        noNamespace.RssDocument.Rss.Channel addNewChannel();
        
        /**
         * Gets the "version" attribute
         */
        java.math.BigDecimal getVersion();
        
        /**
         * Gets (as xml) the "version" attribute
         */
        org.apache.xmlbeans.XmlDecimal xgetVersion();
        
        /**
         * Sets the "version" attribute
         */
        void setVersion(java.math.BigDecimal version);
        
        /**
         * Sets (as xml) the "version" attribute
         */
        void xsetVersion(org.apache.xmlbeans.XmlDecimal version);
        
        /**
         * An XML channel(@).
         *
         * This is a complex type.
         */
        public interface Channel extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Channel.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAE1A342148EA1C780F146A7F77D558D5").resolveHandle("channele686elemtype");
            
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
             * Gets the "docs" element
             */
            java.lang.String getDocs();
            
            /**
             * Gets (as xml) the "docs" element
             */
            org.apache.xmlbeans.XmlString xgetDocs();
            
            /**
             * Sets the "docs" element
             */
            void setDocs(java.lang.String docs);
            
            /**
             * Sets (as xml) the "docs" element
             */
            void xsetDocs(org.apache.xmlbeans.XmlString docs);
            
            /**
             * Gets the "language" element
             */
            java.lang.String getLanguage();
            
            /**
             * Gets (as xml) the "language" element
             */
            org.apache.xmlbeans.XmlString xgetLanguage();
            
            /**
             * Sets the "language" element
             */
            void setLanguage(java.lang.String language);
            
            /**
             * Sets (as xml) the "language" element
             */
            void xsetLanguage(org.apache.xmlbeans.XmlString language);
            
            /**
             * Gets the "copyright" element
             */
            java.lang.String getCopyright();
            
            /**
             * Gets (as xml) the "copyright" element
             */
            org.apache.xmlbeans.XmlString xgetCopyright();
            
            /**
             * Sets the "copyright" element
             */
            void setCopyright(java.lang.String copyright);
            
            /**
             * Sets (as xml) the "copyright" element
             */
            void xsetCopyright(org.apache.xmlbeans.XmlString copyright);
            
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
             * Gets the "lastBuildDate" element
             */
            java.lang.String getLastBuildDate();
            
            /**
             * Gets (as xml) the "lastBuildDate" element
             */
            org.apache.xmlbeans.XmlString xgetLastBuildDate();
            
            /**
             * Sets the "lastBuildDate" element
             */
            void setLastBuildDate(java.lang.String lastBuildDate);
            
            /**
             * Sets (as xml) the "lastBuildDate" element
             */
            void xsetLastBuildDate(org.apache.xmlbeans.XmlString lastBuildDate);
            
            /**
             * Gets a List of "item" elements
             */
            java.util.List<noNamespace.Item> getItemList();
            
            /**
             * Gets array of all "item" elements
             * @deprecated
             */
            noNamespace.Item[] getItemArray();
            
            /**
             * Gets ith "item" element
             */
            noNamespace.Item getItemArray(int i);
            
            /**
             * Returns number of "item" element
             */
            int sizeOfItemArray();
            
            /**
             * Sets array of all "item" element
             */
            void setItemArray(noNamespace.Item[] itemArray);
            
            /**
             * Sets ith "item" element
             */
            void setItemArray(int i, noNamespace.Item item);
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "item" element
             */
            noNamespace.Item insertNewItem(int i);
            
            /**
             * Appends and returns a new empty value (as xml) as the last "item" element
             */
            noNamespace.Item addNewItem();
            
            /**
             * Removes the ith "item" element
             */
            void removeItem(int i);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static noNamespace.RssDocument.Rss.Channel newInstance() {
                  return (noNamespace.RssDocument.Rss.Channel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static noNamespace.RssDocument.Rss.Channel newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (noNamespace.RssDocument.Rss.Channel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static noNamespace.RssDocument.Rss newInstance() {
              return (noNamespace.RssDocument.Rss) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static noNamespace.RssDocument.Rss newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (noNamespace.RssDocument.Rss) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static noNamespace.RssDocument newInstance() {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static noNamespace.RssDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static noNamespace.RssDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static noNamespace.RssDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static noNamespace.RssDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static noNamespace.RssDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static noNamespace.RssDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static noNamespace.RssDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static noNamespace.RssDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static noNamespace.RssDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static noNamespace.RssDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static noNamespace.RssDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static noNamespace.RssDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static noNamespace.RssDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static noNamespace.RssDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static noNamespace.RssDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static noNamespace.RssDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static noNamespace.RssDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (noNamespace.RssDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
