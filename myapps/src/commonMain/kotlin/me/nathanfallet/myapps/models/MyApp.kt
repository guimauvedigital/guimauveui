package me.nathanfallet.myapps.models

import me.nathanfallet.usecases.models.IModel

enum class MyApp(val displayName: String) : IModel<String, Unit, Unit> {

    LATEXCARDS("LaTeX Cards"),
    RINGIFY("Ringify"),
    MOSAICME("MosaicMe"),
    CONVERTY("Base Converter: Converty"),
    OCAML("OCaml: Learn & Code"),
    BDEENSISA("BDE de l'ENSISA");

    override val id: String
        get() = name

}
