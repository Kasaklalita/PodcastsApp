package com.example.podcastsapp

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(rememberScrollState(), orientation = Orientation.Vertical),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PodcastsSection(
            title = "Топовые подкасты",
            modifier = Modifier.fillMaxWidth(),
            podcasts = listOf(
                Podcast(
                    "Как-нибудь",
                    "libo/libo",
                    painterResource(id = R.drawable.ic_icon)
                ),
                Podcast(
                    "Как-нибудь",
                    "libo/libo",
                    painterResource(id = R.drawable.ic_icon)
                ),
                Podcast(
                    "Как-нибудь",
                    "libo/libo",
                    painterResource(id = R.drawable.ic_icon)
                ),
            )
        )
        PodcastsSection(
            title = "Топовые подкасты",
            modifier = Modifier.fillMaxWidth(),
            podcasts = listOf(
                Podcast(
                    "Как-нибудь",
                    "libo/libo",
                    painterResource(id = R.drawable.ic_icon)
                ),
                Podcast(
                    "Как-нибудь",
                    "libo/libo",
                    painterResource(id = R.drawable.ic_icon)
                ),
                Podcast(
                    "Как-нибудь",
                    "libo/libo",
                    painterResource(id = R.drawable.ic_icon)
                ),
            )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PodcastsSection(title: String, modifier: Modifier = Modifier, podcasts: List<Podcast>) {
    Card(modifier = modifier, elevation = 3.dp) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "БОЛЬШЕ",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
            LazyVerticalGrid(
                cells = GridCells.Fixed(3),
                modifier = modifier.scale(1.01f),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(podcasts.size) {
                    PodcastCard(podcasts[it])
                }
            }
        }
    }
}

@Composable
fun PodcastCard(podcast: Podcast, modifier: Modifier = Modifier) {
    Column() {
        Image(
            painter = podcast.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .aspectRatio(1f),

            )
        Text(text = podcast.title)
        Text(text = podcast.subtitle, style = MaterialTheme.typography.bodySmall)
    }
}