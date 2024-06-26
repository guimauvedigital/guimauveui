//
//  CardStyle.swift
//
//
//  Created by Nathan Fallet on 26/06/2024.
//

import SwiftUI

public struct CardStyle: ViewModifier {
    
    public init() {}

    public func body(content: Content) -> some View {
        content
            .background(Color("CardColor", bundle: .module))
            .cornerRadius(12)
            .shadow(
                color: Color(.sRGBLinear, white: 0, opacity: 0.15),
                radius: 6, x: 0, y: 2
            )
    }
    
}
