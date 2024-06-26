//
//  DefaultNavigationPreferenceKeys.swift
//  BDE
//
//  Created by Nathan Fallet on 08/02/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

public struct DefaultNavigationTitlePreferenceKey: PreferenceKey {
    
    public static var defaultValue: String = ""
    
    public static func reduce(value: inout String, nextValue: () -> String) {
        value = nextValue()
    }
    
}

public struct DefaultNavigationBackButtonHiddenPreferenceKey: PreferenceKey {
    
    public static var defaultValue: Bool = true
    
    public static func reduce(value: inout Bool, nextValue: () -> Bool) {
        value = nextValue()
    }
    
}

public struct DefaultNavigationToolbarPreferenceKey: PreferenceKey {
    
    public static var defaultValue: EquatableViewContainer? = nil
    
    public static func reduce(value: inout EquatableViewContainer?, nextValue: () -> EquatableViewContainer?) {
        value = nextValue()
    }
    
}

public struct DefaultNavigationImagePreferenceKey: PreferenceKey {
    
    public static var defaultValue: EquatableViewContainer? = nil
    
    public static func reduce(value: inout EquatableViewContainer?, nextValue: () -> EquatableViewContainer?) {
        value = nextValue()
    }
    
}

public struct EquatableViewContainer: Equatable {
    
    public let id = UUID().uuidString
    public let view: AnyView
    
    public static func == (lhs: EquatableViewContainer, rhs: EquatableViewContainer) -> Bool {
        return lhs.id == rhs.id
    }
    
}

public extension View {
    
    func defaultNavigationTitle(_ title: String) -> some View {
        preference(key: DefaultNavigationTitlePreferenceKey.self, value: title)
    }
    
    func defaultNavigationBackButtonHidden(_ hidden: Bool) -> some View {
        preference(key: DefaultNavigationBackButtonHiddenPreferenceKey.self, value: hidden)
    }
    
    func defaultNavigationToolbar<Content: View>(@ViewBuilder content: () -> Content) -> some View {
        preference(key: DefaultNavigationToolbarPreferenceKey.self, value: EquatableViewContainer(view: AnyView(content())))
    }
    
    func defaultNavigationImage<Content: View>(@ViewBuilder content: () -> Content) -> some View {
        preference(key: DefaultNavigationImagePreferenceKey.self, value: EquatableViewContainer(view: AnyView(content())))
    }
    
}

extension UINavigationController: UIGestureRecognizerDelegate {
    
    override open func viewDidLoad() {
        super.viewDidLoad()
        interactivePopGestureRecognizer?.delegate = self
    }

    public func gestureRecognizerShouldBegin(_ gestureRecognizer: UIGestureRecognizer) -> Bool {
        return viewControllers.count > 1
    }
    
}
