package com.vini.main;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import noNamespace.Item;
import noNamespace.RssDocument;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("http.proxyHost", "proxy01.gen.eu.mds.honda.com");
	    System.setProperty("http.proxyPort", "8080");
		URLConnection urlConnection = null;
		InputStream input = null;
		try{
			URL url = new URL("http://world.honda.com/rss/news.rss");
			urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);
			urlConnection.connect();
			input = urlConnection.getInputStream();
			RssDocument document = RssDocument.Factory.parse(input);
			System.out.println(document.getRss().getChannel().getTitle());
			System.out.println(document.getRss().getChannel().getPubDate());
			List<Item> items = document.getRss().getChannel().getItemList();
			System.out.println();
			for(Item item: items){
				String flagLink = item.toString().substring(item.toString().indexOf("<hww:flag>")+"<hww:flag>".length(),
						item.toString().indexOf("</hww:flag>"));
				String photLink = item.toString().substring(item.toString().indexOf("<hww:photo>")+"<hww:photo>".length(),
						item.toString().indexOf("</hww:photo>"));
				System.out.println(flagLink);
				System.out.println(photLink);
				System.out.println(item.getTitle());
				System.out.println(item.getDescription()+"\n");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
