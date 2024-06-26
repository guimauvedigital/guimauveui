//
//  DefaultNavigationLink.swift
//  BDE
//
//  Created by Nathan Fallet on 08/02/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

public struct DefaultNavigationLink<Destination: View, Label: View>: View {
    
    let isActive: Binding<Bool>?
    
    let destination: Destination
    let label: Label
    
    public init(
        isActive: Binding<Bool>? = nil,
        destination: Destination,
        @ViewBuilder label: () -> Label = { EmptyView() }
    ) {
        self.isActive = isActive
        self.destination = destination
        self.label = label()
    }
    
    var wrappedDestination: some View {
        DefaultNavigationContainer {
            destination
        }.navigationBarHidden(true)
    }
    
    public var body: some View {
        if let isActive {
            NavigationLink(
                isActive: isActive,
                destination: { wrappedDestination },
                label: { label }
            )
        } else {
            NavigationLink(destination: wrappedDestination) {
                label
            }
        }
        
    }
    
}
