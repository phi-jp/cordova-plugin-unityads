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
  init: function(gameId, isTest) {
    isTest = (isTest !== undefined) ? isTest : true;

    var success = function(msg) {
      if (typeof result === 'string') {

      }
    };
    var error = function(e) {
      console.log('UnityAds: error');
    };
    exec(success, error, "UnityAds", "init", [gameId, isTest]);
  },

  showAds: function(callback) {
    this.one('adsdidhide', callback);
    exec(callback, null, "UnityAds", "showAds");
  },

  on: function(eventName, listener) {
    if (!this._listener) {
      this._listener = {};
    }
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
