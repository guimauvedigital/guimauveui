package me.nathanfallet.myappsandroid.models

import me.nathanfallet.myappsandroid.R

enum class MyApp(val displayname: String, val description: Int, val icon: Int, val url: String) {

    LATEXCARDS(
        "LaTeX Cards",
        R.string.latexcards,
        R.drawable.latexcards,
        "https://play.google.com/store/apps/details?id=me.nathanfallet.latexcards"
    ),
    CONVERTY(
        "Base Converter: Converty",
        R.string.converty,
        R.drawable.converty,
        "https://play.google.com/store/apps/details?id=me.nathanfallet.converty"
    ),
    OCAML(
        "OCaml: Learn & Code",
        R.string.ocaml,
        R.drawable.ocaml,
        "https://play.google.com/store/apps/details?id=me.nathanfallet.ocaml"
    ),
    TICTAITOE(
        "Tic TAI Toe",
        R.string.tictaitoe,
        R.drawable.tictaitoe,
        "https://play.google.com/store/apps/details?id=me.nathanfallet.morpiontpe"
    ),
    BDEENSISA(
        "BDE de l'ENSISA",
        R.string.bdeensisa,
        R.drawable.bdeensisa,
        "https://play.google.com/store/apps/details?id=me.nathanfallet.bdeensisa"
    )

}
