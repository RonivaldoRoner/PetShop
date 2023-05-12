package com.ronivaldoroner.petshop.ui.commons.product

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.ronivaldoroner.petshop.domain.features.marketplace.ProductModel
import com.ronivaldoroner.petshop.helpers.AsyncImagePainter
import com.ronivaldoroner.petshop.ui.theme.PetShopTheme
import com.ronivaldoroner.petshop.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItemComposable(
    modifier: Modifier = Modifier,
    data: ProductModel,
    onClick: (ProductModel) -> Unit
) {
    val context = LocalContext.current
    Card(
        modifier = modifier,
        onClick = { onClick(data) },
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(100.dp),
                painter = AsyncImagePainter(
                    context = context,
                    url = data.imageUrl,
                    transformation = CircleCropTransformation()
                ),
                contentDescription = null,
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = data.description,
                    style = Typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Quantidade",
                        style = Typography.bodySmall.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = data.weight,
                        textAlign = TextAlign.Start,
                        style = Typography.bodySmall
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Valor",
                        style = Typography.bodySmall.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = data.amount.toMoney(),
                        textAlign = TextAlign.Start,
                        style = Typography.bodySmall
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Disponibilidade",
                        style = Typography.bodySmall.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = data.quantity.toString(),
                        textAlign = TextAlign.Start,
                        style = Typography.bodySmall
                    )
                }
            }
        }
    }
}

private fun String.toMoney() = "R$ $this"


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ProductItemPreview(
    @PreviewParameter(ProductFakeData::class) data: ProductModel
) {
    PetShopTheme {
        ProductItemComposable(
            modifier = Modifier.fillMaxWidth(),
            data = data,
            onClick = {}
        )
    }
}