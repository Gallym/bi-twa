<#macro login >
<form action="/login" method="post">
    <div class="form-group row">
        <div class="col-sm-3">
            <input type="text" name="username" class="form-control" placeholder="Email" />
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-3">
            <input type="password" name="password" class="form-control" placeholder="Password" />
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Sign In</button>
</form>
</#macro>

<#include "security.ftl">
<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if known> <button class="btn btn-primary" type="submit">Sign Out</button> </#if>
</form>
<form action="/login" method="get">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !known> <button class="btn btn-primary" type="submit">Sign In</button> </#if>
</form>
</#macro>
