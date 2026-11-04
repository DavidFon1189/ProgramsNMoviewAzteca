package com.david.programsnmoviestvazteca.ui.home.categoriescomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator (
    pageCount: Int,
    currentPage: Int
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
       repeat(pageCount) {index ->
           Box(
               modifier = Modifier
                   .size(
                       if (index == currentPage) 10.dp
                       else 8.dp
                   )
                   .clip(CircleShape)
                   .background(
                       if (index == currentPage)
                           MaterialTheme.colorScheme.primary
                       else
                           MaterialTheme.colorScheme.outlineVariant
                   )
           )

       }
    }

}