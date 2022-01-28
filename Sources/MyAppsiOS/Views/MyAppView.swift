//
//  MyAppView.swift
//  
//
//  Created by Nathan Fallet on 28/01/2022.
//

#if canImport(SwiftUI)

import SwiftUI

@available(iOS 13.0, macOS 10.15, watchOS 6.0, *)
struct MyAppView: View {
    
    @State var name: String
    @State var description: String
    @State var image: String

    var body: some View {
        HStack(spacing: 12) {
            Image(image, bundle: .module)
                .resizable()
                .frame(width: 44, height: 44)
                .cornerRadius(8)
                .padding(.vertical, 8)
            VStack(alignment: .leading, spacing: 4) {
                Text(name)
                Text(LocalizedStringKey(description), bundle: .module)
                    .font(.footnote)
                    .foregroundColor(.secondary)
            }
            #if os(iOS)
            Spacer()
            #endif
        }
    }
    
}

#endif
