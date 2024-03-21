package com.curiousapps.myrocket.presentation.game_list
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import androidx.paging.Pager
//import androidx.paging.cachedIn
//import androidx.paging.map
//import com.curiousapps.myrocket.data.local.GameEntity
//import com.curiousapps.myrocket.data.mappers.toGame
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.map
//import javax.inject.Inject
//
//@HiltViewModel
//class GameViewModel @Inject constructor(
//    pager: Pager<Int, GameEntity>
//): ViewModel() {
//    val gamePageFlow = pager
//        .flow
//        .map { pagingData ->
//            pagingData.map { it.toGame() }
//
//        }
//        .cachedIn(viewModelScope)
//}