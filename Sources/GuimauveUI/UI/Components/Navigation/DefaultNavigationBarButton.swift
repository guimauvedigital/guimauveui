//
//  DefaultNavigationBarButton.swift
//  BDE
//
//  Created by Nathan Fallet on 12/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

public struct DefaultNavigationBarButton<Content: View>: View {
    
    let action: () -> Void
    let hasImage: Bool
    let content: Content
    
    public init(action: @escaping () -> Void, hasImage: Bool, @ViewBuilder content: () -> Content) {
        self.action = action
        self.hasImage = hasImage
        self.content = content()
    }
    
    public var body: some View {
        Button(action: action) {
            content.padding(hasImage ? 16 : 0)
        }
        .background(
            Circle().fill(
                hasImage ? Color("BackgroundColor", bundle: .module) : Color(white: 1, opacity: 0)
            )
        )
    }
    
}

#Preview {
    DefaultNavigationBarButton(
        action: {},
        hasImage: true
    ) {
        
    }
}
