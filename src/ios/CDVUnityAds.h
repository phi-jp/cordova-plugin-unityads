#import <Cordova/CDVPlugin.h>


@interface CDVUnityAds : CDVPlugin

@property NSString *gameId;
@property BOOL isTest;

- (void) init:(CDVInvokedUrlCommand*) command;

@end
