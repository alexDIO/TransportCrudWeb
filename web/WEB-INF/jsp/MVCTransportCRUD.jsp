
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/4/2014
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tm" uri="/WEB-INF/transportManager.tld"%>
<%@ taglib prefix="mf" uri="/WEB-INF/compareStrings.tld" %>

<%--<%--%>
<%--//    ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());--%>
<%--//    TimeManager timeManagerSession = (TimeManager) context.getBean("timeManagerSession");--%>
<%--//    TimeManager timeManagerSingleton = (TimeManager) context.getBean("timeManagerSingleton");--%>
<%--//    pageContext.setAttribute("timeManagerSession", timeManagerSession);--%>
<%--//    pageContext.setAttribute("timeManagerSingleton", timeManagerSingleton);--%>
<%--%>--%>
<c:set var="buttonName" value="Add"/>

<c:if test="${param['delete'] != null && param['curElemID'] != null}">
    <fmt:parseNumber value="${param['curElemID']}" var="intElemID"/>
    <tm:manageTransportMap holder="${holder}" action="delete" idd="${intElemID}"/>
</c:if>

<c:if test="${'Add' == param['mainButton'] && param['mark'] != null}">
    <tm:manageTransportMap holder="${holder}" action="add" transportType="${param['transportType']}" mark="${param['mark']}" color="${param['color']}" manufactureYear="${param['manufactureYear']}"
            passengersCount="${param['passengersCount']}" energySource="${param['energySource']}" transmission="${param['transmission']}" load="${param['load']}"/>
</c:if>

<c:if test="${param['edit'] != null && param['curElemID'] != null}">
    <c:set var="buttonName" value="Update"/>
    <c:set var="selectedId" value="${holder.map[mf:parseInteger(param['curElemID'])].id}"/>
    <c:set var="selectedTransportType" value="${holder.map[mf:parseInteger(param['curElemID'])].transportType}"/>
    <c:set var="selectedMark" value="${holder.map[mf:parseInteger(param['curElemID'])].mark}"/>
    <c:set var="selectedColor" value="${holder.map[mf:parseInteger(param['curElemID'])].color}"/>
    <c:set var="selectedManufactureYear" value="${holder.map[mf:parseInteger(param['curElemID'])].manufactureYear}"/>
    <c:if test="${selectedTransportType != 'Truck'}">
        <c:if test="${selectedTransportType != 'Coupe' && selectedTransportType != 'Sedan'}">
            <c:set var="selectedPassengersCount" value="${holder.map[mf:parseInteger(param['curElemID'])].passengersCount}"/>
        </c:if>
        <c:if test="${selectedTransportType != 'Bus' && selectedTransportType != 'Trolleybus' && selectedTransportType != 'Tram'}">
            <c:set var="selectedEnergySource" value="${holder.map[mf:parseInteger(param['curElemID'])].energySource}"/>
            <c:set var="selectedTransmission" value="${holder.map[mf:parseInteger(param['curElemID'])].transmission}"/>
        </c:if>
    </c:if>
    <c:if test="${selectedTransportType == 'Truck'}">
        <c:set var="selectedLoad" value="${holder.map[mf:parseInteger(param['curElemID'])].load}"/>
    </c:if>
</c:if>

<c:if test="${'Update' == param['mainButton']}">
    <fmt:parseNumber value="${param['curElemID']}" var="intElemID"/>
    <tm:manageTransportMap holder="${holder}" action="update" transportType="${param['transportType']}" mark="${param['mark']}" color="${param['color']}" manufactureYear="${param['manufactureYear']}"
                           passengersCount="${param['passengersCount']}" energySource="${param['energySource']}" transmission="${param['transmission']}" load="${param['load']}" idd="${param['identifier']}"/>
</c:if>


