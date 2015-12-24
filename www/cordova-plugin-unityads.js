var exec = require('cordova/exec');

module.exports = {
  init: function(gameId, success, error) {
    exec(success, error, "UnityAds", "init", [gameId]);
  }
};
