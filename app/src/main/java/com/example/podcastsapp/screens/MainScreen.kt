package com.example.podcastsapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.Card
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.podcastsapp.Podcast
import com.example.podcastsapp.R

@Preview
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TopBar(
            text = "Подборка подкастов"
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

@Composable
fun TopBar(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Text(text = text, color = contentColor, style = MaterialTheme.typography.titleLarge, fontSize = 20.sp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_recent),
                contentDescription = "Recent podcasts",
                tint = contentColor
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Recent podcasts",
                tint = contentColor
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PodcastsSection(title: String, modifier: Modifier = Modifier, podcasts: List<Podcast>) {
    Card(modifier = modifier, elevation = 3.dp) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
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
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
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
    Column(modifier = modifier) {
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