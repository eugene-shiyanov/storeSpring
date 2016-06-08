<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/template" id="user-groups-template">
    <h1>User Groups</h1>
    <div id="userGroupsTable"></div>
</script>

<script type="text/template" id="user-groups-table-template">
    <table class="table table-bordered table-condensed table-hover">
        <thead>
            <tr class="active">
                <th class="col-md-2">№</th>
                <th class="col-md-9">Group name</th>
                <th class="col-md-1">Action</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <td></td>
                <td></td>
                <td>
                    <button id="add-group" class="btn btn-primary"><span class="fa fa-plus"></span></button>
                </td>
            </tr>
        </tfoot>
        <tbody id="userGroupsTableBody">
        </tbody>
    </table>
</script>

<script type="text/template" id="user-groups-table-row-template">
    <\% if (mode && mode === 'edit') { %>
        <td><\%= id %></td>
        <td><input class="form-control" type="text" value="<\%= name %>"></td>
        <td>
            <button class="save btn btn-success"><span class="fa fa-save"></span></button>
            <button class="cancel btn btn-danger"><span class="fa fa-undo"></span></button>
        </td>
    <\% } else { %>
        <td><\%= id %></td>
        <td><\%= name %></td>
        <td>
            <button class="edit btn btn-warning"><span class="fa fa-edit"></span></button>
            <button class="remove btn btn-danger"><span class="fa fa-trash-o"></span></button>
        </td>
    <\% } %>
</script>
