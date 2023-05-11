package com.ronivaldoroner.petshop.features.marketplace

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.ronivaldoroner.petshop.domain.features.marketplace.MarketPlaceScreen
import com.ronivaldoroner.petshop.domain.features.marketplace.ProductModel
import com.ronivaldoroner.petshop.domain.helpers.ResourceStatus
import com.ronivaldoroner.petshop.ui.theme.PetShopTheme

interface MarketPlaceListeners {
    fun itemClick(item: ProductModel)
    fun refresh()
}

@Composable
fun MarketPlaceComposable(
    modifier: Modifier = Modifier,
    screen: MarketPlaceScreen,
    listeners: MarketPlaceListeners
) {
    LazyColumn(modifier = modifier) {
        when (screen.status) {

            is ResourceStatus.Loading -> {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                    )
                }
            }

            is ResourceStatus.Ready -> {
                items(screen.products) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(text = it.description)
                    }
                }
            }

            is ResourceStatus.Error -> {
                item{
                    Text(text= "Aconteceu um erro por aqui")
                    
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    Button(onClick = { listeners.refresh() }) {
                        Text(text = "Tentar novamente")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MarketPlacePreview(
    @PreviewParameter(MarketPlaceFakeData::class) data: MarketPlaceScreen
) {
    PetShopTheme {
        MarketPlaceComposable(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            screen = data,
            listeners = object : MarketPlaceListeners {
                override fun itemClick(item: ProductModel) = Unit
                override fun refresh() = Unit
            }
        )
    }
}