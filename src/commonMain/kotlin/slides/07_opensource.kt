package slides

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.cup.ui.styled
import net.kodein.theme.compose.m2.Link
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.m2.TextWithNotoImageEmoji
import org.kodein.emoji.smileys_emotion.face_smiling.Wink


val openSource by Slide {
    Text(
        text = "Let's Open Source!",
        style = MaterialTheme.typography.h1
    )
    Spacer(Modifier.height(8.dp))
    Link("https://github.com/KodeinKoders/CuP") {
        Text(
            text = styled { "github.com/KodeinKoders/${+b}CuP${-b}" },
            fontWeight = FontWeight.ExtraLight
        )
    }
    Link("https://github.com/KodeinKoders/CuP-Presentation-Template") {
        Text(
            text = styled { "github.com/KodeinKoders/${+b}CuP-Presentation-Template${-b}" },
            fontWeight = FontWeight.ExtraLight
        )
    }
    Spacer(Modifier.height(8.dp))
    TextWithNotoImageEmoji(
        text = "Wait a few days for everything to be deployed ${Emoji.Wink}",
    )
}