<html>
<head>
    <title></title>
    <script type="text/javascript">
        function showHide(){
            var selectedValue = document.getElementById("transport").value;
            switch (selectedValue){
                case "coupe":
                    document.getElementById("passengersCountID").style.visibility = "hidden";
                    document.getElementById("passengersCountSpanID").style.visibility = "hidden";
                    document.getElementById("loadID").style.visibility = "hidden";
                    document.getElementById("loadSpanID").style.visibility = "hidden";

                    document.getElementById("energySourceID").style.visibility = "visible";
                    document.getElementById("energySourceSpanID").style.visibility = "visible";
                    document.getElementById("transmissionID").style.visibility = "visible";
                    document.getElementById("transmissionSpanID").style.visibility = "visible";
                    break;
                case "limousine":
                    document.getElementById("loadID").style.visibility = "hidden";
                    document.getElementById("loadSpanID").style.visibility = "hidden";

                    document.getElementById("passengersCountID").style.visibility = "visible";
                    document.getElementById("passengersCountSpanID").style.visibility = "visible";
                    document.getElementById("energySourceID").style.visibility = "visible";
                    document.getElementById("energySourceSpanID").style.visibility = "visible";
                    document.getElementById("transmissionID").style.visibility = "visible";
                    document.getElementById("transmissionSpanID").style.visibility = "visible";
                    break;
                case "sedan":
                    document.getElementById("passengersCountID").style.visibility = "hidden";
                    document.getElementById("passengersCountSpanID").style.visibility = "hidden";
                    document.getElementById("loadID").style.visibility = "hidden";
                    document.getElementById("loadSpanID").style.visibility = "hidden";

                    document.getElementById("energySourceID").style.visibility = "visible";
                    document.getElementById("energySourceSpanID").style.visibility = "visible";
                    document.getElementById("transmissionID").style.visibility = "visible";
                    document.getElementById("transmissionSpanID").style.visibility = "visible";
                    break;
                case "truck":
                    document.getElementById("passengersCountID").style.visibility = "hidden";
                    document.getElementById("passengersCountSpanID").style.visibility = "hidden";
                    document.getElementById("energySourceID").style.visibility = "hidden";
                    document.getElementById("energySourceSpanID").style.visibility = "hidden";
                    document.getElementById("transmissionID").style.visibility = "hidden";
                    document.getElementById("transmissionSpanID").style.visibility = "hidden";

                    document.getElementById("loadID").style.visibility = "visible";
                    document.getElementById("loadSpanID").style.visibility = "visible";
                    break;
                case "bus":
                    document.getElementById("energySourceID").style.visibility = "hidden";
                    document.getElementById("energySourceSpanID").style.visibility = "hidden";
                    document.getElementById("transmissionID").style.visibility = "hidden";
                    document.getElementById("transmissionSpanID").style.visibility = "hidden";
                    document.getElementById("loadID").style.visibility = "hidden";
                    document.getElementById("loadSpanID").style.visibility = "hidden";

                    document.getElementById("passengersCountID").style.visibility = "visible";
                    document.getElementById("passengersCountSpanID").style.visibility = "visible";
                    break;
                case "trolleybus":
                    document.getElementById("energySourceID").style.visibility = "hidden";
                    document.getElementById("energySourceSpanID").style.visibility = "hidden";
                    document.getElementById("transmissionID").style.visibility = "hidden";
                    document.getElementById("transmissionSpanID").style.visibility = "hidden";
                    document.getElementById("loadID").style.visibility = "hidden";
                    document.getElementById("loadSpanID").style.visibility = "hidden";

                    document.getElementById("passengersCountID").style.visibility = "visible";
                    document.getElementById("passengersCountSpanID").style.visibility = "visible";
                    break;
                case "tram":
                    document.getElementById("energySourceID").style.visibility = "hidden";
                    document.getElementById("energySourceSpanID").style.visibility = "hidden";
                    document.getElementById("transmissionID").style.visibility = "hidden";
                    document.getElementById("transmissionSpanID").style.visibility = "hidden";
                    document.getElementById("loadID").style.visibility = "hidden";
                    document.getElementById("loadSpanID").style.visibility = "hidden";

                    document.getElementById("passengersCountID").style.visibility = "visible";
                    document.getElementById("passengersCountSpanID").style.visibility = "visible";
                    break;
                default:
                    document.getElementById("passengersCountID").style.visibility = "visible";
                    document.getElementById("passengersCountSpanID").style.visibility = "visible";
                    document.getElementById("energySourceID").style.visibility = "visible";
                    document.getElementById("energySourceSpanID").style.visibility = "visible";
                    document.getElementById("transmissionID").style.visibility = "visible";
                    document.getElementById("transmissionSpanID").style.visibility = "visible";
                    document.getElementById("loadID").style.visibility = "visible";
                    document.getElementById("loadSpanID").style.visibility = "visible";
            }
        }
    </script>
