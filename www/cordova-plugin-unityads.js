var exec = require('cordova/exec');


/*

## event
- (void)unityAdsWillShow;
- (void)unityAdsDidShow;
- (void)unityAdsWillHide;
- (void)unityAdsDidHide;
- (void)unityAdsWillLeaveApplication;
- (void)unityAdsVideoStarted;
- (void)unityAdsFetchCompleted;
- (void)unityAdsFetchFailed;

*/
module.exports = {
  _listener: {},

  init: function(gameId, isTest) {
    isTest = (isTest !== undefined) ? isTest : true;

    var self = this;
    var success = function(msg) {
      console.log('UnityAds: success - ' + msg);
      self.fire(msg);
    };
    var error = function(e) {
      console.log('UnityAds: error');
    };
    exec(success, error, "UnityAdsPlugin", "init", [gameId, isTest]);
  },

  showAds: function(callback) {
    this.one('adsvideohide', callback);
    exec(callback, null, "UnityAdsPlugin", "showAds");
  },

  on: function(eventName, listener) {
    this._listener[eventName] = listener;
  },

  one: function(eventName, listener) {
    this.on(eventName, function() {
      listener();
      this.clear(eventName);
    }.bind(this))
  },

  fire: function(eventName) {
    if (!this._listener[eventName]) return ;

    this._listener[eventName]();
  },

  clear: function(eventName) {
    this._listener[eventName] = [];
  },
};
