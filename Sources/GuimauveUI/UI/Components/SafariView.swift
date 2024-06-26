//
//  SafariView.swift
//  BDE
//
//  Created by Nathan Fallet on 31/01/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SafariServices

public struct SafariView: UIViewControllerRepresentable {
    
    public class SafariViewControllerWrapper: UIViewController {
        
        private var safariViewController: SFSafariViewController?
        
        public var url: URL? {
            didSet {
                if let safariViewController = safariViewController {
                    safariViewController.willMove(toParent: self)
                    safariViewController.view.removeFromSuperview()
                    safariViewController.removeFromParent()
                    self.safariViewController = nil
                }
                
                guard let url = url else { return }
                
                let newSafariViewController = SFSafariViewController(url: url)
                addChild(newSafariViewController)
                newSafariViewController.view.frame = view.frame
                view.addSubview(newSafariViewController.view)
                newSafariViewController.didMove(toParent: self)
                self.safariViewController = newSafariViewController
            }
        }
        
        public override func viewDidLoad() {
            super.viewDidLoad()
            self.url = nil
        }
    }
    
    public typealias UIViewControllerType = SafariViewControllerWrapper
    
    public let url: URL
    
    public init(url: URL) {
        self.url = url
    }

    public func makeUIViewController(context: UIViewControllerRepresentableContext<SafariView>) -> SafariViewControllerWrapper {
        return SafariViewControllerWrapper()
    }

    public func updateUIViewController(
        _ safariViewControllerWrapper: SafariViewControllerWrapper,
        context: UIViewControllerRepresentableContext<SafariView>
    ) {
        safariViewControllerWrapper.url = url
    }
    
}
