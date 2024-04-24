package slides

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.cup.PreparedSlide
import net.kodein.cup.Slides
import net.kodein.cup.TransitionSet
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.theme.cup.KodeinSourceCode


val speakerNotes by PreparedSlide(
    specs = { copy(endTransitions = zMove) }
) {
    val sourceCode = rememberSourceCode("kotlin") {
        """
            val snSlide by Slide(
                user = SpeakerNotesMD(""${'"'}
                    Look!
                    This slides has some **speaker notes**!
                    
                    - You can use markdown in speaker notes
                    - Or you can use regular compose if you prefer
                    
                    Isn't that cool?
                ""${'"'})
            ) {
                /* slide content */
            }
        """
    }

    slideContent {
        KodeinSourceCode(sourceCode)
    }
}

@OptIn(ExperimentalAnimationApi::class)
val zMove = TransitionSet(
    enter = { fadeIn(tween(1_000)) },
    exit = { fadeOut(tween(1_000)) },
    modifier = { type ->
        val scale by this.transition.animateFloat(
            transitionSpec = { tween(1_000) }
        ) {
            when (it) {
                EnterExitState.PreEnter -> if (type.isForward) 0.4f else 2.5f
                EnterExitState.PostExit -> if (type.isForward) 2.5f else 0.4f
                EnterExitState.Visible -> 1f
            }
        }
        Modifier.scale(scale)
    }
)

val transitions by PreparedSlide(
    stepCount = 3,
    specs = { copy(startTransitions = zMove) }
) {
    val transition = rememberSourceCode("kotlin") {
        // language=kotlin
        """
            val zMove = TransitionSet(
              enter = { fadeIn(tween(1_000)) },
              exit = { fadeOut(tween(1_000)) },
              modifier = { type ->
                val scale by this.transition.animateFloat(
                  transitionSpec = { tween(1_000) }
                ) {
                  when (it) {
                    EnterExitState.PreEnter -> if (type.isForward) 0.4f else 2.5f
                    EnterExitState.PostExit -> if (type.isForward) 2.5f else 0.4f
                    EnterExitState.Visible -> 1f
                  }
                }
                Modifier.scale(scale)
              }
            )
        """
    }
    val slides = rememberSourceCode("kotlin") {
        // language=kotlin
        """
            val slideA = Slide(
                specs = { copy(endTransitions = zMove) }
            ) {}
            val slideB = Slide(
                specs = { copy(startTransitions = zMove) }
            ) {}
        """
    }
    slideContent { step ->
        Text(
            text = "Cool slide transitions!",
            style = MaterialTheme.typography.h1
        )
        Spacer(Modifier.height(8.dp))
        AnimatedVisibility(visible = step == 1) {
            KodeinSourceCode(transition, style = TextStyle(fontSize = 10.sp))
        }
        AnimatedVisibility(visible = step == 2) {
            KodeinSourceCode(slides, style = TextStyle(fontSize = 10.sp))
        }
    }
}

val slideConfigSlides = Slides(
    speakerNotes,
    transitions
)
