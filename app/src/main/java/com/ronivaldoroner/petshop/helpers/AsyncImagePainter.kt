package com.ronivaldoroner.petshop.helpers

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import coil.transform.Transformation

@Composable
fun AsyncImagePainter(
    context: Context,
    url: String,
    transformation: Transformation = RoundedCornersTransformation()
) = rememberAsyncImagePainter(
    remember(url) {
        ImageRequest.Builder(context)
            .data(url)
            .transformations(transformation)
            .diskCacheKey(url)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCacheKey(url)
            .build()
    }
)