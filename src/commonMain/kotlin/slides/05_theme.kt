package slides

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.cup.PreparedSlide
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.theme.cup.KodeinSourceCode


val theme by PreparedSlide(
    stepCount = 6
) {
    val sourceCode = rememberSourceCode("kotlin") {
        // language=kotlin
        val thm by marker(hidden(0), hidden(5))
        val bgc by marker(hidden(0..1), hidden(5))
        val ctn by marker(hidden(0..2), hidden(5))
        val ctc by marker(hidden(0..3), hidden(5))
        val kdn by marker(onlyShown(5))

        """
            fun main() = cupApplication(title = "Introducing CuP!") {
            ${thm}    MaterialTheme(
                    colors = darkColors(),
                    typography = MaterialTheme.typography.cupScaleDown(),
                ) {${X}
            ${thm}    ${X}    ${kdn}Kodein${X}Presentation(
            ${thm}    ${X}        slides = slides${bgc},${X}
            ${bgc}            backgroundColor = MaterialTheme.colors.background${X}
            ${thm}    ${X}    )${ctn} { slideContent ->${X}
            ${ctc}            CompositionLocalProvider(
                            LocalContentColor provides MaterialTheme.colors.onBackground
                        ) {${X}
            ${ctn}${ctc}    ${X}            slidesContent()${X}
            ${ctc}            }${X}
            ${ctn}        }${X}
            ${thm}    }${X}
            }
        """
    }

    slideContent { step ->
        Text(
            text = "Theme your presentation!",
            style = MaterialTheme.typography.h1
        )
        Spacer(Modifier.height(8.dp))
        KodeinSourceCode(sourceCode, step, TextStyle(fontSize = 10.sp))
    }
}
