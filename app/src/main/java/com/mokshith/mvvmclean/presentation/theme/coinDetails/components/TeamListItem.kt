package com.mokshith.mvvmclean.presentation.theme.coinDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.mokshith.gittest.mvvmClean.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier
) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Center) {
        Text(text = teamMember.name,
            style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = teamMember.name,
            style = MaterialTheme.typography.bodyMedium,
            fontStyle = FontStyle.Italic)
    }
}