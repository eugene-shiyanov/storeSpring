var StoreApp = Marionette.Application.extend({});

var storeApp = new StoreApp();

storeApp.addRegions({
    mainRegion: '#main-content'
});

storeApp.on('start', function (){
    if (Backbone.history) {
        Backbone.history.start();
    }
});

storeApp.mainMenuController = {
    users: function () {
        storeApp.mainRegion.show(new storeApp.UsersView());
    },

    userGroups: function () {
        storeApp.mainRegion.show(new storeApp.UserGroupsView());
    }
};

storeApp.MainMenuRouter = Marionette.AppRouter.extend({
    controller: storeApp.mainMenuController,
    appRoutes: {
        'users': 'users',
        'userGroups': 'userGroups'
    }
});

storeApp.mainMenuRouter = new storeApp.MainMenuRouter();