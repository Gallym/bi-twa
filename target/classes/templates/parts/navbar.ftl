<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Room Reservation System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <#if !known>
                    <a class="nav-link" href="/rooms">Rooms</a>
                <#else>
                    <a class="nav-link" href="/my_rooms">My rooms</a>
                </#if>
            </li>
            <#if known>
            <li class="nav-item">
                <a class="nav-link" href="/reservation/my_reservations">My Reservations</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/reservation/new_reservation">Create Reservation</a>
            </li>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/reservation/my_unapproved_reservations">Unapproved Reservations</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/users">User list</a>
                </li>
                </#if>
            </#if>
        </ul>

        <#if known> <div class="navbar-text mr-3">${name}</div>
        </#if>
        <@l.logout />
    </div>
</nav>
