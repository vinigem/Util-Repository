<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.util.*" %>
<%@ page import="noNamespace.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>Honda News</title>
<style type="text/css">
	body{line-height: 1.4em;font-family: Arial, Helvetica,Verdana,sans-serif;font-style: normal;font-variant: normal;
	background-color: #dbdada;
	}
	.feed-title{
	height: 14px;color: white;text-transform: uppercase;line-height: 13px; padding: 2px 9px; font-size: 11px;
	 background-color: rgb(195,0,35);text-align: center;
	}
	.feed-entries{
	padding-top: 8px;padding-left: 10px; font-size: 1.1em;box-shadow:inset 0px 10px 10px -8px #9b9b9b;
	}
	.feed-entry{height: 50px; margin-bottom: 5px;
	}
	.feed-photo{width: 50px; height: auto;
	}
	.feed-flag{border-color: currentColor;border-width: 0px;border-style: none;
	}
	.feed-entry-title{width:80px;font-weight: normal;margin-left: 3px;vertical-align: top;
	display: inline-block;color: black;font-size: 11px;
	}
	.feed-entry-title a,.feed-entry-title a:VISITED,.feed-entry-title a:ACTIVE{text-decoration: none;
	 height: 45px; overflow: hidden;line-height: 14px;color: black;}
	.feed-entry-title a:hover{color: #9b9b9b;text-decoration: none;}
</style>
</head>
<body>
<%
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
	%>
	<div id="newsContainer" style="float:right; height: 400px; overflow-y:scroll; overflow-x:hidden; width:200px; margin-right:20px; background-color: white;">
	<div class="feed-title"><%=document.getRss().getChannel().getTitle() %></div>
	<div class="feed-entries">
		<% List<Item> items = document.getRss().getChannel().getItemList();
			for(Item item: items){
				String flagLink = item.toString().substring(item.toString().indexOf("<hww:flag>")+"<hww:flag>".length(),
						item.toString().indexOf("</hww:flag>"));
				String photLink = item.toString().substring(item.toString().indexOf("<hww:photo>")+"<hww:photo>".length(),
						item.toString().indexOf("</hww:photo>"));
		%>
		<div class="feed-entry">
			<img alt="photo" src="<%= photLink%>" class="feed-photo">
			<span class="feed-entry-title">
				<a href="<%= item.getLink()%>" target="_new">
					<img alt="flag" src="<%= flagLink%>" class="feed-flag">&nbsp;<%= item.getTitle()%>
				</a>
			</span>
		</div>	
	<%
		}
	%>
	</div>
	</div>
	<%
	}catch (Exception e) {
		e.printStackTrace();
	}
%>
</body>
</html>
