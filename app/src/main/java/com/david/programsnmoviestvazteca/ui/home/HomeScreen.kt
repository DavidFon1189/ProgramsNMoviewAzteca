
package com.david.programsnmoviestvazteca.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.david.programsnmoviestvazteca.domain.model.CategoryContent
import com.david.programsnmoviestvazteca.domain.model.MediaContent
import com.david.programsnmoviestvazteca.ui.home.categoriescomponents.FeaturedCarousel
import com.david.programsnmoviestvazteca.ui.home.tvmoviescomponents.MediaCard

@Composable
fun HomeScreen(
    featuredItems: List<CategoryContent>,
    mediaItems: List<MediaContent>,
    onMediaClick: (MediaContent) -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    errorMessage: String? = null,
    isRefreshing: Boolean = false,
    onRefresh: () -> Unit = {}
) {
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item(span = { GridItemSpan(maxLineSpan) }) {
                Column {
                    Text(
                        text = "Destacados",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(16.dp)
                    )

                    FeaturedCarousel(
                        items = featuredItems
                    )
                }
            }

            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = "Películas y programas",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                )
            }

            if (isLoading) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(32.dp)
                    ) {
                        CircularProgressIndicator()

                        Text(
                            text = "Cargando programas...",
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                }
            }

            if (errorMessage != null) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            items(
                items = mediaItems,
                key = { it.id }
            ) { media ->
                MediaCard(
                    media = media,
                    onClick = {
                        onMediaClick(media)
                    },
                    modifier = Modifier.padding(
                        start = 8.dp,
                        end = 8.dp
                    )
                )
            }
        }
    }
}
