<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {background-color: #DBF5FF; color: #007AAB;}
table {border-color: #BCEE68;}
th {elevation:higher;border: medium;border-style: dashed;border-color: #CD5C5C;color: #0000FF}
td {elevation:higher;border: medium;border-style: groove;border-color:#CD5C5C; }
a:link {color: green; text-decoration: underline; }
a:active {color: green; text-decoration: underline; }
a:visited {color: green; text-decoration: underline; }
a:hover {color: teal; text-decoration: none; }
input[type="text"]{elevation: higher;border-right-style: outset;border-color: navy;}
input[type="password"]{elevation: higher;border-right-style: outset;border-color: navy;}
input[type="submit"]{color: black;font-weight: bold;}	
}
    
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table border="1" align="center" style="width: 100%;height: 100%;">
    <tr height="20%" >
        <th colspan="2" width="100%"><tiles:insertAttribute name="header" />
        </th>
    </tr>
    <tr height="75%" >
        <th width="15%" ><tiles:insertAttribute name="menu" /></th>
        <th width="85%" ><tiles:insertAttribute name="body" /></th>
    </tr>
    <tr height="20" >
        <th colspan="2"><tiles:insertAttribute name="footer" />
        </th>
    </tr>
</table>
</body>
</html>