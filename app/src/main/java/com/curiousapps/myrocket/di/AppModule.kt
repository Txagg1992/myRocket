package com.curiousapps.myrocket.di
//
//import android.content.Context
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.room.Room
//import com.curiousapps.myrocket.data.local.GameDatabase
//import com.curiousapps.myrocket.data.local.GameEntity
//import com.curiousapps.myrocket.data.remote.GameApi
//import com.curiousapps.myrocket.data.remote.GameRemoteMediator
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
//import retrofit2.create
//import javax.inject.Singleton
//
//@Module
//@InstallIn(Singleton::class)
//object AppModule {
//
//    @Provides
//    @Singleton
//    fun providesGameDatabase(@ApplicationContext context: Context): GameDatabase{
//        return Room.databaseBuilder(
//            context,
//            GameDatabase::class.java,
//            "games.db"
//        ).build()
//    }
//
//    @Provides
//    @Singleton
//    fun providesGameApi(): GameApi{
//        return Retrofit.Builder()
//            .baseUrl(GameApi.BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//            .create()
//    }
//
//    @Provides
//    @Singleton
//    fun providesGamePager(
//        gameDatabase: GameDatabase,
//        gameApi: GameApi
//        ): Pager<Int, GameEntity>{
//        return Pager(
//            config = PagingConfig(pageSize = 20),
//            remoteMediator = GameRemoteMediator(
//                gameDb = gameDatabase,
//                gameApi = gameApi
//            ),
////            pagingSourceFactory = {
////                gameDatabase.dao.pagingSource()
////            }
//        )
//    }

//}