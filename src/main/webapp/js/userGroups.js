storeApp.UserGroupModel = Backbone.Model.extend({
    defaults: {
        id: null,
        name: '',
        mode: ''
    }
});

storeApp.UserGroupCollection = Backbone.Collection.extend({
    model: storeApp.UserGroupModel,
    url: '/userGroups'
});

storeApp.userGroupCollection = new storeApp.UserGroupCollection();

storeApp.UserGroupView = Marionette.ItemView.extend({
    tagName: 'tr',
    template: '#user-groups-table-row-template',
    events: {
        'click .edit': 'editUserGroup',
        'click .save': 'saveUserGroup',
        'click .cancel': 'cancelEditUserGroup',
        'click .remove': 'removeUserGroup'
    },
    initialize: function() {
        this.listenTo(this.model, 'change', this.render);
        this.listenTo(this.model, 'destroy', this.remove);
    },
    editUserGroup: function() {
        this.model.set('mode', 'edit');
    },
    cancelEditUserGroup: function() {
        if (this.model.isNew()) {
            this.model.destroy();
        } else {
            this.model.set('mode', '');
        }
    },
    saveUserGroup: function() {
        var groupName = this.$('input').val();
        this.model.set({name: groupName, mode: ''});
        this.model.save({wait: true});
    },
    removeUserGroup: function() {
        this.model.destroy();
    }
});

storeApp.UserGroupsTableView = Marionette.CompositeView.extend({
    template: '#user-groups-table-template',
    childView: storeApp.UserGroupView,
    childViewContainer: '#userGroupsTableBody',
    events: {
        'click #add-group': 'addUserGroup'
    },
    addUserGroup: function() {
        this.collection.add(new storeApp.UserGroupModel({mode: 'edit'}));
    }
});

storeApp.UserGroupsView = Marionette.LayoutView.extend({
    template: '#user-groups-template',
    regions: {
        table: '#userGroupsTable'
    },
    onBeforeShow: function() {
        storeApp.userGroupCollection.fetch();
        this.showChildView('table', new storeApp.UserGroupsTableView({collection: storeApp.userGroupCollection}));
    }
});
