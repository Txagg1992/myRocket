package com.curiousapps.myrocket.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.curiousapps.myrocket.domain.Game
import com.curiousapps.myrocket.ui.theme.MyRocketTheme


@Composable
fun GameItem(
    game: Game,
    modifier: Modifier,
){
    val eleDP = 4.dp
    Card(
        modifier = modifier,


    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = game.imageUrl,
                contentDescription = game.name,
                modifier = Modifier
                    .weight(1f)
                    .height(125.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(3f)
            ) {
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = game.deck,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}



@Preview
@Composable
fun GameItemPreview(){
    MyRocketTheme{
        GameItem(
            game = Game(
                0,
                name = "Lots of Fun Game",
                description = "This is an Awesome Game to play all of the time",
                deck = "This is a better description that doesn't have to be formatted",
                imageUrl = null
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}