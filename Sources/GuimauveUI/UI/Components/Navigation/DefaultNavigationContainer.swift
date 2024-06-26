//
//  DefaultNavigationContainer.swift
//  BDE
//
//  Created by Nathan Fallet on 08/02/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

public struct DefaultNavigationContainer<Content: View>: View {
    
    let content: Content
    
    @State var title: String = ""
    @State var backButtonHidden: Bool = true
    @State var toolbar: EquatableViewContainer? = nil
    @State var image: EquatableViewContainer? = nil
    
    public init(@ViewBuilder content: () -> Content) {
        self.content = content()
    }
    
    public var body: some View {
        VStack(spacing: 0) {
            DefaultNavigationBar(
                title: title,
                backButtonHidden: backButtonHidden,
                toolbar: toolbar,
                image: image
            )
            content
                .frame(maxWidth: .infinity, maxHeight: .infinity)
                .modifier(BackgroundColorStyle())
        }
        .modifier(BackgroundColorStyle())
        .onPreferenceChange(DefaultNavigationTitlePreferenceKey.self) { value in
            title = value
        }
        .onPreferenceChange(DefaultNavigationBackButtonHiddenPreferenceKey.self) { value in
            backButtonHidden = value
        }
        .onPreferenceChange(DefaultNavigationToolbarPreferenceKey.self) { value in
            toolbar = value
        }
        .onPreferenceChange(DefaultNavigationImagePreferenceKey.self) { value in
            image = value
        }
    }
    
}

#Preview {
    DefaultNavigationContainer {
        Text("Hello world")
            .defaultNavigationTitle("Title")
    }
}
