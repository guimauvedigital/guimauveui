//
//  MyAppHeader.swift
//  
//
//  Created by Nathan Fallet on 28/01/2022.
//

#if canImport(SwiftUI)

import SwiftUI

@available(iOS 14.0, macOS 11.0, watchOS 7.0, *)
public struct MyAppHeader: View {
    
    public init() {
        
    }
    
    public var body: some View {
        Text(LocalizedStringKey("header"), bundle: .module)
    }
    
}

#endif
