storeApp.UserModel = Backbone.Model.extend({
    defaults: {
        id: null,
        login: '',
        firstname: '',
        lastname: '',
        mode: ''
    }
});

storeApp.UserCollection = Backbone.Collection.extend({
    model: storeApp.UserModel,
    url: '/users'
});

storeApp.userCollection = new storeApp.UserCollection();

storeApp.UserView = Marionette.ItemView.extend({
    tagName: 'tr',
    template: '#users-table-row-template',
    events: {
        'click .edit': 'editUser',
        'click .save': 'saveUser',
        'click .cancel': 'cancelEditUser',
        'click .remove': 'removeUser'
    },
    initialize: function() {
        this.listenTo(this.model, 'change', this.render);
        this.listenTo(this.model, 'destroy', this.remove);
    },
    editUser: function() {
        this.model.set('mode', 'edit');
    },
    cancelEditUser: function() {
        if (this.model.isNew()) {
            this.model.destroy();
        } else {
            this.model.set('mode', '');
        }
    },
    saveUser: function() {
        var attributes = {};
        attributes.login = this.$('input.login').val();
        attributes.firstname = this.$('input.firstname').val();
        attributes.lastname = this.$('input.lastname').val();
        attributes.mode = '';
        this.model.set(attributes);
        this.model.save({wait: true});
    },
    removeUser: function() {
        this.model.destroy();
    }
});

storeApp.UsersTableView = Marionette.CompositeView.extend({
    template: '#users-table-template',
    childView: storeApp.UserView,
    childViewContainer: '#usersTableBody',
    events: {
        'click #add-user': 'addUser'
    },
    addUser: function() {
        this.collection.add(new storeApp.UserModel({mode: 'edit'}));
    }
});

storeApp.UsersView = Marionette.LayoutView.extend({
    template: '#users-template',
    regions: {
        usersTable: '#usersTable'
    },
    onBeforeShow: function() {
        storeApp.userCollection.fetch();
        this.showChildView('usersTable', new storeApp.UsersTableView({collection: storeApp.userCollection}));
    }
});