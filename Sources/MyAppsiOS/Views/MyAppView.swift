//
//  MyAppView.swift
//  
//
//  Created by Nathan Fallet on 28/01/2022.
//

#if canImport(SwiftUI)

import SwiftUI

@available(iOS 14.0, macOS 11.0, watchOS 7.0, *)
struct MyAppView: View {
    
    @Environment(\.openURL) var openURL
    
    @State var app: MyApp

    var body: some View {
        HStack(spacing: 12) {
            Image(app.icon, bundle: .module)
                .resizable()
                .frame(width: 44, height: 44)
                .cornerRadius(8)
                .padding(.vertical, 8)
            VStack(alignment: .leading, spacing: 4) {
                Text(app.name)
                Text(LocalizedStringKey(app.description), bundle: .module)
                    .font(.footnote)
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
