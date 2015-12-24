#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>
#import <UnityAds/UnityAds.h>

@interface CDVUnityAds : CDVPlugin<UnityAdsDelegate>

@property NSString *callbackId;
@property NSString *gameId;
@property BOOL isTest;

- (void)init:(CDVInvokedUrlCommand*)command;
- (void)showAds:(CDVInvokedUrlCommand*)command;

@end