</head>
<body onload="showHide()">
    <h1>This is Spring MVC</h1>
    <form method="get">
        <table>
            <tr>
                <td>
                    <span>Transport Type</span>
                </td>
                <td>
                    <select name="transportType" id="transport" onchange="showHide()">
                        <option value="limousine" ${mf:isSelected(selectedTransportType,"Limousine")}>limousine</option>
                        <option value="coupe" ${mf:isSelected(selectedTransportType,"Coupe")}>coupe</option>
                        <option value="sedan" ${mf:isSelected(selectedTransportType,"Sedan")}>sedan</option>
                        <option value="truck" ${mf:isSelected(selectedTransportType,"Truck")}>truck</option>
                        <option value="bus" ${mf:isSelected(selectedTransportType,"Bus")}>bus</option>
                        <option value="trolleybus" ${mf:isSelected(selectedTransportType,"Trolleybus")}>trolleybus</option>
                        <option value="tram" ${mf:isSelected(selectedTransportType,"Tram")}>tram</option>
                    </select>
                </td>
                <td>
                    <span>Mark</span>
                </td>
                <td>
                    <select name="mark">
                        <c:forEach var="item" items="${manufacturers.all}" varStatus="loopCounter">
                            <option value="${item.description}" ${mf:isSelected(selectedMark,item.description)}>${item.description}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <span>Color</span>
                </td>
                <td>
                    <select name="color">
                        <option value="black" ${mf:isSelected(selectedColor,"black")}>black</option>
                        <option value="white" ${mf:isSelected(selectedColor,"white")}>white</option>
                        <option value="grey" ${mf:isSelected(selectedColor,"grey")}>grey</option>
                        <option value="red" ${mf:isSelected(selectedColor,"red")}>red</option>
                        <option value="orange" ${mf:isSelected(selectedColor,"orange")}>orange</option>
                        <option value="yellow" ${mf:isSelected(selectedColor,"yellow")}>yellow</option>
                        <option value="blue" ${mf:isSelected(selectedColor,"blue")}>blue</option>
                        <option value="brown" ${mf:isSelected(selectedColor,"brown")}>brown</option>
                    </select>
                </td>
                <td>
                    <span>Manufacture year</span>
                </td>
                <td>
                    <input type="text" name="manufactureYear" value="${selectedManufactureYear}">
                </td>
            </tr>
            <tr>
                <td>
                    <span id="passengersCountSpanID">Passengers count</span>
                </td>
                <td>
                    <input type="text" name="passengersCount" id="passengersCountID" value="${selectedPassengersCount}">
                </td>
                <td>
                    <span id="energySourceSpanID">Energy source</span>
                </td>
                <td>
                    <select name="energySource" id="energySourceID">
                        <option value="petrol" ${mf:isSelected(selectedEnergySource,"petrol")}>petrol</option>
                        <option value="gas" ${mf:isSelected(selectedEnergySource,"gas")}>gas</option>
                        <option value="electricity" ${mf:isSelected(selectedEnergySource,"electricity")}>electricity</option>
                    </select>
                </td>
                <td>
                    <span id="transmissionSpanID">Transmission</span>
                </td>
                <td>
                    <select name="transmission" id="transmissionID">
                        <option value="manual" ${mf:isSelected(selectedTransmission,"manual")}>manual</option>
                        <option value="automate" ${mf:isSelected(selectedTransmission,"automate")}>automate</option>
                    </select>
                </td>
                <td>
                    <span id="loadSpanID">Load</span>
                </td>
                <td>
                    <input type="text" name="load" id="loadID" value="${selectedLoad}">
                </td>
                <td>
                    <input type="hidden" name="identifier" value="${param['curElemID']}">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="mainButton" value="${buttonName}">
                </td>
            </tr>
        </table>
    </form>
    <table>
        <c:forEach var="item" items="${holder.map}" varStatus="loopCounter">
            <tr>
                <td>
                    <c:out value="${item.value}"/>
                </td>
                <td>
                    <form method="get">
                        <input type="submit" name="delete" value="Delete"/>
                        <input type="submit" name="edit" value="Edit"/>
                        <input type="hidden" value="${item.key}" name="curElemID"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <td>
                <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
            </td>
        </tr>
        <tr>
            <td>
                <span>You using application during ${timeManagerSession.duration}</span>
            </td>
        </tr>
        <tr>
            <td>
                <span>Application running during ${timeManagerSingleton.duration}</span>
            </td>
        </tr>
    </table>
</body>
</html>
