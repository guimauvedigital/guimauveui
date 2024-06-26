package software.guimauve.models.apps

import dev.kaccelero.models.IModel
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import software.guimauve.*

enum class GuimauveApp(
    val title: String,
    val text: StringResource,
    val icon: DrawableResource,
    val swiftUIIcon: String? = null,
    val androidUrl: String? = null,
    val iosUrl: String? = null,
) : IModel<String, Unit, Unit> {

    LATEXCARDS(
        "LaTeX Cards",
        Res.string.latexcards,
        Res.drawable.latexcards,
        "LaTeXCards",
        androidUrl = "https://play.google.com/store/apps/details?id=me.nathanfallet.latexcards",
        iosUrl = "https://apps.apple.com/app/latex-cards/id1598813588"
    ),
    RINGIFY(
        "Ringify",
        Res.string.ringify,
        Res.drawable.ringify,
        "Ringify",
        iosUrl = "https://apps.apple.com/app/ringify/id1575388217"
    ),
    MOSAICME(
        "MosaicMe",
        Res.string.mosaicme,
        Res.drawable.mosaicme,
        "MosaicMe",
        androidUrl = "https://play.google.com/store/apps/details?id=me.nathanfallet.mosaicme",
        iosUrl = "https://apps.apple.com/app/mosaicme/id6498791686"
    ),
    IAPUSH(
        "iAPush",
        Res.string.iapush,
        Res.drawable.iapush,
        "iAPush",
        iosUrl = "https://apps.apple.com/app/iapush/id6504343683"
    ),
    CONVERTY(
        "Base Converter: Converty",
        Res.string.converty,
        Res.drawable.converty,
        "Converty",
        androidUrl = "https://play.google.com/store/apps/details?id=me.nathanfallet.converty",
        iosUrl = "https://apps.apple.com/app/base-converter-converty/id1609456234"
    ),
    SUITEBDE(
        "Suite BDE",
        Res.string.suitebde,
        Res.drawable.suitebde,
        "SuiteBde",
        androidUrl = "https://play.google.com/store/apps/details?id=me.nathanfallet.suitebde",
        iosUrl = "https://apps.apple.com/app/suite-bde/id6476325543"
    );

    override val id: String
        get() = name

}
