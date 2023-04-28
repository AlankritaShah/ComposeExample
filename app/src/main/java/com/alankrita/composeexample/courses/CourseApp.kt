package com.alankrita.composeexample.courses

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alankrita.composeexample.R
import com.alankrita.composeexample.courses.data.DataSource
import com.alankrita.composeexample.courses.model.Topic
import com.alankrita.composeexample.ui.theme.ComposeExampleTheme

@Composable
fun CourseApp() {

}

@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Row {
            Image(
                painter = painterResource(id = topic.imageId),
                contentDescription = stringResource(id = topic.titleId),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
                Text(
                    text = stringResource(id = topic.titleId),
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.body2
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.caption),
                        contentDescription = stringResource(id = topic.titleId),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = topic.count.toString(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CourseCardPreview() {
    ComposeExampleTheme {
        CourseCard(topic = Topic(R.string.architecture, 23, R.drawable.image1))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicGrid(courseList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(courseList) { topic ->
            CourseCard(topic)
        }
    }
}

@Preview
@Composable
fun CourseListPreview() {
    ComposeExampleTheme {
        TopicGrid(courseList = DataSource.topics)
    }
}