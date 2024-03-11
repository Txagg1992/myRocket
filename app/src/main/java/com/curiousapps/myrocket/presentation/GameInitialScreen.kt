package com.curiousapps.myrocket.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.curiousapps.myrocket.domain.model.Game

@Composable
fun GameInitialScreen(
    games: LazyPagingItems<Game>
){

    val context = LocalContext.current

    LaunchedEffect(key1 = games.loadState) {
        if (games.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context, "Error: " +
                        (games.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

        Box(modifier = Modifier.fillMaxSize()){
            if (games.loadState.refresh is LoadState.Loading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }else{
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(games){ game ->
                        if (game != null){
                            GameItem(
                                game = game,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                    item {
                        if (games.loadState.append is LoadState.Loading){
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
}