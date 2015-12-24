var exec = require('cordova/exec');

module.exports = {
  init: function(gameId, isTest, success, error) {
    isTest = (isTest !== undefined) ? isTest : true;
    exec(success, error, "UnityAds", "init", [gameId, isTest]);
  },

  showVideoAd: function() {
    exec(success, error, "UnityAds", "showVideoAd");
  },

  showRewardedVideoAd: function() {
    exec(success, error, "UnityAds", "showRewardedVideoAd");
  },
};
