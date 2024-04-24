package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.cup.PreparedSlide
import net.kodein.cup.Slide
import net.kodein.cup.Slides
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.ui.styled
import net.kodein.theme.compose.m2.Link
import net.kodein.theme.cup.JetBrainsMono
import net.kodein.theme.cup.KodeinSourceCode
import net.kodein.theme.cup.KodeinSourceCodeTheme
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.NotoAnimatedEmoji
import org.kodein.emoji.smileys_emotion.face_affection.HeartEyes


val sourceCode by Slide(
    stepCount = 9
) { step ->
    key(if (step <= 4) "before" else "after") {
        SourceCode(
            step = step,
            sourceCode = rememberSourceCode("kotlin") {
                val mod by marker(onlyShown(1..6))
                val thm by marker(onlyShown(2..6))
                val bgw by marker(onlyShown(0..2))
                val bgb by marker(onlyShown(3..5))
                val fnt by marker(onlyShown(4..6))
                val dcl by marker(onlyShown(0..5))
                val kdn by marker(hidden(0..5))
                val ksc by marker(hidden(0..6))
                val lng by marker(highlighted(8))

                // language=kotlin
                """
                    ${ksc}Kodein${X}SourceCode(
                        sourceCode = rememberSourceCode("kotlin") {
                            ${lng}// language=kotlin${X}
                            ""${'"'}
                                val answer = 42
                            ""${'"'}
                        }${mod},${X}
                    ${thm}    theme = ${dcl}SourceCodeThemes.darcula${X}${kdn}KodeinSourceCodeTheme${X},${X}
                    ${fnt}    style = TextStyle(fontFamily = JetBrainsMono),${X}
                    ${mod}    modifier = Modifier
                            .background(
                                Color.${bgw}White${X}${bgb}Black${X}${kdn}DarkGray${X},
                                RoundedCornerShape(4.dp)
                            )
                            .padding(8.dp)${X}
                    )
                """
            },
            theme = when (step) {
                in 0..1 -> SourceCodeThemes.intelliJLight
                in 2..5 -> SourceCodeThemes.darcula
                else -> KodeinSourceCodeTheme
            },
            style = if (step >= 5) TextStyle(fontFamily = JetBrainsMono, fontSize = 12.sp) else TextStyle(fontFamily = FontFamily.Monospace, fontSize = 12.sp),
            modifier = Modifier
                .background(
                    color = animateColorAsState(
                        targetValue = when (step) {
                            0 -> Color.Transparent
                            in 1..2 -> Color.White
                            in 2..5 -> Color.Black
                            else -> Color.DarkGray
                        },
                        animationSpec = tween(800)
                    ).value,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(8.dp)
        )
    }
}

val preparedSourceCode by PreparedSlide(
    stepCount = 3
) {
    val sourceCode = rememberSourceCode("kotlin") {
        val pre by marker(hidden(0))
        val inl by marker(onlyShown(0..1))
        val vrb by marker(hidden(0..1))
        ensureStep(2)

        // language=kotlin
        """
            val sourceCode by ${pre}Prepared${X}Slide {
            ${vrb}    val code = rememberSourceCode("kotlin") {
                    // language=kotlin
                    ""${'"'}
                        val answer = 42
                    ""${'"'}
                }${X}
            ${pre}    slideContent {${X}
                ${pre}    ${X}SourceCode(${vrb}code)${X}
            ${inl}    ${pre}    ${X}    rememberSourceCode("kotlin") {
                ${pre}    ${X}        // language=kotlin
                ${pre}    ${X}        ""${'"'}
                ${pre}    ${X}            val answer = 42
                ${pre}    ${X}        ""${'"'}
                ${pre}    ${X}    }
                ${pre}    ${X})${X}
            ${pre}    }${X}
            }
        """
    }

    slideContent { step ->
        KodeinSourceCode(sourceCode, step)
    }
}

val animatedSourceCode by PreparedSlide(
    stepCount = 9
) {
    val demo = rememberSourceCode("kotlin") {
        val eql by marker(onlyShown(0))
        val blk by marker(hidden(0))
        val lzy by marker(highlighted(2))

        // language=kotlin
        """
            val a ${eql}=${X}${blk}${lzy}by lazy${X} {${X}
                computeAnswer()
            ${blk}}${X}
        """
    }
    val sourceCode = rememberSourceCode("kotlin") {
        val markers by marker(highlighted(1))
        val eqlm by marker(highlighted(2))
        val blkm by marker(highlighted(3))
        val lzym by marker(highlighted(4))
        ensureStep(5)

        // language=kotlin
        """
            val code = rememberSourceCode("kotlin") {
            ${markers}    ${eqlm}val eql by marker(onlyShown(0))${X}
                ${blkm}val blk by marker(hidden(0))${X}
                ${lzym}val lzy by marker(highlighted(2))${X}
            ${X}
                // language=kotlin
                ""${'"'}
                    val a ${eqlm}${'$'}{eql}=${'$'}{X}${X}${blkm}${'$'}{blk}${lzym}${'$'}{lzy}by lazy${'$'}{X}${X} {${'$'}{X}${X}
                        computeAnswer()
                    ${blkm}${'$'}{blk}}${'$'}{X}${X}
                ""${'"'}
            }
        """
    }
    slideContent { step ->
        AnimatedVisibility(visible = step in 0..2) {
            KodeinSourceCode(demo, step)
        }
        AnimatedVisibility(visible = step !in 0..2) {
            KodeinSourceCode(sourceCode, step - 3)
        }
    }
}

val sourceCodeEditor by Slide(
    stepCount = 2
) { step ->
    Text(
        text = "We are working on an editor",
        style = MaterialTheme.typography.h1
    )
    Spacer(Modifier.height(32.dp))
    NotoAnimatedEmoji(Emoji.HeartEyes, Modifier.size(96.dp))
    AnimatedVisibility(step >= 1) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Outlined.ArrowUpward, null, tint = MaterialTheme.colors.primary)
            Link("https://github.com/kosi-libs/Emoji.kt") {
                Text(
                    text = styled { "github.com/kosi-libs/${+b}Emoji.kt${-b}" },
                    fontWeight = FontWeight.ExtraLight
                )
            }
        }
    }
}

val sourceCodeSlides = Slides(
    sourceCode,
    preparedSourceCode,
    animatedSourceCode,
    sourceCodeEditor
)