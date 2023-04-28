package com.alankrita.composeexample.affirmations

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alankrita.composeexample.R
import com.alankrita.composeexample.affirmations.data.Datasource
import com.alankrita.composeexample.affirmations.model.Affirmation
import com.alankrita.composeexample.ui.theme.ComposeExampleTheme

@Composable
fun AffirmationApp() {
    AffirmationListPreview()
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Column {
            Image(
                painter = painterResource(id = affirmation.imageResId),
                contentDescription = stringResource(
                    id = affirmation.stringResId
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = affirmation.stringResId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview
@Composable
fun AffirmationCardPreview() {
    ComposeExampleTheme {
        AffirmationCard(affirmation = Affirmation(R.string.affirmation1, R.drawable.image1))
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(affirmationList) { affirmation ->
            AffirmationCard(affirmation = affirmation)
        }
    }
}

@Preview
@Composable
fun AffirmationListPreview() {
    ComposeExampleTheme {
        AffirmationList(affirmationList = Datasource().loadAffirmations())
    }
}