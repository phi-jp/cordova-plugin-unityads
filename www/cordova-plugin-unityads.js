var exec = require('cordova/exec');

module.exports = {
  init: function(gameId, isTest, success, error) {
    exec(success, error, "UnityAds", "init", [gameId, isTest]);
  }
};
