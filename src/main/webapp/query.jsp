<%@ page import="com.epochong.po.Orders" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wangchong
  Date: 2019/8/27
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户订单</title>
</head>
<body>
<%List<Orders> list = (List<Orders>) request.getAttribute("queryResult");%>
<table border="2">
    <tr>
        <th>
            订单ID
        </th>
        <th>
            用户ID
        </th>
        <th>
            订单号
        </th>
    </tr>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
    <tr>
        <td>
            <%=list.get(i).getId()%>
        </td>
        <td>
            <%=list.get(i).getUserId()%>
        </td>
        <td>
            <%=list.get(i).getNumber()%>
        </td>
    </tr>
    <%}%>
    <td><a href="index.jsp">返回主页面</a></td>

</table>
</body>
</html>
