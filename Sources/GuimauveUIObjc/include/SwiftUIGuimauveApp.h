#import <Foundation/Foundation.h>

@interface SwiftUIGuimauveApp: NSObject

@property (readonly) NSString *title;
@property (readonly) NSString *text;
@property (readonly) NSString *icon;
@property (readonly) NSString *url;

- (instancetype)initWithTitle:(NSString *)title
                         text:(NSString *)text
                         icon:(NSString *)icon
                          url:(NSString *)url;

@end
