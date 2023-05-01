package com.alankrita.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alankrita.superheroes.model.Hero
import com.alankrita.superheroes.model.HeroesRepository
import com.alankrita.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetContentHero()
        }
    }
}

@Composable
fun SetContentHero() {
    SuperheroesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            HeroApp()
        }
    }
}

@Composable
fun HeroApp() {
    Scaffold(modifier = Modifier.fillMaxWidth(), topBar = { TopAppBar() }) {
        HeroList()
    }
}

@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HeroList() {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
        ),
        exit = fadeOut()
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            itemsIndexed(HeroesRepository.heroes) { index, hero ->
                HeroItem(
                    hero = hero,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = Spring.StiffnessVeryLow,
                                    dampingRatio = Spring.DampingRatioLowBouncy
                                ),
                                initialOffsetY = { it * (index + 1) } // staggered entrance
                            )
                        )
                )
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            HeroInformation(hero.nameResId, hero.descriptionResId)
            Spacer(modifier = Modifier.weight(1f))
            HeroIcon(hero.imageResId)
        }
    }
}

@Composable
fun HeroIcon(@DrawableRes heroIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(72.dp)
            .clip(RoundedCornerShape(8.dp)),
        painter = painterResource(heroIcon),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
fun HeroInformation(@StringRes heroName: Int, heroDescription: Int, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(end = 16.dp)) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.h3
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.body1
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HeroPreview() {
    SuperheroesTheme(darkTheme = false) {
        HeroApp()
    }
}

@Preview(showBackground = true)
@Composable
fun HeroDarkPreview() {
    SuperheroesTheme(darkTheme = true) {
        HeroApp()
    }
}