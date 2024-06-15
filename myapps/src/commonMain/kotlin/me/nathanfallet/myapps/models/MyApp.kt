package me.nathanfallet.myapps.models

import me.nathanfallet.usecases.models.IModel

enum class MyApp(val displayName: String) : IModel<String, Unit, Unit> {

    LATEXCARDS("LaTeX Cards"),
    RINGIFY("Ringify"),
    MOSAICME("MosaicMe"),
    IAPUSH("iAPush"),
    CONVERTY("Base Converter: Converty"),
    SUITEBDE("Suite BDE");

    override val id: String
        get() = name

}
