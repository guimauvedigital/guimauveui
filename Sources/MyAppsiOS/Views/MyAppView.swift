//
//  MyAppView.swift
//  
//
//  Created by Nathan Fallet on 28/01/2022.
//

#if canImport(SwiftUI) && !arch(arm)

import SwiftUI

@available(iOS 14.0, macOS 11.0, watchOS 7.0, *)
public struct MyAppView: View {
    
    @Environment(\.openURL) var openURL
    
    var app: MyApp
    
    public init(app: MyApp) {
        self.app = app
    }

    public var body: some View {
        HStack(spacing: 12) {
            Image(app.icon, bundle: .module)
                .resizable()
                .frame(width: 44, height: 44)
                .cornerRadius(8)
            VStack(alignment: .leading, spacing: 4) {
                Text(app.name)
                Text(LocalizedStringKey(app.description), bundle: .module)
                    .foregroundColor(.secondary)
            }
            #if os(iOS)
            Spacer()
            #endif
        }
        .onTapGesture {
            if let url = URL(string: app.url) {
                openURL(url)
            }
        }
    }
    
}

#endif
