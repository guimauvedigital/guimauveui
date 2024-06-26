//
//  DefaultInputStyle.swift
//
//
//  Created by Nathan Fallet on 26/06/2024.
//

import SwiftUI

public struct DefaultInputStyle: TextFieldStyle {
    
    let icon: String?
    
    public init(icon: String? = nil) {
        self.icon = icon
    }
    
    public func _body(configuration: TextField<Self._Label>) -> some View {
        HStack(spacing: 12) {
            if let icon {
                Image(systemName: icon)
                    .resizable()
                    .frame(width: 16, height: 16)
                    .foregroundStyle(Color.secondary)
            }
            configuration
        }
        .padding(.horizontal)
        .padding(.vertical, 12)
        .modifier(CardStyle())
    }
    
}
