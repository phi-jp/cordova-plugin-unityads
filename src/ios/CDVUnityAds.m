#import <Cordova/CDV.h>
#import "CDVUnityAds.h"


@implementation CDVUnityAds

- (void)init:(CDVInvokedUrlCommand *)command {
    NSString* gameId = [command.arguments objectAtIndex:0];
    BOOL isTest = [[command.arguments objectAtIndex: 1] boolValue];
    
    self.gameId = gameId;
    self.isTest = isTest;
    
    [[UnityAds sharedInstance] startWithGameId:self.gameId andViewController:self.viewController];
    [[UnityAds sharedInstance] setTestMode:self.isTest];
    [[UnityAds sharedInstance] setDebugMode:NO];
    [[UnityAds sharedInstance] setDelegate:self];
}

- (void)showAds:(CDVInvokedUrlCommand *)command {
    if ([[UnityAds sharedInstance] canShow] && [[UnityAds sharedInstance] canShowAds]) {
        // If both are ready, show the ad.
        [[UnityAds sharedInstance] show];
    }
}

- (void)unityAdsVideoCompleted:(NSString *)rewardItemKey skipped:(BOOL)skipped {
    CDVPluginResult* pr = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"adsvideocompleted"];
    [self.commandDelegate sendPluginResult:pr callbackId:self.callbackId];
}

@end