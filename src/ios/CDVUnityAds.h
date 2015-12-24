#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>
#import <UnityAds/UnityAds.h>

@interface CDVUnityAds : CDVPlugin

@property NSString *gameId;
@property BOOL isTest;

- (void)init:(CDVInvokedUrlCommand*)command;
- (void)showVideoAd:(CDVInvokedUrlCommand*)command;
- (void)showRewardedVideoAd:(CDVInvokedUrlCommand*)command;

@end
