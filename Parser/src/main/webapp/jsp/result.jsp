<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head><title>Result Page</title></head>
<body>
<h2>Birthday Postcard</h2>
<table border="2">
    <th>ID</th>
    <th>THEME</th>
    <th>TYPE</th>
    <th>COUNTRY</th>
    <th>YEAR</th>
    <th>IS AUTHOR KNOWN?</th>
    <th>AUTHOR NAME</th>
    <th>VALUE</th>
    <th>WAS SEND</th>
    <th>NAME</th>
    <th>YEAR COUNT</th>
    <th>TEXT</th>
    <th>IS IN VERSE?</th>
    <tr>
        <td name="birthdayCardID">${birthdayCardID}</td>
        <td name="birthdayTheme">${birthdayTheme}</td>
        <td name="birthdayType">${birthdayType}</td>
        <td name="birthdayCountry">${birthdayCountry}</td>
        <td name="birthdayYear">${birthdayYear}</td>
        <td name="birthdayIsKnown">${birthdayIsKnown}</td>
        <td name="birthdayAuthor">${birthdayAuthor}</td>
        <td name="birthdayValue">${birthdayValue}</td>
        <td name="birthdayWasSend">${birthdayWasSend}</td>
        <td name="birthdayName">${birthdayName}</td>
        <td name="birthdayYearCount">${birthdayYearCount}</td>
        <td name="birthdayText">${birthdayText}</td>
        <td name="birthdayIsInVerse">${birthdayIsInVerse}</td>
    </tr>
</table>
<br>
<br>
<h2>Complimentary Postcard</h2>
<table border="2">
    <th>ID</th>
    <th>THEME</th>
    <th>TYPE</th>
    <th>COUNTRY</th>
    <th>YEAR</th>
    <th>IS AUTHOR KNOWN?</th>
    <th>AUTHOR NAME</th>
    <th>VALUE</th>
    <th>WAS SEND</th>
    <th>PLACE</th>
    <th>MEN COUNT</th>
    <tr>
        <td name="complimentaryCardID">${complimentaryCardID}</td>
        <td name="complimentaryTheme">${complimentaryTheme}</td>
        <td name="complimentaryType">${complimentaryType}</td>
        <td name="complimentaryCountry">${complimentaryCountry}</td>
        <td name="complimentaryYear">${complimentaryYear}</td>
        <td name="complimentaryIsKnown">${complimentaryIsKnown}</td>
        <td name="complimentaryAuthor">${complimentaryAuthor}</td>
        <td name="complimentaryValue">${complimentaryValue}</td>
        <td name="complimentaryWasSend">${complimentaryWasSend}</td>
        <td name="complimentaryPlace">${complimentaryPlace}</td>
        <td name="complimentaryMenCount">${complimentaryMenCount}</td>
    </tr>
</table>
</body>
</html>