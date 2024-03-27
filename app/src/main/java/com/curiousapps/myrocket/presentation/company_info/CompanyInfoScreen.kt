package com.curiousapps.myrocket.presentation.company_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.curiousapps.myrocket.presentation.destinations.CompanyListingScreenDestination
import com.curiousapps.myrocket.ui.theme.DarkBlue
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun CompanyInfoScreen(
    symbol: String,
    viewModel: CompanyInfoViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
    ) {

    val state = viewModel.state
    if (state.error == null){
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Stock Detail" )
                    },
                    navigationIcon = {
                       IconButton(onClick = {
                           navigator.navigate(
                               CompanyListingScreenDestination
                           )
                       }){
                           Icon(
                               imageVector = Icons.Default.ArrowBack,
                               contentDescription = "Go Back")
                       }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { values ->
            Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
                .padding(values)
        ) {
            state.company?.let { company ->
                Text(
                    text = company.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = company.symbol,
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Industry: ${company.industry}" ,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Country: ${company.country}" ,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp))
                Text(
                    text = company.description ,
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.stockInfo.isNotEmpty()){
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Market Summary")
                    Spacer(modifier = Modifier.height(16.dp))
                    StockChart(
                        infos = state.stockInfo,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .align(CenterHorizontally)
                    )
                }
            }
        }
        }

    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Center
    ){
        if (state.isLoading){
            CircularProgressIndicator()
        }else if (state.error != null){
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}