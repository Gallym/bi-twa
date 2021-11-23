<#import "parts/common.ftl" as c>

<@c.page>

<h2>Available rooms</h2>

<table class="table table-hover mt-5">

    <thead>
    <tr>
        <th scope="col">Building</th>
        <th scope="col">Name</th>
    </tr>
    </thead>
    <tbody>
    <#list rooms as room>
        <tr>
            <td>${room.getBuilding().getAddress()}</td>
            <td>${room.getName()}</td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>
