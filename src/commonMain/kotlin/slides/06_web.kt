package slides

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide


val web by Slide {
    Text(
        text = "Export to the browser!",
        style = MaterialTheme.typography.h1
    )
    Spacer(Modifier.height(8.dp))
    Text("Not all browsers...")
}