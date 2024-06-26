#import <Foundation/Foundation.h>
#import "SwiftUIGuimauveApp.h"

@implementation SwiftUIGuimauveApp {
    NSString *_title;
    NSString *_text;
    NSString *_icon;
    NSString *_url;
}

- (instancetype)initWithTitle:(NSString *)title
                         text:(NSString *)text
                         icon:(NSString *)icon
                          url:(NSString *)url {
    self = [super init];
    if (self) {
        _title = [title copy];
        _text = [text copy];
        _icon = [icon copy];
        _url = [url copy];
    }
    return self;
}

@end
