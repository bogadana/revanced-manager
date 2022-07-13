package app.revanced.manager.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.revanced.manager.Global.Companion.socialLinks
import app.revanced.manager.Global.Companion.websiteUrl
import app.revanced.manager.R
import app.revanced.manager.ui.components.AboutDialog
import app.revanced.manager.ui.components.IconHeader
import app.revanced.manager.ui.components.PreferenceRow
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Destination
@RootNavGraph
@Composable
fun AboutScreen(
    //    navigator: NavController,
) {
    Column(Modifier.padding(8.dp)) {
        IconHeader()

        var currentUriHandler = LocalUriHandler.current

        AboutDialog()

        PreferenceRow(
            title = stringResource(R.string.whats_new),
            painter = painterResource(id = R.drawable.ic_baseline_new_releases_24),
            onClick = { currentUriHandler.openUri(websiteUrl) },
        )
        PreferenceRow(
            title = stringResource(R.string.card_contributors_header),
            painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
            onClick = { currentUriHandler.openUri("${websiteUrl}/github") }
        )
        PreferenceRow(
            title = stringResource(R.string.help_translate),
            painter = painterResource(id = R.drawable.ic_translate_black_24dp),
            onClick = { currentUriHandler.openUri(websiteUrl) }
        )

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            for ((social_ic, uri) in socialLinks.entries) {
                IconButton(onClick = { currentUriHandler.openUri(uri) }) {
                    Icon(painter = painterResource(social_ic), contentDescription = "Links", tint = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
}