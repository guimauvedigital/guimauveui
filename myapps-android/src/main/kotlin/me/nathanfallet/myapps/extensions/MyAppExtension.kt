package me.nathanfallet.myapps.extensions

import me.nathanfallet.myapps.android.R
import me.nathanfallet.myapps.models.MyApp
import me.nathanfallet.myapps.models.MyAppAndroid
import kotlin.enums.EnumEntries

val EnumEntries<MyApp>.android: List<MyAppAndroid>
    get() = this.mapNotNull { it.android }

val MyApp.android: MyAppAndroid?
    get() = when (this) {
        MyApp.LATEXCARDS -> MyAppAndroid(
            displayName,
            R.string.latexcards,
            R.drawable.latexcards,
            "https://play.google.com/store/apps/details?id=me.nathanfallet.latexcards"
        )

        MyApp.MOSAICME -> MyAppAndroid(
            displayName,
            R.string.mosaicme,
            R.drawable.mosaicme,
            "https://play.google.com/store/apps/details?id=me.nathanfallet.mosaicme"
        )

        MyApp.CONVERTY -> MyAppAndroid(
            displayName,
            R.string.converty,
            R.drawable.converty,
            "https://play.google.com/store/apps/details?id=me.nathanfallet.converty"
        )

        MyApp.OCAML -> MyAppAndroid(
            displayName,
            R.string.ocaml,
            R.drawable.ocaml,
            "https://play.google.com/store/apps/details?id=me.nathanfallet.ocaml"
        )

        MyApp.BDEENSISA -> MyAppAndroid(
            displayName,
            R.string.bdeensisa,
            R.drawable.bdeensisa,
            "https://play.google.com/store/apps/details?id=me.nathanfallet.bdeensisa"
        )

        else -> null
    }
