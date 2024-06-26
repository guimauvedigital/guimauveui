//
//  LottieView.swift
//  BDE
//
//  Created by Nathan Fallet on 07/02/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Lottie
 
public struct LottieView: UIViewRepresentable {
    
    let lottieFile: String
 
    let animationView = LottieAnimationView()
    
    public init(lottieFile: String) {
        self.lottieFile = lottieFile
    }
 
    public func makeUIView(context: Context) -> some UIView {
        let view = UIView(frame: .zero)
 
        animationView.animation = .named(lottieFile)
        animationView.contentMode = .scaleAspectFit
        animationView.loopMode = .loop
        animationView.play()
 
        view.addSubview(animationView)
 
        animationView.translatesAutoresizingMaskIntoConstraints = false
        animationView.heightAnchor.constraint(equalTo: view.heightAnchor).isActive = true
        animationView.widthAnchor.constraint(equalTo: view.widthAnchor).isActive = true
 
        return view
    }
 
    public func updateUIView(_ uiView: UIViewType, context: Context) {
 
    }
    
}
