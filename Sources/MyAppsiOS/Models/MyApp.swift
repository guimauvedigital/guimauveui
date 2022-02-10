//
//  MyApp.swift
//  
//
//  Created by Nathan Fallet on 28/01/2022.
//

import Foundation

public struct MyApp: Identifiable {
    
    // Identifiable
    
    public var id: String { name }
    
    // Properties
    
    public let name: String
    public let description: String
    public let icon: String
    public let url: String
    
    // Constants
    
    public static let values = [
        MyApp(
            name: "Ringify",
            description: "ringify",
            icon: "Ringify",
            url: "https://apps.apple.com/app/ringify/id1575388217"
        ),
        MyApp(
            name: "LaTeX Cards",
            description: "latexcards",
            icon: "LaTeXCards",
            url: "https://apps.apple.com/app/latex-cards/id1598813588"
        ),
        MyApp(
            name: "Converty: Number conversion",
            description: "converty",
            icon: "Converty",
            url: "https://apps.apple.com/app/converty-number-conversion/id1609456234"
        ),
        MyApp(
            name: "Delta: Algorithms",
            description: "delta",
            icon: "Delta",
            url: "https://apps.apple.com/app/delta-algorithms/id1436506800"
        ),
        MyApp(
            name: "OCaml: Learn & Code",
            description: "ocaml",
            icon: "OCaml",
            url: "https://apps.apple.com/app/ocaml-learn-code/id1547506826"
        ),
        MyApp(
            name: "Tic TAI Toe",
            description: "tictaitoe",
            icon: "TicTAIToe",
            url: "https://apps.apple.com/app/tic-tai-toe/id1459186328"
        ),
        MyApp(
            name: "Extopy Analytics",
            description: "extopyanalytics",
            icon: "ExtopyAnalytics",
            url: "https://apps.apple.com/app/extopy-analytics/id1493353835"
        ),
    ]
    
}
