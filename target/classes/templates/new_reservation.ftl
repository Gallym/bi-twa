<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <h2>Create new reservation</h2>

    <form action="/reservation/create_reservation" method="post">
        <div class="form-group row">
            <div class="col-sm-3">
                <input type="date" name="date" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-3">
                <select>
                <#list rooms as room >
                    <option name="room" value="${room.name}">${room.name}
                        <input type="hidden" name="room" value="${room.name}" class="form-control"/>
                    </option>
                </#list>
                </select>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Create reservation</button>
    </form>
</@c.page>
