//
//  DefaultCard.swift
//  BDE
//
//  Created by Nathan Fallet on 20/02/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

public struct DefaultCard<Icon: View>: View {
    
    let image: Icon
    let title: String
    let description: String
    
    public init(@ViewBuilder image: () -> Icon, title: String, description: String) {
        self.image = image()
        self.title = title
        self.description = description
    }
    
    public var body: some View {
        HStack(spacing: 12) {
            image
                .frame(width: 76, height: 76)
                .clipped()
            VStack(alignment: .leading) {
                Text(title)
                    .lineLimit(1)
                Text(description)
                    .lineLimit(1)
                    .foregroundStyle(.secondary)
            }
            Spacer()
            Image(systemName: "chevron.right")
                .foregroundStyle(.secondary)
                .padding()
        }
        .foregroundColor(.primary)
        .multilineTextAlignment(.leading)
        .modifier(CardStyle())
    }
    
}

#Preview {
    DefaultCard(
        image: {
            Color(UIColor.systemGray3)
                .overlay {
                    Text("A")
                        .font(.title)
                }
        },
        title: "Title",
        description: "Description"
    )
}
