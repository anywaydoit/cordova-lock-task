var exec = require('cordova/exec');

var PLUGIN_NAME = 'LockTask';

var MyCordovaPlugin = {
  initLock: function(phrase, cb) {
    exec(cb, null, PLUGIN_NAME, 'initLock', []);
  },
  endLock: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'endLock', []);
  }
};

module.exports = LockTask;
