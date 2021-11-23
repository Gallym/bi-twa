<#import "parts/common.ftl" as c>

<@c.page>

<h2>List of users</h2>

<table class="table table-hover mt-5">

    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
        <th scope="col">Email</th>
        <th scope="col">Roles</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td><#list user.roles as role>
                ${role.getAuthority()}<br>
                </#list>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>
