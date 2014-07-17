/*
 * An XML document type.
 * Localname: rss
 * Namespace: 
 * Java type: noNamespace.RssDocument
 *
 * Automatically generated - do not modify.
 */
package noNamespace.impl;
/**
 * A document containing one rss(@) element.
 *
 * This is a complex type.
 */
public class RssDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements noNamespace.RssDocument
{
    private static final long serialVersionUID = 1L;
    
    public RssDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RSS$0 = 
        new javax.xml.namespace.QName("", "rss");
    
    
    /**
     * Gets the "rss" element
     */
    public noNamespace.RssDocument.Rss getRss()
    {
        synchronized (monitor())
        {
            check_orphaned();
            noNamespace.RssDocument.Rss target = null;
            target = (noNamespace.RssDocument.Rss)get_store().find_element_user(RSS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "rss" element
     */
    public void setRss(noNamespace.RssDocument.Rss rss)
    {
        synchronized (monitor())
        {
            check_orphaned();
            noNamespace.RssDocument.Rss target = null;
            target = (noNamespace.RssDocument.Rss)get_store().find_element_user(RSS$0, 0);
            if (target == null)
            {
                target = (noNamespace.RssDocument.Rss)get_store().add_element_user(RSS$0);
            }
            target.set(rss);
        }
    }
    
    /**
     * Appends and returns a new empty "rss" element
     */
    public noNamespace.RssDocument.Rss addNewRss()
    {
        synchronized (monitor())
        {
            check_orphaned();
            noNamespace.RssDocument.Rss target = null;
            target = (noNamespace.RssDocument.Rss)get_store().add_element_user(RSS$0);
            return target;
        }
    }
    /**
     * An XML rss(@).
     *
     * This is a complex type.
     */
    public static class RssImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements noNamespace.RssDocument.Rss
    {
        private static final long serialVersionUID = 1L;
        
        public RssImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CHANNEL$0 = 
            new javax.xml.namespace.QName("", "channel");
        private static final javax.xml.namespace.QName VERSION$2 = 
            new javax.xml.namespace.QName("", "version");
        
        
        /**
         * Gets the "channel" element
         */
        public noNamespace.RssDocument.Rss.Channel getChannel()
        {
            synchronized (monitor())
            {
                check_orphaned();
                noNamespace.RssDocument.Rss.Channel target = null;
                target = (noNamespace.RssDocument.Rss.Channel)get_store().find_element_user(CHANNEL$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "channel" element
         */
        public void setChannel(noNamespace.RssDocument.Rss.Channel channel)
        {
            synchronized (monitor())
            {
                check_orphaned();
                noNamespace.RssDocument.Rss.Channel target = null;
                target = (noNamespace.RssDocument.Rss.Channel)get_store().find_element_user(CHANNEL$0, 0);
                if (target == null)
                {
                    target = (noNamespace.RssDocument.Rss.Channel)get_store().add_element_user(CHANNEL$0);
                }
                target.set(channel);
            }
        }
        
        /**
         * Appends and returns a new empty "channel" element
         */
        public noNamespace.RssDocument.Rss.Channel addNewChannel()
        {
            synchronized (monitor())
            {
                check_orphaned();
                noNamespace.RssDocument.Rss.Channel target = null;
                target = (noNamespace.RssDocument.Rss.Channel)get_store().add_element_user(CHANNEL$0);
                return target;
            }
        }
        
        /**
         * Gets the "version" attribute
         */
        public java.math.BigDecimal getVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    return null;
                }
                return target.getBigDecimalValue();
            }
        }
        
        /**
         * Gets (as xml) the "version" attribute
         */
        public org.apache.xmlbeans.XmlDecimal xgetVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDecimal target = null;
                target = (org.apache.xmlbeans.XmlDecimal)get_store().find_attribute_user(VERSION$2);
                return target;
            }
        }
        
        /**
         * Sets the "version" attribute
         */
        public void setVersion(java.math.BigDecimal version)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VERSION$2);
                }
                target.setBigDecimalValue(version);
            }
        }
        
        /**
         * Sets (as xml) the "version" attribute
         */
        public void xsetVersion(org.apache.xmlbeans.XmlDecimal version)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDecimal target = null;
                target = (org.apache.xmlbeans.XmlDecimal)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().add_attribute_user(VERSION$2);
                }
                target.set(version);
            }
        }
        /**
         * An XML channel(@).
         *
         * This is a complex type.
         */
        public static class ChannelImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements noNamespace.RssDocument.Rss.Channel
        {
            private static final long serialVersionUID = 1L;
            
            public ChannelImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName TITLE$0 = 
                new javax.xml.namespace.QName("", "title");
            private static final javax.xml.namespace.QName LINK$2 = 
                new javax.xml.namespace.QName("", "link");
            private static final javax.xml.namespace.QName DESCRIPTION$4 = 
                new javax.xml.namespace.QName("", "description");
            private static final javax.xml.namespace.QName DOCS$6 = 
                new javax.xml.namespace.QName("", "docs");
            private static final javax.xml.namespace.QName LANGUAGE$8 = 
                new javax.xml.namespace.QName("", "language");
            private static final javax.xml.namespace.QName COPYRIGHT$10 = 
                new javax.xml.namespace.QName("", "copyright");
            private static final javax.xml.namespace.QName PUBDATE$12 = 
                new javax.xml.namespace.QName("", "pubDate");
            private static final javax.xml.namespace.QName LASTBUILDDATE$14 = 
                new javax.xml.namespace.QName("", "lastBuildDate");
            private static final javax.xml.namespace.QName ITEM$16 = 
                new javax.xml.namespace.QName("", "item");
            
            
            /**
             * Gets the "title" element
             */
            public java.lang.String getTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "title" element
             */
            public org.apache.xmlbeans.XmlString xgetTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "title" element
             */
            public void setTitle(java.lang.String title)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TITLE$0);
                    }
                    target.setStringValue(title);
                }
            }
            
            /**
             * Sets (as xml) the "title" element
             */
            public void xsetTitle(org.apache.xmlbeans.XmlString title)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TITLE$0);
                    }
                    target.set(title);
                }
            }
            
            /**
             * Gets the "link" element
             */
            public java.lang.String getLink()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LINK$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "link" element
             */
            public org.apache.xmlbeans.XmlString xgetLink()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LINK$2, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "link" element
             */
            public void setLink(java.lang.String link)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LINK$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LINK$2);
                    }
                    target.setStringValue(link);
                }
            }
            
            /**
             * Sets (as xml) the "link" element
             */
            public void xsetLink(org.apache.xmlbeans.XmlString link)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LINK$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LINK$2);
                    }
                    target.set(link);
                }
            }
            
            /**
             * Gets the "description" element
             */
            public java.lang.String getDescription()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$4, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "description" element
             */
            public org.apache.xmlbeans.XmlString xgetDescription()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$4, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "description" element
             */
            public void setDescription(java.lang.String description)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$4);
                    }
                    target.setStringValue(description);
                }
            }
            
            /**
             * Sets (as xml) the "description" element
             */
            public void xsetDescription(org.apache.xmlbeans.XmlString description)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$4);
                    }
                    target.set(description);
                }
            }
            
            /**
             * Gets the "docs" element
             */
            public java.lang.String getDocs()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCS$6, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "docs" element
             */
            public org.apache.xmlbeans.XmlString xgetDocs()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCS$6, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "docs" element
             */
            public void setDocs(java.lang.String docs)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCS$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCS$6);
                    }
                    target.setStringValue(docs);
                }
            }
            
            /**
             * Sets (as xml) the "docs" element
             */
            public void xsetDocs(org.apache.xmlbeans.XmlString docs)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DOCS$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DOCS$6);
                    }
                    target.set(docs);
                }
            }
            
            /**
             * Gets the "language" element
             */
            public java.lang.String getLanguage()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LANGUAGE$8, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "language" element
             */
            public org.apache.xmlbeans.XmlString xgetLanguage()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LANGUAGE$8, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "language" element
             */
            public void setLanguage(java.lang.String language)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LANGUAGE$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LANGUAGE$8);
                    }
                    target.setStringValue(language);
                }
            }
            
            /**
             * Sets (as xml) the "language" element
             */
            public void xsetLanguage(org.apache.xmlbeans.XmlString language)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LANGUAGE$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LANGUAGE$8);
                    }
                    target.set(language);
                }
            }
            
            /**
             * Gets the "copyright" element
             */
            public java.lang.String getCopyright()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COPYRIGHT$10, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "copyright" element
             */
            public org.apache.xmlbeans.XmlString xgetCopyright()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COPYRIGHT$10, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "copyright" element
             */
            public void setCopyright(java.lang.String copyright)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COPYRIGHT$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COPYRIGHT$10);
                    }
                    target.setStringValue(copyright);
                }
            }
            
            /**
             * Sets (as xml) the "copyright" element
             */
            public void xsetCopyright(org.apache.xmlbeans.XmlString copyright)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COPYRIGHT$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COPYRIGHT$10);
                    }
                    target.set(copyright);
                }
            }
            
            /**
             * Gets the "pubDate" element
             */
            public java.lang.String getPubDate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBDATE$12, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "pubDate" element
             */
            public org.apache.xmlbeans.XmlString xgetPubDate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBDATE$12, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "pubDate" element
             */
            public void setPubDate(java.lang.String pubDate)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUBDATE$12, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUBDATE$12);
                    }
                    target.setStringValue(pubDate);
                }
            }
            
            /**
             * Sets (as xml) the "pubDate" element
             */
            public void xsetPubDate(org.apache.xmlbeans.XmlString pubDate)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUBDATE$12, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PUBDATE$12);
                    }
                    target.set(pubDate);
                }
            }
            
            /**
             * Gets the "lastBuildDate" element
             */
            public java.lang.String getLastBuildDate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTBUILDDATE$14, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "lastBuildDate" element
             */
            public org.apache.xmlbeans.XmlString xgetLastBuildDate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTBUILDDATE$14, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "lastBuildDate" element
             */
            public void setLastBuildDate(java.lang.String lastBuildDate)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTBUILDDATE$14, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LASTBUILDDATE$14);
                    }
                    target.setStringValue(lastBuildDate);
                }
            }
            
            /**
             * Sets (as xml) the "lastBuildDate" element
             */
            public void xsetLastBuildDate(org.apache.xmlbeans.XmlString lastBuildDate)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTBUILDDATE$14, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LASTBUILDDATE$14);
                    }
                    target.set(lastBuildDate);
                }
            }
            
            /**
             * Gets a List of "item" elements
             */
            public java.util.List<noNamespace.Item> getItemList()
            {
                final class ItemList extends java.util.AbstractList<noNamespace.Item>
                {
                    public noNamespace.Item get(int i)
                        { return ChannelImpl.this.getItemArray(i); }
                    
                    public noNamespace.Item set(int i, noNamespace.Item o)
                    {
                      noNamespace.Item old = ChannelImpl.this.getItemArray(i);
                      ChannelImpl.this.setItemArray(i, o);
                      return old;
                    }
                    
                    public void add(int i, noNamespace.Item o)
                        { ChannelImpl.this.insertNewItem(i).set(o); }
                    
                    public noNamespace.Item remove(int i)
                    {
                      noNamespace.Item old = ChannelImpl.this.getItemArray(i);
                      ChannelImpl.this.removeItem(i);
                      return old;
                    }
                    
                    public int size()
                        { return ChannelImpl.this.sizeOfItemArray(); }
                    
                }
                
                synchronized (monitor())
                {
                    check_orphaned();
                    return new ItemList();
                }
            }
            
            /**
             * Gets array of all "item" elements
             * @deprecated
             */
            public noNamespace.Item[] getItemArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    java.util.List<noNamespace.Item> targetList = new java.util.ArrayList<noNamespace.Item>();
                    get_store().find_all_element_users(ITEM$16, targetList);
                    noNamespace.Item[] result = new noNamespace.Item[targetList.size()];
                    targetList.toArray(result);
                    return result;
                }
            }
            
            /**
             * Gets ith "item" element
             */
            public noNamespace.Item getItemArray(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    noNamespace.Item target = null;
                    target = (noNamespace.Item)get_store().find_element_user(ITEM$16, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    return target;
                }
            }
            
            /**
             * Returns number of "item" element
             */
            public int sizeOfItemArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().count_elements(ITEM$16);
                }
            }
            
            /**
             * Sets array of all "item" element
             */
            public void setItemArray(noNamespace.Item[] itemArray)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    arraySetterHelper(itemArray, ITEM$16);
                }
            }
            
            /**
             * Sets ith "item" element
             */
            public void setItemArray(int i, noNamespace.Item item)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    noNamespace.Item target = null;
                    target = (noNamespace.Item)get_store().find_element_user(ITEM$16, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    target.set(item);
                }
            }
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "item" element
             */
            public noNamespace.Item insertNewItem(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    noNamespace.Item target = null;
                    target = (noNamespace.Item)get_store().insert_element_user(ITEM$16, i);
                    return target;
                }
            }
            
            /**
             * Appends and returns a new empty value (as xml) as the last "item" element
             */
            public noNamespace.Item addNewItem()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    noNamespace.Item target = null;
                    target = (noNamespace.Item)get_store().add_element_user(ITEM$16);
                    return target;
                }
            }
            
            /**
             * Removes the ith "item" element
             */
            public void removeItem(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_element(ITEM$16, i);
                }
            }
        }
    }
}
