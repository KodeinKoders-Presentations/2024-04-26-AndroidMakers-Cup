package slides

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.cup.ui.styled
import net.kodein.theme.compose.KodeinLogo
import net.kodein.theme.compose.m2.Link
import net.kodein.theme.cup.kStyled


val outro by Slide {

    Text(
        text = "Thank you!",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h1
    )

    Text(
        text = kStyled { "${+m}Android Makers${-m} - 26/04/2024" },
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle2,
        fontWeight = FontWeight.Light
    )

    Spacer(Modifier.height(16.dp))

    Text(
        text = "Salomon Brys & Romain Boisselle",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.primary
    )

    KodeinLogo(Modifier.height(32.dp))

    Spacer(Modifier.height(32.dp))

    LinksToThisPresentation()

    Spacer(Modifier.height(32.dp))

    Link("https://github.com/KodeinKoders/CuP") {
        Text(
            text = styled { "github.com/KodeinKoders/${+b}CuP${-b}" },
            fontWeight = FontWeight.ExtraLight
        )
    }

}
