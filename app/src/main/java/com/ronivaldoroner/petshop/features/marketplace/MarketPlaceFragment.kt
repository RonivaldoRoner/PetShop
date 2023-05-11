package com.ronivaldoroner.petshop.features.marketplace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.ronivaldoroner.petshop.domain.features.marketplace.ProductModel
import com.ronivaldoroner.petshop.helpers.LifecycleDisposable
import com.ronivaldoroner.petshop.ui.theme.PetShopTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MarketPlaceFragment : Fragment(), MarketPlaceListeners {

    private val viewModel by viewModel<MarketPlaceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                LifecycleDisposable(observer = viewModel)

                PetShopTheme {
                    MarketPlaceComposable(
                        screen = viewModel.screen.collectAsState().value,
                        listeners = this@MarketPlaceFragment
                    )
                }
            }
        }
    }

    override fun itemClick(item: ProductModel) {
        Toast.makeText(requireContext(), item.description, Toast.LENGTH_SHORT).show()
    }

    override fun refresh() {
        viewModel.getData()
    }
}