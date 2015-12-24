# cordova-plugin-unityads

cordova-plugin-unityads

```
cordova create cordova-test
cd cordova-test
corodva platform add ios
cordova plugin add cordova-plugin-unityads
cordova emulate ios --target='iPhone-5s'
```

```
cordova plugin add https://github.com/phi-jp/cordova-plugin-unityads.git
cd platforms/ios/HelloCordova/Plugins/
rm -rf cordova-plugin-unityads
ln -s ../../../../../cordova-plugin-unityads/src/ios/ cordova-plugin-unityads
```

```
cordova plugin remove cordova-plugin-unityads
cordova plugin add https://github.com/phi-jp/cordova-plugin-unityads.git
cordova platform remove ios
cordova platform add ios
cordova build ios
```
