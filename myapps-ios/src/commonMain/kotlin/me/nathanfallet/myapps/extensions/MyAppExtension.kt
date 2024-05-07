package me.nathanfallet.myapps.extensions

import me.nathanfallet.myapps.models.MyApp
import me.nathanfallet.myapps.models.MyAppIos
import kotlin.enums.EnumEntries

val EnumEntries<MyApp>.ios: List<MyAppIos>
    get() = this.mapNotNull { it.ios }

val MyApp.ios: MyAppIos?
    get() = when (this) {
        MyApp.LATEXCARDS -> MyAppIos(
            displayName,
            "latexcards",
            "LaTeXCards",
            "https://apps.apple.com/app/latex-cards/id1598813588"
        )

        MyApp.RINGIFY -> MyAppIos(
            displayName,
            "ringify",
            "Ringify",
            "https://apps.apple.com/app/ringify/id1575388217"
        )

        MyApp.MOSAICME -> MyAppIos(
            displayName,
            "mosaicme",
            "MosaicMe",
            "https://apps.apple.com/app/mosaicme/id6498791686"
        )

        MyApp.CONVERTY -> MyAppIos(
            displayName,
            "converty",
            "Converty",
            "https://apps.apple.com/app/base-converter-converty/id1609456234"
        )

        MyApp.OCAML -> MyAppIos(
            displayName,
            "ocaml",
            "OCaml",
            "https://apps.apple.com/app/ocaml-learn-code/id1547506826"
        )

        MyApp.BDEENSISA -> MyAppIos(
            displayName,
            "bdeensisa",
            "BdeEnsisa",
            "https://apps.apple.com/app/bde-de-lensisa/id1669367752"
        )

        else -> null
    }
