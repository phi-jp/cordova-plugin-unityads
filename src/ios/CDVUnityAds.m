#import "CDVUnityAds.h"

@implementation CDVUnityAds

- (void)init:(CDVInvokedUrlCommand *)command {
    NSString* gameId = [command.arguments objectAtIndex:0];
    BOOL isTest = [[command.arguments objectAtIndex: 1] boolValue];
    
    NSLog(@"%@", gameId);
    
    self.gameId = gameId;
    self.isTest = isTest;
}

@end