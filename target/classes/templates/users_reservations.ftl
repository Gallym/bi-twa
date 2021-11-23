<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <h2 class="mt-2">My Reservations</h2>
    <#if reservations??>
        <table class="table table-hover mt-5">
            <thead>
            <tr>
                <th scope="col">Date</th>
                <th scope="col">Room</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list reservations as reservation>
                <tr>
                    <td>${reservation.getDate()}</td>
                    <td>${reservation.getRoom().getName()}</td>
                    <td>${reservation.isApprovedString()}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else> <h1>You have no reservations</h1>
    </#if>
</@c.page>
