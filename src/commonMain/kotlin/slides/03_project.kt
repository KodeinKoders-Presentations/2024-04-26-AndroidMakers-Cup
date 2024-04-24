package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kodein.cup.PreparedSlide
import net.kodein.cup.Slides
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotesMD
import net.kodein.theme.cup.KodeinSourceCode


val gradle by PreparedSlide(
    stepCount = 3
) {
    val plugins = rememberSourceCode("kotlin") {
        """
            plugins {
                kotlin("multiplatform") version "1.9.23"
                id("org.jetbrains.compose") version "1.6.2"
                id("net.kodein.cup") version "1.0.0-Beta-01"
            }
        """
    }
    val cup = rememberSourceCode("kotlin") {
        """
            cup {
                targetDesktop()
                targetWeb()
            }
        """
    }
    val dependencies = rememberSourceCode("kotlin") {
        """
            kotlin {
              sourceSets.commonMain.dependencies {
                implementation(cup.sourceCode)
                implementation(cup.plugin.speakerWindow)
                implementation(cup.plugin.laser)
    
                implementation(compose.material)
              }
            }
        """
    }

    slideContent { step ->
        Text(
            text = "build.gradle.kts",
            style = MaterialTheme.typography.h6
        )
        Spacer(Modifier.height(8.dp))
        AnimatedVisibility(step == 0) {
            KodeinSourceCode(plugins)
        }
        AnimatedVisibility(step == 1) {
            KodeinSourceCode(cup)
        }
        AnimatedVisibility(step == 2) {
            KodeinSourceCode(dependencies)
        }
    }
}

val main by PreparedSlide(
    stepCount = 2,
    user = SpeakerNotesMD("""
        Look!
        This slides has some **speaker notes**!
        
        - You can use markdown in speaker notes
        - Or you can use regular compose if you prefer
        
        Isn't that cool?
    """)
) {
    val sourceCode = rememberSourceCode("kotlin") {
        val h by marker(highlighted(1))
        """
            fun main() = cupApplication(
                title = "Introducing CuP!"
            ) {
                Presentation(
                    slides = slides,
                    configuration = {
            ${h}            laser()
                        speakerWindow()
            ${X}        }
                )
            }
        """
    }
    slideContent { step ->
        Text(
            text = "main.kt",
            style = MaterialTheme.typography.h6
        )
        KodeinSourceCode(sourceCode, step)
    }
}

val projectSlides = Slides(
    gradle,
    main
)
