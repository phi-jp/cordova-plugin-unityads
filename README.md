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
cordova build android
```

## setup

セットアップ

```
cordova create cordova-test
cd cordova-test
cordova platform add ios
cordova plugin add https://github.com/phi-jp/cordova-plugin-unityads.git
cd plugins
rm -rf cordova-plugin-unityads/
ln -s ../../cordova-plugin-unityads
```

## update

反映させる

```
cordova prepare
```