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
    DELTA(
        "Delta: Algorithms",
        R.string.delta,
        R.drawable.delta,
        "https://play.google.com/store/apps/details?id=fr.zabricraft.delta"
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
    EXTOPYANALYTICS(
        "Extopy Analytics",
        R.string.extopyanalytics,
        R.drawable.extopyanalytics,
        "https://play.google.com/store/apps/details?id=me.nathanfallet.extopyanalytics"
    )

}
