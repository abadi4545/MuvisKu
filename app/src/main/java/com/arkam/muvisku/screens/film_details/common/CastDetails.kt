package com.arkam.muvisku.screens.film_details.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkam.muvisku.R
import com.arkam.muvisku.data.remote.responses.CreditsResponse
import com.arkam.muvisku.screens.commons.CastItem
import com.arkam.muvisku.screens.destinations.CastsScreenDestination
import com.arkam.muvisku.ui.theme.primaryPink
import com.arkam.muvisku.util.Constants
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import timber.log.Timber

@Composable
fun CastDetails(
    creditsResponse: CreditsResponse?,
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Cast",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        start = 8.dp
                    )
            )

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "View all",
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 18.sp,
                    color = Color.White
                )

                IconButton(onClick = {
                    Timber.d("${creditsResponse == null}")

                    if (creditsResponse == null) {
                        return@IconButton
                    }
                    navigator.navigate(CastsScreenDestination(creditsResponse))
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chevron_right),
                        tint = primaryPink,
                        contentDescription = null
                    )
                }
            }
        }


        LazyRow(content = {
            items(creditsResponse?.cast!!) { cast ->
                CastItem(
                    size = 90.dp,
                    castImageUrl = "${Constants.IMAGE_BASE_UR}/${cast.profilePath}",
                    castName = cast.name
                )
            }
        })
    }
}