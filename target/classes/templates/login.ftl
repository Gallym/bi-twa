<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
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
</@c.page>
