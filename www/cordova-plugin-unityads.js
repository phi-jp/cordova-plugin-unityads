var exec = require('cordova/exec');

module.exports = {
  init: function(gameId) {
    exec(success, error, "UnityAds", "init", [gameId]);
  }
};
