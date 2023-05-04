package com.ronivaldoroner.petshop.features.marketplace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.ronivaldoroner.petshop.ui.theme.PetShopTheme

class MarketPlaceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                PetShopTheme {
                    Text(text = "MarketPlaceFragment")
                }
            }
        }
    }
}