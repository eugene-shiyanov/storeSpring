<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/template" id="users-template">
    <h1>Users</h1>
    <div id="usersTable"></div>
</script>

<script type="text/template" id="users-table-template">
    <table class="table table-bordered table-condensed table-hover">
        <thead>
        <tr class="active">
            <th class="col-md-2">№</th>
            <th class="col-md-3">Login</th>
            <th class="col-md-3">First Name</th>
            <th class="col-md-3">Last Name</th>
            <th class="col-md-1">Action</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <button id="add-user" class="btn btn-primary"><i class="fa fa-plus"></i></button>
            </td>
        </tr>
        </tfoot>
        <tbody id="usersTableBody">
        </tbody>
    </table>
</script>

<script type="text/template" id="users-table-row-template">
    <\% if (mode && mode === 'edit') { %>
    <td><\%= id %></td>
    <td><input class="login form-control" type="text" value="<\%= login %>"></td>
    <td><input class="firstname form-control" type="text" value="<\%= firstname %>"></td>
    <td><input class="lastname form-control" type="text" value="<\%= lastname %>"></td>
    <td>
        <button class="save btn btn-success"><span class="fa fa-save"></span></button>
        <button class="cancel btn btn-danger"><span class="fa fa-undo"></span></button>
    </td>
    <\% } else { %>
    <td><\%= id %></td>
    <td><\%= login %></td>
    <td><\%= firstname %></td>
    <td><\%= lastname %></td>
    <td>
        <button class="edit btn btn-warning"><span class="fa fa-edit"></span></button>
        <button class="remove btn btn-danger"><span class="fa fa-trash-o"></span></button>
    </td>
    <\% } %>
</script>
