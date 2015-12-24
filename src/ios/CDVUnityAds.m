#import <Cordova/CDV.h>
#import "CDVUnityAds.h"


@implementation CDVUnityAds

- (void)init:(CDVInvokedUrlCommand *)command {
    NSString* gameId = [command.arguments objectAtIndex:0];
    BOOL isTest = [[command.arguments objectAtIndex: 1] boolValue];
    
    self.gameId = gameId;
    self.isTest = isTest;
    self.callbackId = command.callbackId;
    
    [[UnityAds sharedInstance] startWithGameId:self.gameId andViewController:self.viewController];
    [[UnityAds sharedInstance] setTestMode:self.isTest];
    [[UnityAds sharedInstance] setDebugMode:NO];
    [[UnityAds sharedInstance] setDelegate:self];
    [[UnityAds sharedInstance] setZone:@"rewardedVideoZone"];
}

- (void)showAds:(CDVInvokedUrlCommand *)command {
    if ([[UnityAds sharedInstance] canShow] && [[UnityAds sharedInstance] canShowAds]) {
        // If both are ready, show the ad.
        [[UnityAds sharedInstance] show];
    }
}

- (void)unityAdsFetchCompleted {
    NSLog(@"unityAdsFetchCompleted");
    CDVPluginResult* pr = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"adsvideoloaded"];
    [pr setKeepCallbackAsBool:YES];
    [self.commandDelegate sendPluginResult:pr callbackId:self.callbackId];
}

- (void)unityAdsVideoCompleted:(NSString *)rewardItemKey skipped:(BOOL)skipped {
    // スキップしてない時のみ
    if (!skipped) {
        CDVPluginResult* pr = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"adsvideocompleted"];
        [pr setKeepCallbackAsBool:YES];
        [self.commandDelegate sendPluginResult:pr callbackId:self.callbackId];
    }
}

- (void)unityAdsDidHide {
    CDVPluginResult* pr = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"adsvideohide"];
    [pr setKeepCallbackAsBool:YES];
    [self.commandDelegate sendPluginResult:pr callbackId:self.callbackId];
}

@end