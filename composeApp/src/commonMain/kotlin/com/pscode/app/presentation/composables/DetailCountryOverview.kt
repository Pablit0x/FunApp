package com.pscode.app.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Translate
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.pscode.app.SharedRes
import com.pscode.app.domain.model.CountryData
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun DetailedCountryOverviewCard(
    selectedCountry: CountryData, hasCapitalCity: Boolean, modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        KamelImage(
            resource = asyncPainterResource(selectedCountry.flagUrl),
            contentDescription = "Country Flag",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 200.dp, height = 120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedBorderCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(percent = 10),
            borderWidth = 1.dp
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {

                DetailCountryInformationItem(
                    icon = Icons.Default.LocationCity,
                    iconDescription = "Capital Icon",
                    key = SharedRes.string.capital.format(number = selectedCountry.capitals.size),
                    value = if (hasCapitalCity) selectedCountry.capitals.joinToString(
                        separator = ", "
                    ) else SharedRes.string.no_capital_city,
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                )


                DetailCountryInformationItem(
                    icon = Icons.Default.Layers,
                    iconDescription = "Area Icon",
                    key = SharedRes.string.area,
                    value = selectedCountry.area.toString(),
                    valueAppendix = " km²",
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 8.dp)
                )


                if (selectedCountry.currency.isNotEmpty()) {
                    DetailCountryInformationItem(
                        icon = Icons.Default.Paid,
                        iconDescription = "Currency Icon",
                        key = SharedRes.string.currency.format(number = selectedCountry.currency.size),
                        value = selectedCountry.currency.joinToString(separator = ", "),
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }

                if (selectedCountry.languages.isNotEmpty()) {
                    DetailCountryInformationItem(
                        icon = Icons.Default.Translate,
                        iconDescription = "Language Icon",
                        key = SharedRes.string.language.format(number = selectedCountry.languages.size),
                        value = selectedCountry.languages.joinToString(separator = ", "),
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }


                DetailCountryInformationItem(
                    icon = Icons.Default.People,
                    iconDescription = "Population Icon",
                    key = SharedRes.string.population,
                    value = formatNumber(number = selectedCountry.population),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 8.dp)
                )

                DetailCountryInformationItem(
                    icon = Icons.Default.Alarm,
                    iconDescription = "Timezone Icon",
                    marqueeEffect = true,
                    key = SharedRes.string.timezone.format(number = selectedCountry.timezones.size),
                    value = selectedCountry.timezones.joinToString(separator = ", "),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                )
            }
        }
    }
}

fun formatNumber(number: Int): String {
    return number.toString().reversed().chunked(3).joinToString(" ").reversed()
}