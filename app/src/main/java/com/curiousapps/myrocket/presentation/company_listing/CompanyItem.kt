package com.curiousapps.myrocket.presentation.company_listing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.curiousapps.myrocket.domain.model.CompanyListing
import com.curiousapps.myrocket.ui.theme.MyRocketTheme


@Composable
fun CompanyItem(
    company: CompanyListing,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1F)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = company.name,
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                    )

                Spacer(
                    modifier = Modifier.width(4.dp)
                )

                Text(
                    text = company.exchange,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "(${company.symbol})",
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview
@Composable
fun CompanyItemPreview(){
    MyRocketTheme{
        CompanyItem(
            company = CompanyListing(
                name = "Samsung TV, Appliance, Mobile, Receiver, Tablet",
                symbol = "SMSG",
                exchange = "NYSE"
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}