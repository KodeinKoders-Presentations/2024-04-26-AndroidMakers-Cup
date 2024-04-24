import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.theme.cup.KodeinPresentation
import net.kodein.theme.cup.slides.kodeinActivities
import slides.*


fun main() = cupApplication(
    // TODO: Change title
    title = "Introducing CuP!"
) {
    KodeinPresentation(
        slides = presentationSlides,
    )
}

// TODO: Write your own slides!
val presentationSlides = Slides(
    intro,
    simpleSlides,
    sourceCodeSlides,
    projectSlides,
    slideConfigSlides,
    theme,
    web,
    kodeinActivities,
    outro
)
