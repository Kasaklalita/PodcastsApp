package com.example.podcastsapp

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(rememberScrollState(), orientation = Orientation.Vertical)
    ) {
        PodcastsSection(
            title = "Топовые подкасты",
            modifier = Modifier.fillMaxWidth(),
            podcasts = listOf(
                Podcast(
                    "Как-нибудь",
                    "libo/libo",
                    painterResource(id = R.drawable.ic_launcher_foreground)
                ),
                Podcast(
                    "Как-нибудь",
                    "libo/libo",
                    painterResource(id = R.drawable.ic_launcher_foreground)
                ),
                Podcast(
                    "Как-нибудь",
                    "libo/libo",
                    painterResource(id = R.drawable.ic_launcher_foreground)
                ),
            )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PodcastsSection(title: String, modifier: Modifier = Modifier, podcasts: List<Podcast>) {
    Card(modifier = modifier, elevation = 15.dp) {
        Column() {
            Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text(text = title)
                Text(text = "БОЛЬШЕ")
            }
            LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = modifier.scale(1.01f)) {
                items(podcasts.size) {
                    PodcastCard(podcasts[it])
//                    Image(
//                        painter = posts[it],
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .aspectRatio(1f)
//                            .border(width = 1.dp, color = Color.White)
//                    )
                }
            }
        }
    }
}

@Composable
fun PodcastCard(podcast: Podcast, modifier: Modifier = Modifier) {
    Column() {
        Image(painter = podcast.image, contentDescription = null)
        Text(text = podcast.title)
        Text(text = podcast.subtitle)
    }
}