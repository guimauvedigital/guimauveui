//
//  DefaultNavigationView.swift
//  BDE
//
//  Created by Nathan Fallet on 08/02/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

public struct DefaultNavigationView<Content: View>: View {
    
    let content: Content
    
    public init(@ViewBuilder content: () -> Content) {
        self.content = content()
    }
    
    public var body: some View {
        NavigationView {
            DefaultNavigationContainer {
                content
            }
            .navigationBarHidden(true)
        }
        .navigationViewStyle(.stack)
    }
    
}

#Preview {
    DefaultNavigationView {
        Text("Hello world")
            .defaultNavigationTitle("Title")
    }
}
