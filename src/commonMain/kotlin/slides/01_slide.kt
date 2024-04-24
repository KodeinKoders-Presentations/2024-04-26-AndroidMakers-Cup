package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.cup.Slides
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.theme.cup.KodeinSourceCode
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.m2.TextWithPlatformEmoji
import org.kodein.emoji.smileys_emotion.face_smiling.Wink


val simple by Slide(
    stepCount = 2
) { step ->

    Text(
        text = "This is a simple Slide !",
        style = MaterialTheme.typography.h1
    )
    Spacer(Modifier.height(32.dp))
    AnimatedVisibility(visible = step >= 1) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextWithPlatformEmoji(
                text = "It has two steps ${Emoji.Wink}",
                style = MaterialTheme.typography.h4
            )
            Text("...which both appear in the step list & the overview!")
        }
    }
}

val simpleSources by Slide(
    stepCount = 4
) { step ->
    KodeinSourceCode(
        sourceCode = rememberSourceCode("kotlin") {
            val dec by marker(highlighted(1))
            val stc by marker(highlighted(2))
            ensureStep(3)

            // language=kotlin
            """
                ${dec}val simpleSlide by Slide${X}(${stc}stepCount = 2${X}) { step ->
                    Text(
                        text = "This is a simple Slide !",
                        style = MaterialTheme.typography.h1
                    )
                    Spacer(Modifier.height(32.dp))
                    ${stc}AnimatedVisibility(visible = step >= 1) {${X}
                        TextWithPlatformEmoji(
                            text = "It has two steps ${'$'}{Emoji.Wink}",
                            style = MaterialTheme.typography.h4
                        )
                    ${stc}}${X}
                }
            """
        },
        step = step
    )
}

val simpleSlides = Slides(
    simple,
    simpleSources
)