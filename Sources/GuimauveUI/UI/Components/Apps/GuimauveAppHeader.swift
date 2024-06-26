//
//  GuimauveAppHeader.swift
//  
//
//  Created by Nathan Fallet on 28/01/2022.
//

import SwiftUI

public struct GuimauveAppHeader: View {
    
    public init() {}
    
    public var body: some View {
        Text(LocalizedStringKey("header"), bundle: .module)
    }
    
}
