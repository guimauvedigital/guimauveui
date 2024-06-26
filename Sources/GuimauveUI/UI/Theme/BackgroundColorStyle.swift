//
//  BackgroundColorStyle.swift
//
//
//  Created by Nathan Fallet on 26/06/2024.
//

import SwiftUI

public struct BackgroundColorStyle: ViewModifier {
    
    public init() {}

    public func body(content: Content) -> some View {
        ZStack {
            Color("BackgroundColor", bundle: .module).ignoresSafeArea()
            content
        }
    }
    
}
