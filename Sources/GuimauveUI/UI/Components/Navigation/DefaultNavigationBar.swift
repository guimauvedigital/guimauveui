//
//  DefaultNavigationBar.swift
//  BDE
//
//  Created by Nathan Fallet on 08/02/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

public struct DefaultNavigationBar: View {
    
    @Environment(\.presentationMode) var presentationMode
    
    let title: String
    let backButtonHidden: Bool
    let toolbar: EquatableViewContainer?
    let image: EquatableViewContainer?
    
    public init(title: String, backButtonHidden: Bool, toolbar: EquatableViewContainer?, image: EquatableViewContainer?) {
        self.title = title
        self.backButtonHidden = backButtonHidden
        self.toolbar = toolbar
        self.image = image
    }
    
    public var body: some View {
        ZStack(alignment: .top) {
            titleView
            if !backButtonHidden {
                backButtonView
                    .ignoresSafeArea(edges: [])
            }
            toolbarView
                .ignoresSafeArea(edges: [])
        }
    }
    
    var titleView: some View {
        Group {
            if let image {
                image.view
                    .frame(height: 196)
                    .ignoresSafeArea()
                    .overlay {
                        Rectangle()
                            .fill(LinearGradient(
                                colors: [
                                    Color(red: 0, green: 0, blue: 0, opacity: 0),
                                    Color(red: 0, green: 0, blue: 0, opacity: 0.5)
                                ],
                                startPoint: .center,
                                endPoint: .bottom
                            ))
                    }
                    .overlay(alignment: .bottomLeading) {
                        Text(title)
                            .font(.title)
                            .fontWeight(.semibold)
                            .foregroundStyle(.white)
                            .padding()
                    }
            } else {
                Text(title)
                    .font(.title2)
                    .fontWeight(.semibold)
                    .padding()
            }
        }
    }
    
    var backButtonView: some View {
        HStack {
            DefaultNavigationBarButton(
                action: { presentationMode.wrappedValue.dismiss() },
                hasImage: image != nil
            ) {
                Image(systemName: "chevron.left")
                    .font(.title2)
            }
            Spacer()
        }
        .padding()
    }
    
    var toolbarView: some View {
        HStack(spacing: 24) {
            Spacer()
            toolbar?.view
                .font(.title2)
        }
        .padding()
    }
    
}

#Preview {
    Group {
        DefaultNavigationBar(
            title: "Title",
            backButtonHidden: false,
            toolbar: EquatableViewContainer(view: AnyView(Group {
                Image(systemName: "gearshape")
                Image(systemName: "gearshape")
            })),
            image: nil
        )
        DefaultNavigationBar(
            title: "Title",
            backButtonHidden: false,
            toolbar: nil,
            image: EquatableViewContainer(view: AnyView(
                Image("LaTeXCards", bundle: .module).resizable()
            ))
        )
    }
}
